package one.digitalinnovation.gof.singleton;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingletonLazy lazy = null;
		System.out.println(lazy);
		lazy = SingletonLazy.getInstancia();
		System.out.println(lazy);
		
		SingletonEager eager = null;
		System.out.println(eager);
		eager = SingletonEager.getInstancia();
		System.out.println(eager);
		
		SingletonLazyHolder lholder = null;
		System.out.println(lholder);
		lholder = SingletonLazyHolder.getInstancia();
		System.out.println(lholder);
	}

}
