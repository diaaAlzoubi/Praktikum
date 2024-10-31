package Main;

import gui.BuergeraemterAnwendersystem;
import gui.MoebelhausControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new MoebelhausControl(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
	
	//token für Repo Praktikum
	//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
}
