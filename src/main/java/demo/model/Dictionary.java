package demo.model;

import java.util.List;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dictionary")
public class Dictionary {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "language_1")
	private String language1;
	
	@Column(name = "language_2")
	private String language2;
	
	@Column(name = "name")
	private String name;
	
	//@OneToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "owner")
	@Column(name = "owner")
	private Integer owner;
	
	@Column(name = "max_score")
	private Float maxScore;
	
	@Column(name = "best_time")
	private Date bestTime;
	
	@ManyToMany(mappedBy = "dictionaries", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<User> users;
	
	public Dictionary() {
		super();
	}

	public Dictionary(String language1, String language2,
			String name, Integer owner) {
		super();
		//this.id = id;
		this.language1 = language1;
		this.language2 = language2;
		this.name = name;
		this.owner = owner;
	}

	
	
	public Dictionary(Integer id, String language1, String language2,
			String name, Integer owner, Float maxScore, Date bestTime,
			List<User> users) {
		super();
		this.id = id;
		this.language1 = language1;
		this.language2 = language2;
		this.name = name;
		this.owner = owner;
		this.maxScore = maxScore;
		this.bestTime = bestTime;
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOwner() {
		return owner;
	}

	public void setOwner(Integer owner) {
		this.owner = owner;
	}

	public Float getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(Float maxScore) {
		this.maxScore = maxScore;
	}

	public Date getBestTime() {
		return bestTime;
	}

	public void setBestTime(Date bestTime) {
		this.bestTime = bestTime;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
}
