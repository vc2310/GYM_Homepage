
public class FitCustomer extends Customer {
	private String username, password;
	private int bodyType, weight, height, age;

	/**
	 * Creates a new instance of <code>FitCustomer</code>.
	 */

	// default constructor
	public FitCustomer(String usernameIn, String passwordIn) {
		this.username = usernameIn;
		this.password = passwordIn;
		this.bodyType = 0;
		this.weight = 0;
		this.height = 0;
		this.age = 0;
	}

	// constuctor for all information
	public FitCustomer(String usernameIn, String passwordIn, int bodyTypeIn, int weightIn, int heightIn, int ageIn) {
		this.username = usernameIn;
		this.password = passwordIn;
		this.bodyType = bodyTypeIn;
		this.weight = weightIn;
		this.height = heightIn;
		this.age = ageIn;
	}

	// method to set all information in case we want to change it
	public void setAllInfo(String usernameIn, String passwordIn, int bodyTypeIn, int weightIn, int heightIn,
			int ageIn) {
		this.username = usernameIn;
		this.password = passwordIn;
		this.bodyType = bodyTypeIn;
		this.weight = weightIn;
		this.height = heightIn;
		this.age = ageIn;
	}

	public void setUserName(String n) {
		this.username = n;
	}

	public void setPassword(String p) {
		this.password = p;
	}

	public void setBodyType(int b) {
		this.bodyType = b;
	}

	public void setWeight(int w) {
		this.weight = w;
	}

	public void setHeight(int h) {
		this.height = h;
	}

	public void setAge(int a) {
		this.age = a;
	}

	public String getUserName() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public int getBodyType() {
		return this.bodyType;
	}

	public int getWeight() {
		return this.weight;
	}

	public int getHeight() {
		return this.height;
	}

	public int getAge() {
		return this.age;
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

	}
}
