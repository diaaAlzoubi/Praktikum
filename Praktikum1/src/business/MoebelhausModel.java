package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.control.Alert.AlertType;
import ownUtil.MeldungsfensterAnzeiger;
import reader.ConcreteReaderCreator;
import reader.ReaderCreator;
import reader.ReaderProduct;

public class MoebelhausModel {

	private Moebelhaus moebelhaus;
	
	public Moebelhaus getMoebelhaus() {
		return moebelhaus;
	}
	public void setMoebelhaus(Moebelhaus moebelhaus) {
		this.moebelhaus = moebelhaus;
	}
	
	public void schreibeBuergeraemterInCsvDatei() throws IOException {
			BufferedWriter aus = new BufferedWriter(new FileWriter("Moebelhaus.csv",false));
			aus.write(moebelhaus.gibMoebelhausZurueck(';'));
			aus.close();
   			
	}

    
    public void leseAusDatei(String typ) throws IOException{
		
		ReaderCreator creator= new ConcreteReaderCreator();
		ReaderProduct readerProduct=creator.factoryMethod(typ);
		
		String[]zeile=readerProduct.leseAusDatei();
		readerProduct.schliesseDatei();
  			this.moebelhaus = new Moebelhaus(zeile[0], 
  				zeile[1], 
  				zeile[2], 
  				zeile[3], zeile[4].split("_"));
  			
    }
}
