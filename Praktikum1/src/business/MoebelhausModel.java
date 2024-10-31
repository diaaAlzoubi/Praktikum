package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.control.Alert.AlertType;
import ownUtil.MeldungsfensterAnzeiger;

public class MoebelhausModel {

	private Moebelhaus moebelhaus;
	
	public Moebelhaus getMoebelhaus() {
		return moebelhaus;
	}
	public void setMoebelhaus(Moebelhaus moebelhaus) {
		this.moebelhaus = moebelhaus;
	}
	
	public void schreibeBuergeraemterInCsvDatei() throws IOException {
			BufferedWriter aus = new BufferedWriter(new FileWriter("BuergeraemterAusgabe.csv", true));
			aus.write(moebelhaus.gibMoebelhausZurueck(';'));
			aus.close();
   			
	}

    
    public void leseAusDatei(String typ) throws IOException{
    	if("csv".equals(typ)){
  			BufferedReader ein = new BufferedReader(new FileReader("Buergeraemter.csv"));
  			String[] zeile = ein.readLine().split(";");
  			this.moebelhaus = new Moebelhaus(zeile[0], 
  				Float.parseFloat(zeile[1]), 
  				Float.parseFloat(zeile[2]), 
  				zeile[3], zeile[4].split("_"));
  				ein.close();
	}
    }
}
