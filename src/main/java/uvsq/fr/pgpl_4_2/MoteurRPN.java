package uvsq.fr.pgpl_4_2;

import java.util.Stack;


public class MoteurRPN extends Interpreteur {


	// constructeur
	public MoteurRPN() {
		super();
	}

	// enregistrement d'une operande
	public void enregistrerOperande(double val) {
		operandes.add(val);
		Stack<Double> temp=new Stack<Double>();
		temp.addAll(operandes);
		operandesPrecedent.add(temp);
	}
}