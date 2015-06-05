package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.Dictionary;
import demo.repository.DictionaryRepository;

@Service
public class DictionaryServiceImpl implements DictionaryService{
	
	@Autowired
	private DictionaryRepository dictionaryRepository;
	
	@Override
	public List<Dictionary> findAllDictionaries(){
		return (List<Dictionary>) dictionaryRepository.findAll();
	}
	
	@Override
	public void saveDictionary(Dictionary dictionary){
		dictionaryRepository.save(dictionary);
	}
	
	@Override
	public List<Dictionary> formatDictionaryListToJSON(List<Dictionary> lisDictionaries){
		for(Dictionary dictionary : lisDictionaries)
			dictionary.setUsers(null);
		return lisDictionaries;
	}
	
	
}
