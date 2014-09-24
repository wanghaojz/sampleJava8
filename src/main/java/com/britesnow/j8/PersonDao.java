package test.java.com.project.devtest.dao;

public class PersonDao {
	
	private String id;
	private String name;
	private String sex;
	private String work;
	private String description;
	
	
	
	public PersonDao(String id, String name, String sex, String work,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.work = work;
		this.description = description;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getmark(){
		return  work+","+"Please get out!";
	}
	

}
