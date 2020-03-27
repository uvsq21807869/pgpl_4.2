package uvsq.fr.pgpl_4_2;

import java.util.HashMap;
import java.util.Map;


public class Invoker {

	private Map<String, Command> commandes = new HashMap<String, Command>();

	public Map<String, Command> getCommandes() {
		return commandes;
	}

	public void addNewCommande(String nomCommande, Command cmd) {
		commandes.put(nomCommande, cmd);
	}
	/**
	 * Fonction qui va executer la commande choisie 
	 * @param nomCommande 
	 */
	public void invoquer(String nomCommande) {
		Command cmd = commandes.get(nomCommande);
		if (cmd != null) {
			cmd.execute();
		}
	}
	
	 public void invoquer(Command cmd) {
	        cmd.execute();
	    }
	
	

}
