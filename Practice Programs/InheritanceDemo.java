package Test;

class Emp
{
	int id;
	String name;
	String address;
	
	public Emp(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}

class Manager extends Emp
{
	String department;

	public Manager(int id, String name, String address, String department) {
		super(id, name, address);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}

public class InheritanceDemo {

	public static void main(String[] args) {
		
		Manager obj1 = new Manager(1,"Ram","Ayodhya","Development");
		Manager obj2 = new Manager(2,"Shyam","Vrindavan","Recovery");
		
		System.out.print("Id = "+obj1.getId());
		System.out.print("\t Name = "+obj1.getName());
		System.out.print("\tAddress = "+obj1.getAddress());
		System.out.print("\tDepartment = "+obj1.getDepartment());
		
		System.out.print("\nId = "+obj2.getId());
		System.out.print("\t Name = "+obj2.getName());
		System.out.print("\tAddress = "+obj2.getAddress());
		System.out.print("\tDepartment = "+obj2.getDepartment());
		
	}

}
