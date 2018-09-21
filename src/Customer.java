
public class Customer {
	private String name;
	private String phone;

	public Customer() {
		this.phone = "";
		this.name = "";
	}

	public Customer(String n, String p) {
		this.name = n;
		this.phone = parsePhone(p);
	}

	public void setName(String n) {
		this.name = n;
	}

	public String parsePhone(String phone) {
		return phone.replaceAll("[^0-9.]", "");
	}

	public void setPhone(String p) {
		this.phone = parsePhone(p);
	}

	public String getName() {
		return this.name;
	}

	public String getPhone() {
		return this.phone;
	}

	public static void main(String[] args) {
		Customer c1 = new Customer("Vaibhav", "6475688888");
		c1.setPhone("905 123 456");
		c1.setName("Stan");

		System.out.println("c1 Name: " + c1.getName());
		System.out.println("c1 Phone: " + c1.getPhone());
	}
}
