package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import ownUtil.*;

import javafx.scene.control.Alert.AlertType;
import reader.ConcreteReaderCreator;
import reader.ReaderCreator;
import reader.ReaderProduct;

public class MoebelhausModel implements Observable{

	private Moebelhaus moebelhaus;
	private static MoebelhausModel instanz;
	private Vector<Observer> observers=new Vector<Observer>();
	
	private MoebelhausModel() {
		
	}
	public static MoebelhausModel getInstanz() {
		if(instanz==null) {
			instanz=new MoebelhausModel();
		}
		return instanz;
	}
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
  			notifyObservers();
  			
    }
	@Override
	public void addObserver(Observer obs) {
		observers.add(obs);
	}
	@Override
	public void removeobersver(Observer obs) {
		observers.remove(obs);
	}
	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
}
