package business;

public class Moebelhaus {
	
	// Name des Moebelhauses
    private String name;
    // Oeffnungszeiten
    private String wohnraum;
    private String stil;
    // Strasse und Hausnummer des Moebelhauses
    private String preis;
    // Dienstleistungen des Moebelhauses
    private String[] materialien;

   
    
	
	public String getWohnraum() {
		return wohnraum;
	}


	public void setWohnraum(String wohnraum) {
		this.wohnraum = wohnraum;
	}


	public String getStil() {
		return stil;
	}


	public void setStil(String stil) {
		this.stil = stil;
	}


	public String getPreis() {
		return preis;
	}


	public void setPreis(String preis) {
		this.preis = preis;
	}


	public String[] getMaterialien() {
		return materialien;
	}


	public void setMaterialien(String[] materialien) {
		this.materialien = materialien;
	}


	public Moebelhaus(String name, String wohnraum, String stil, String preis, String[] materialien) {
		super();
		this.name = name;
		this.wohnraum = wohnraum;
		this.stil = stil;
		this.preis = preis;
		this.materialien = materialien;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	
	
	public String getMaterialienAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getMaterialien().length - 1; i++) {
			ergebnis = ergebnis + this.getMaterialien()[i] + trenner; 
		}
		return ergebnis	+ this.getMaterialien()[i];
	}
	
	public String gibMoebelhausZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getWohnraum() + trenner
  		    + this.getStil() + trenner
  		    + this.getPreis() + trenner 
  		    + this.getMaterialienAlsString(trenner);
  	}
}

