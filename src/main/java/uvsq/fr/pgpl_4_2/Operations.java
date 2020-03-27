package uvsq.fr.pgpl_4_2;


public enum Operations {
	
//les constantes PLUS, MOINS, MULT et DIV,
	PLUS('+') { 
		public double eval(double a,double b) {
			return a + b;
		}
	},
	MOINS('-') {
		public double eval(double a,double b) {
			return a - b;
		}
	},
	MULT('*') {
		public double eval(double a,double b) {
			return a * b;
		}
	},
	DIV('/') {
		public double eval(double a,double b) throws ArithmeticException {
			if (b == 0)
				throw new ArithmeticException("denominateur egal 0");
			else
				return a / b;
		}
	};
//l'attribut symbole representant le symbole de l'operation (+, -, â€¦â€‹)
	private char symbole;

//constructeur prenant en parametre le symbole de l'operation
	Operations(char symbole){
		//If someone removes or adds a value, some of test fails.
		String symboles = "+-*/";
		if (symboles.indexOf(symbole)==-1)
			throw new IllegalArgumentException();
		else
			this.symbole = symbole;
	}

	public char getSymbol(){
		return symbole;
	}
// la methode abstraite eval retournant le rÃ©sultat de l'evaluation de l'operation sur deux operande
	public abstract double eval(double val1, double val2) throws ArithmeticException;
}

