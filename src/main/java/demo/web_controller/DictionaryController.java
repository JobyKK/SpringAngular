package demo.web_controller;



import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import demo.model.Dictionary;
import demo.model.User;
import demo.security.MyUserDetails;
import demo.service.DictionaryServiceImpl;

@Controller
@RequestMapping("/dict")
public class DictionaryController {

	@Autowired
	DictionaryServiceImpl dictionaryService;
	
	@RequestMapping("/")
	public String showAllDictionaries(ModelMap model, Principal principal){
		List<Dictionary> dlList = dictionaryService.findAllDictionaries();
		for(Dictionary d : dlList)
			for(User user : d.getUsers())
				System.out.println(user.getStatus());
		MyUserDetails activeUser = (MyUserDetails) ((Authentication) principal).getPrincipal();
		return "dict_show";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Dictionary addDictionary(@RequestBody Dictionary dictionary){
		dictionaryService.saveDictionary(dictionary);
		return dictionary;
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public List<Dictionary> showJsonDictionaries(){
		List<Dictionary> dlList = dictionaryService.findAllDictionaries();
		for(Dictionary d : dlList)
			for(User user : d.getUsers())
				System.out.println(user.getStatus());
		
		return dictionaryService.formatDictionaryListToJSON(dlList);
	}
}
