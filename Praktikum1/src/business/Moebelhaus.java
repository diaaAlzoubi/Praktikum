package business;

public class Moebelhaus {
	
	// Name des Moebelhauses
    private String name;
    // Oeffnungszeiten
    private float wohnraum;
    private float stil;
    // Strasse und Hausnummer des Moebelhauses
    private String preis;
    // Dienstleistungen des Moebelhauses
    private String[] materialien;

    public Moebelhaus(String name, float wohnraum, float stil,
    	String preis, String[] materialien){
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

	public float getGeoeffnetVon() {
		return wohnraum;
	}

	public void setGeoeffnetVon(float wohnraum) {
		this.wohnraum = wohnraum;
	}

	public float getGeoeffnetBis() {
		return stil;
	}

	public void setGeoeffnetBis(float stil) {
		this.stil = stil;
	}

	public String getStrasseHNr() {
		return preis;
	}

	public void setStrasseHNr(String preis) {
		this.preis = preis;
	}

	public String[] getDienstleistungen() {
		return materialien;
	}

	public void setDienstleistungen(String[] materialien) {
		this.materialien = materialien;
	}
	
	public String getDienstleistungenAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getDienstleistungen().length - 1; i++) {
			ergebnis = ergebnis + this.getDienstleistungen()[i] + trenner; 
		}
		return ergebnis	+ this.getDienstleistungen()[i];
	}
	
	public String gibMoebelhausZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getGeoeffnetVon() + trenner
  		    + this.getGeoeffnetBis() + trenner
  		    + this.getStrasseHNr() + trenner + "\n"
  		    + this.getDienstleistungenAlsString(trenner) + "\n";
  	}
}

