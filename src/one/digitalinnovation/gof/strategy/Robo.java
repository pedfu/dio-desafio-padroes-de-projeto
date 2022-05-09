package one.digitalinnovation.gof.strategy;

public class Robo {
	private Comportamento strategy;
	// strategy sao as interfaces(acoes) que um objeto pode ter
	
	public void setComportamento(Comportamento comportamento) {
		this.strategy = comportamento;
	}
	
	public void mover() {
		strategy.mover();
	}
}
