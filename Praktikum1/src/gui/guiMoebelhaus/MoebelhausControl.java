package gui.guiMoebelhaus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Moebelhaus;
import business.MoebelhausModel;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class MoebelhausControl {

	private MoebelhhausView moebelhhausView;
	private MoebelhausModel moebelhausModel;
	
	public MoebelhausControl(Stage primaryStage) {
	
		this.moebelhausModel= MoebelhausModel.getInstanz(); ;
		this.moebelhhausView= new MoebelhhausView(this, primaryStage, moebelhausModel);
	}
	
	
	public void nehmeMoebelhausAuf(){
    	try{
    		this.moebelhausModel.addMoebelhaus(new Moebelhaus(this.moebelhhausView.getTxtName().getText(), this.moebelhhausView.getTxtWohnraum().getText(),this.moebelhhausView.getTxtStil().getText(),this.moebelhhausView.getTxtPreis().getText(),
       	    this.moebelhhausView.getTxtMaterialien().getText().split(";")));
    		
    		this.moebelhhausView.zeigeInformationsfensterAn("Das Moebelhaus wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		this.moebelhhausView.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
	
	
	public void schreibeBuergeraemterInCsvDatei() {
		try {
			moebelhausModel.schreibeBuergeraemterInCsvDatei();
			this.moebelhhausView.zeigeInformationsfensterAn("Der Moebelhaus wurden gespeichert!");
		}	
		catch(IOException exc){
			this.moebelhhausView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		}
		catch(Exception exc){
			this.moebelhhausView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
		
	}
	
	public void leseAusDatei(String typ){
    	try {
    		
    		this.moebelhausModel.leseAusDatei(typ);
    		this.moebelhhausView.zeigeInformationsfensterAn("Der Moebelhaus wurden gelesen!");

		}
		catch(IOException exc){
			this.moebelhhausView.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		}
		catch(Exception exc){
			this.moebelhhausView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
		}
	}
  
}
