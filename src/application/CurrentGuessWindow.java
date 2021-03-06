package application;
import java.util.Observable;
import guessinggame.NumberGame;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CurrentGuessWindow implements java.util.Observer{
	
	private NumberGame game;
	private Stage stage;
	
	Label label;
	
	public CurrentGuessWindow(NumberGame game) {
		this.game = game;
		initsComponent();
	}
	
	private void initsComponent() {
		stage = new Stage();
		HBox root = new HBox();
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		label = new Label("   ");
		label.setPrefWidth(250);
		label.setFont(new Font("Arial", 80.0));
		label.setAlignment(Pos.CENTER);
		root.getChildren().add(label);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("CurrentGuess");
		stage.sizeToScene();
		
	}
	
	public void run(){
		stage.show();
		displayCurrent(0);
	}
	
	public void displayCurrent(int ans){
		label.setText(String.format("%2d",ans));
	}
	
	@Override
	public void update(Observable o, Object arg) {
		int ans = (int) arg;
		displayCurrent(ans);
	}

}