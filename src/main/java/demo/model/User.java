package demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "second_name")
	private String secondName;
	
	@Column(name = "nick")
	private String nick;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "sign_up_date")
	private String signUpDate;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)//lazy in next update
	@JoinTable(name = "user_dictionary",
				joinColumns = @JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "dictionary_id"))
	private List<Dictionary> dictionaries;
	
	public User() {
		super();
	}

	public User(Integer id) {
		super();
		this.id = id;
	}

	public User(Integer id, String firstName, String secondName, String status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.status = status;
	}
	
	/**For web form*/
	public User(String status, String nick, String email, String password) {
		super();
		this.status = status;
		this.nick = nick;
		this.email = email;
		this.password = password;
	}

	public User(String firstName, String secondName, String nick, String email,
			String signUpDate) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.nick = nick;
		this.email = email;
		this.signUpDate = signUpDate;
	}
	
	public User(Integer id, String firstName, String secondName, String nick,
			String email, String password, String signUpDate, String status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.nick = nick;
		this.email = email;
		this.password = password;
		this.signUpDate = signUpDate;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(String signUpDate) {
		this.signUpDate = signUpDate;
	}

	public List<Dictionary> getDictionaries() {
		return dictionaries;
	}

	public void setDictionaries(List<Dictionary> dictionaries) {
		this.dictionaries = dictionaries;
	}
		
	
	
}
