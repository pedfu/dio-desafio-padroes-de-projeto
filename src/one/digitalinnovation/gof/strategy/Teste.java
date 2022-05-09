package one.digitalinnovation.gof.strategy;

import one.digitalinnovation.gof.facade.Facade;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comportamento normal = new ComportamentoNormal();
		Comportamento defensivo = new ComportamentoDefensivo();
		Comportamento agressivo = new ComportamentoAgressivo();
		
		Robo robo = new Robo();
		
		robo.setComportamento(normal);
		robo.mover();
		
		robo.setComportamento(defensivo);
		robo.mover();
		
		robo.setComportamento(agressivo);
		robo.mover();
		
		
		
		Facade facade = new Facade();
		facade.migrarCliente("Venilton", "435890427");
	}

}
