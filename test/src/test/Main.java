package test;

public class Main extends Foo {

	String username = "main var";

	public String getUsername() {
		return username + " main method";
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public static void main(String[] args) {
		Foo m = new Main();
		System.out.println(m.getUsername());
	}
}
