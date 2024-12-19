package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import ownUtil.*;

import javafx.scene.control.Alert.AlertType;
import reader.ConcreteReaderCreator;
import reader.ReaderCreator;
import reader.ReaderProduct;

public class MoebelhausModel implements Observable{

	private ArrayList<Moebelhaus> moebelhaus=new ArrayList<Moebelhaus>();
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
	public ArrayList<Moebelhaus> getMoebelhaus() {
		return moebelhaus;
	}
	public void addMoebelhaus(Moebelhaus moebelhaus) {
		this.moebelhaus.add(moebelhaus);
	}
	
	public void schreibeBuergeraemterInCsvDatei() throws IOException {
			BufferedWriter aus = new BufferedWriter(new FileWriter("Moebelhaus.csv",false));
			for (Moebelhaus moebelhaus2 : moebelhaus) {
				aus.write(moebelhaus2.gibMoebelhausZurueck(';')+"\n");
			}
			aus.close();
   			
	}

    
    public void leseAusDatei(String typ) throws IOException{
		
		ReaderCreator creator= new ConcreteReaderCreator();
		ReaderProduct readerProduct=creator.factoryMethod(typ);
		
		String[]zeile=readerProduct.leseAusDatei();
		readerProduct.schliesseDatei();
		
  			this.moebelhaus.add(new Moebelhaus(zeile[0], 
  				zeile[1], 
  				zeile[2], 
  				zeile[3], zeile[4].split("_")));
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
