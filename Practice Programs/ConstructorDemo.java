package Test;

public class ConstructorDemo {

	int id;
	String name;
	String address;
	
	
	public ConstructorDemo() {
		super();
	}

	public ConstructorDemo(int id, String name, String address) {
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

	

	public static void main(String[] args) {
		
		ConstructorDemo obj1 =new ConstructorDemo(1,"Ram","Ayodhya");
		ConstructorDemo obj2 =new ConstructorDemo(2,"Shyam","Mathura");
		ConstructorDemo obj3 =new ConstructorDemo();
		ConstructorDemo obj4 =new ConstructorDemo();
		
		System.out.println(obj1.getId() +"\t" + obj1.getName()+"\t" +obj1.getAddress());
		System.out.println(obj2.getId() +"\t" + obj2.getName()+"\t" +obj2.getAddress());
		
		System.out.println(obj3.getId() +"\t" + obj3.getName()+"\t" +obj3.getAddress());
		System.out.println(obj4.getId() +"\t" + obj4.getName()+"\t" +obj4.getAddress());

	}

}
