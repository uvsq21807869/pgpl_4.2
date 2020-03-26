package uvsq.fr.pgpl_4_2;

import java.util.Stack;

public class Interpreteur {
	protected Stack<Double> operandes;
	protected Stack<Stack<Double>> operandesPrecedent;
	
	
	public Interpreteur() {
		operandes = new Stack<Double>();
		operandesPrecedent = new Stack<Stack<Double>>();
	}

	public void quit() {
		System.out.println("good bye");
		System.exit(0);
		
	}

	public void undo() {
		

		if(operandesPrecedent.size()>1) {
			operandesPrecedent.pop();
			operandes=operandesPrecedent.peek();
		}else {
			operandesPrecedent.clear();
			operandes.clear();
		}
		

	}


}