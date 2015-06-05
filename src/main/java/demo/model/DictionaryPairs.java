package demo.model;

import java.util.ArrayList;

/**
 * Entity to save like a file.
 * */
public class DictionaryPairs{

	private ArrayList<Pair> pairs;
	private String name;
	private String language1;
	private String language2;
	
	public DictionaryPairs() {
		
	}
	
	public DictionaryPairs(ArrayList<Pair> pairs, String name,
			String language1, String language2) {
		super();
		this.pairs = pairs;
		this.name = name;
		this.language1 = language1;
		this.language2 = language2;
	}



	public String getLanguage1() {
		return language1;
	}

	public void setLanguage1(String language1) {
		this.language1 = language1;
	}

	public String getLanguage2() {
		return language2;
	}

	public void setLanguage2(String language2) {
		this.language2 = language2;
	}

	public ArrayList<Pair> getPairs() {
		return pairs;
	}
	
	public void setPairs(ArrayList<Pair> pairs) {
		this.pairs = pairs;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

class Pair{

	private String word1;
	private String word2;
	
	public Pair(){
	}
	
	public Pair(String word1, String word2) {
		super();
		this.word1 = word1;
		this.word2 = word2;
	}

	public String getWord1() {
		return word1;
	}

	public void setWord1(String word1) {
		this.word1 = word1;
	}

	public String getWord2() {
		return word2;
	}

	public void setWord2(String word2) {
		this.word2 = word2;
	}
	
	
}