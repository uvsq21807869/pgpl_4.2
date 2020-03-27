package uvsq.fr.pgpl_4_2;


public class Appliquer implements Command {

	private MoteurRPN moteurRPN;
	private Operations operation;
	
	public Appliquer(MoteurRPN moteurRPN,Operations operation){
		this.moteurRPN=moteurRPN;
		this.operation=operation;
	}
	
	public void execute() {
		//open command is forwarding request to openFile method
		this.moteurRPN.appliquerOperation(operation);
	}

}
