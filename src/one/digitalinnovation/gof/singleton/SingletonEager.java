package one.digitalinnovation.gof.singleton;

/**
 * Singleton "apressado"
 * @author pedfu
 *
 */
public class SingletonEager {
	private static SingletonEager instancia = new SingletonEager();
	// apressado pq assim que cria o singleton pela primeira vez, ele ja prepara a
	// instancia
	
	private SingletonEager() {
		
	}
	
	public static SingletonEager getInstancia() {
		return instancia;
	}
}
