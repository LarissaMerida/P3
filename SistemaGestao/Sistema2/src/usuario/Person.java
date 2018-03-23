package usuario;

public class Person {
	public String name;
	public String email;
	public boolean resource;
	
	
	public Person(String name, String email)
	{
		super();
		this.name = name;
		this.email = email;
	}
	public Person(String name)
	{
		super();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
