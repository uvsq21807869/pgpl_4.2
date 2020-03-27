package uvsq.fr.pgpl_4_2;


public class Quit implements Command {

	private Interpreteur intrInterpreteur;
	
	public Quit(Interpreteur intrInterpreteur){
		this.intrInterpreteur=intrInterpreteur;
	}
	
	public void execute() {
		//open command is forwarding request to openFile method
		this.intrInterpreteur.quit();
	}

}