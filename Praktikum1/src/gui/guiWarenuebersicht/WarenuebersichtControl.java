package gui.guiWarenuebersicht;
import business.*;
import javafx.stage.Stage;
public class WarenuebersichtControl {	
	private WarenuebersichtView warenuebersichtView;
	private MoebelhausModel MoebelhausModel;
	
	public WarenuebersichtControl(Stage primaryStage){
 		this.MoebelhausModel = MoebelhausModel.getInstanz(); 		
		this.warenuebersichtView = new WarenuebersichtView(this, primaryStage, MoebelhausModel);
	}
}
