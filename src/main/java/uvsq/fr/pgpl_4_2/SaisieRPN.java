package uvsq.fr.pgpl_4_2;

import java.util.Scanner;

public class SaisieRPN {
	private Scanner sc;
	private MoteurRPN moteurRPN;
	private final static int MAX_VALUE = 10000000;
	private final static int MIN_VALUE = 1000000;
	private Invoker invoqueur;

	// constructeur pour initialiser le moteur
	public SaisieRPN() {
		// Creating the receiver object
		moteurRPN = new MoteurRPN();
		// Creating invoker and associating with Command
		invoqueur = new Invoker();
		init();
		sc = new Scanner(System.in);

	}

//la methode qui consiste a invoquer le moteur rpn(si l'utlisateur tape qlq 
	// operateur on applique operation y correspond)
	private void invoqueMoteurRPN(String x) throws ArithmeticException, NumberFormatException {

		switch (x) {

		case "+":
			// perform action on invoker object
			invoqueur.invoquer("plus");
			invoqueur.invoquer("retourner");
			break;
		case "-":
			invoqueur.invoquer("moins");
			invoqueur.invoquer("retourner");
			break;
		case "*":
			invoqueur.invoquer("mult");
			invoqueur.invoquer("retourner");
			break;
		case "/":
			invoqueur.invoquer("div");
			invoqueur.invoquer("retourner");
			break;

		case "undo":
			invoqueur.invoquer("undo");
			invoqueur.invoquer("retourner");
			break;

		case "quit":
			invoqueur.invoquer("quit");
			break;
		default:
			// verification du nombre saisie s'il est bien dans l'iterbal[min
			// value,maxvalue]
			double operande = Double.parseDouble(x);
			if (Math.abs(operande) > -MIN_VALUE && operande < MAX_VALUE) {

				// creating command and associating with receiver
				this.invoqueur.invoquer(new Enregistrer(moteurRPN,operande));
				//moteurRPN.enregistrerOperande(operande);
				invoqueur.invoquer("retourner");
			} else {
				throw new ArithmeticException("opreandes non inclus dans l'intervalle");
			}
			break;
		}

	}

//interface homme machine
	public void saisie() {

		System.out.println("                 		 *******CALCULATRICE RPN*******");
		System.out.println("Saisir nombre, operation ou exit pour quitter");
		while (true) {
			String str = sc.nextLine();
			try {
				invoqueMoteurRPN(str);
			} catch (ArithmeticException | NumberFormatException msg) {
				System.out.println("incorrecte car : " + msg.getMessage());
				invoqueur.invoquer("retourner");
			}
		}
	}



	private void init() {
		// creating command and associating with receiver
		Appliquer plus = new Appliquer(moteurRPN, Operations.PLUS);
		// ajouter la commande plus
		this.invoqueur.addNewCommande("plus", plus);

		// creating command and associating with receiver
		Appliquer moins = new Appliquer(moteurRPN, Operations.MOINS);
		// ajouter la commande plus
		this.invoqueur.addNewCommande("moins", moins);

		// creating command and associating with receiver
		Appliquer div = new Appliquer(moteurRPN, Operations.DIV);
		// ajouter la commande plus
		this.invoqueur.addNewCommande("div", div);

		// creating command and associating with receiver
		Appliquer mult = new Appliquer(moteurRPN, Operations.MULT);
		// ajouter la commande plus
		this.invoqueur.addNewCommande("mult", mult);
		
		Undo undo =new Undo(moteurRPN);
		this.invoqueur.addNewCommande("undo", undo);
		
		Quit quit=new Quit(moteurRPN);
		this.invoqueur.addNewCommande("quit", quit);
		
		Retourner retourner=new Retourner(moteurRPN);
		this.invoqueur.addNewCommande("retourner", retourner);
	}

}
