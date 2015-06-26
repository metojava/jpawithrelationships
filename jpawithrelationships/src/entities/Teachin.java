package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Teachin")
public class Teachin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tid")
	private int tid;

	@Column(name = "tname")
	private String tname;

	@Column(name = "author")
	private String author;

	@OneToMany(targetEntity = User.class)
	private List userList;

	public Teachin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teachin(int tid, String tname, String author, List userList) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.author = author;
		this.userList = userList;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List getUserList() {
		return userList;
	}

	public void setUserList(List userList) {
		this.userList = userList;
	}
}
