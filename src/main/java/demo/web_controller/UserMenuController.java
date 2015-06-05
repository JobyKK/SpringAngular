package demo.web_controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import demo.model.Dictionary;
import demo.model.User;
import demo.security.MyUserDetails;
import demo.service.DictionaryServiceImpl;
import demo.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserMenuController {

	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	DictionaryServiceImpl dictionaryService;
	
	/**
	 * Get user info for user menu.
	 * */
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public User getUserInfo(ModelMap model, Principal principal){
		System.out.println("user json used");
		MyUserDetails activeUser = (MyUserDetails) ((Authentication) principal).getPrincipal();
			return new User(
					activeUser.getUser().getFirstName(),
					activeUser.getUser().getSecondName(),
					activeUser.getUser().getNick(),
					activeUser.getUser().getEmail(),
					activeUser.getUser().getSignUpDate());
	}

	/**
	 * Get user dictionaries.
	 * */
	@RequestMapping(value = "/dicts/json")
	public List<Dictionary> getUserDictionaries(ModelMap model, Principal principal){
		System.out.println("dict json used");
		MyUserDetails activeUser = (MyUserDetails) ((Authentication) principal).getPrincipal();
			return dictionaryService.formatDictionaryListToJSON(
					activeUser.getUser().getDictionaries());
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public ResponseEntity<String> showTest(){
		return new ResponseEntity<String>("test",HttpStatus.OK);
	}
	
	/**
	 * Save dictionary in user menu.
	 * */
	@RequestMapping(value = "/dict", method = RequestMethod.POST)
	public Map<String, Object> addDictionary(@RequestBody  Dictionary dictionary, Principal principal){
		System.out.println("post " + dictionary.getName());
		
		MyUserDetails activeUser = (MyUserDetails) ((Authentication) principal).getPrincipal();
		dictionary.setOwner(activeUser.getUser().getId());
		dictionaryService.saveDictionary(dictionary);
		activeUser.getUser().getDictionaries().add(dictionary);
		userService.updateUser(activeUser.getUser());
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("text", "done");
		
		return model;
	}
	
}
