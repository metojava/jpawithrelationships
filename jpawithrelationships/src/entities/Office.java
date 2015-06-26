package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Office {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int oid;
	private String name;

	public Office() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Office(int oid, String name) {
		super();
		this.oid = oid;
		this.name = name;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
