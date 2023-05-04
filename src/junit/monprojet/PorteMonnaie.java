package junit.monprojet;

import java.util.HashMap;

public class PorteMonnaie {
	private HashMap<String, Integer> contenu;

	public HashMap<String, Integer> getContenu() {
		return contenu;
	}

	public PorteMonnaie() {
		contenu = new HashMap<String, Integer>();
	}

	public void ajouteSomme(SommeArgent sa) {
		this.contenu.merge(sa.getUnite(), sa.getQuantite(), Integer::sum);
	}
	
	public String toString() {
		String msg = "";
	    for (String i : contenu.keySet()) {
	        msg+=(contenu.get(i) + " " + i) + "\n";
	    }
	    return msg;
	}
	
	public boolean equals(Object obj) {
		if (!contenu.keySet().equals( ((PorteMonnaie)obj).getContenu().keySet())) {
			return false;
		}
		for(String i : contenu.keySet()) {
			if (contenu.get(i) != ((PorteMonnaie)obj).getContenu().get(i))
				return false;
		}
		return true;
	}
}
