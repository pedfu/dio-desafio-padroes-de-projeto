package one.digitalinnovation.gof.singleton;

/**
 * Singleton "preguiçoso"
 * @author pedfu
 *
 */
public class SingletonLazy {
	private static SingletonLazy instancia;
	// preguicoso pq ele espera pedir a instacia para verificar se ela existe e cria-la
	
	private SingletonLazy() {
		
	}
	
	public static SingletonLazy getInstancia() {
		if(instancia == null) {
			instancia = new SingletonLazy();
		}
		return instancia;
	}
}
