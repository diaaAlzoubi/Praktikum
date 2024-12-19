package business;

import java.util.ArrayList;

public class Moebelhaus {
	
	// Name des Moebelhauses
    private String name;
    // Oeffnungszeiten
    private String wohnraum;
    private String stil;
    // Strasse und Hausnummer des Moebelhauses
    private String preis;
    // Dienstleistungen des Moebelhauses
    private ArrayList<String> materialien;
    

	public Moebelhaus(String name, String wohnraum, String stil, String preis, String[] materialien) {
		super();
		if(materialien==null) {
			throw new IllegalArgumentException();
			}
		this.name = name;
		this.wohnraum = wohnraum;
		this.stil = stil;
		this.preis = preis;
		setMaterialienAusStringArray(materialien);
	}
	
	private void setMaterialienAusStringArray(String[] materialien){
		
		this.materialien= new ArrayList<String>();
		for (int i = 0; i < materialien.length; i++) {
			this.materialien.add(materialien[i]);
		}
		
	}
    
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


	public ArrayList<String> getMaterialien() {
		return materialien;
	}


	public void setMaterialien(String[] materialien) {
		setMaterialien(materialien);
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
		for(i = 0; i < this.getMaterialien().size() - 1; i++) {
			ergebnis = ergebnis + this.getMaterialien().get(i) + trenner; 
		}
		return ergebnis	+ this.getMaterialien().get(i);
	}
	
	public String gibMoebelhausZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getWohnraum() + trenner
  		    + this.getStil() + trenner
  		    + this.getPreis() + trenner 
  		    + this.getMaterialienAlsString(trenner);
  	}
}

