package learningjava8.defaultmethods;

public class D implements B, C {
	
	public static void main(String [] args) {
		new D().hello();
	}
	
	@Override
	public void hello() {
		
		System.out.println("Hello from D");
	}

}