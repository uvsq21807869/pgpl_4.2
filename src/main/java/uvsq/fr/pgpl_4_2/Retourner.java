package uvsq.fr.pgpl_4_2;



public class Retourner implements Command {

	private MoteurRPN moteurRPN;
	
	public Retourner(MoteurRPN moteurRPN){
		this.moteurRPN=moteurRPN;
	}
	
	public void execute() {
		this.moteurRPN.listeOperandes();
	}

}