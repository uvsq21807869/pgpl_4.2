package uvsq.fr.pgpl_4_2;

public enum CalculatriceRPN {
	CALCULRPN;
	public void start( String[] args )
    {
		SaisieRPN Saisie = new SaisieRPN();
		Saisie.saisie();
    }
	public static void main(String[] args) {
		CALCULRPN.start(args);
	}
}