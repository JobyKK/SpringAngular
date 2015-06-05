package demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import demo.model.Dictionary;


@Repository
public interface DictionaryRepository extends CrudRepository<Dictionary, Integer>{
	
}
