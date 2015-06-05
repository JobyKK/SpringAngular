package demo.service;

import java.util.List;

import demo.model.Dictionary;

public interface DictionaryService {

	List<Dictionary> findAllDictionaries();

	void saveDictionary(Dictionary dictionary);

	List<Dictionary> formatDictionaryListToJSON(List<Dictionary> lisDictionaries);

}
