package Main;

import gui.guiMoebelhaus.BuergeraemterAnwendersystem;
import gui.guiMoebelhaus.MoebelhausControl;
import gui.guiWarenuebersicht.WarenuebersichtControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new MoebelhausControl(primaryStage);
		Stage fensterWarenuebersicht=new Stage();
		new WarenuebersichtControl(fensterWarenuebersicht);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
	
	//token für Repo Praktikum
	//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
}
