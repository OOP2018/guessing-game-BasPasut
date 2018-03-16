package application;

import java.net.URL;
import guessinggame.BasGame;
import guessinggame.NumberGame;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		NumberGame game = new BasGame(100);
		try {
			URL url = getClass().getResource("MainUI.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: MainUI.fxml");
				Platform.exit();
			}
			
			FXMLLoader loader = new FXMLLoader(url);
			
			Parent root = loader.load();
		
			GameController controller = loader.getController();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.show();
			primaryStage.setTitle("GuessingGame");
			
			controller.setCounter(game);
			
		} catch(Exception e) {
			System.out.println("Exception creating scene: "+e.getMessage());
		}
		CountGuessWindow cgw = new CountGuessWindow(game);
		game.addObserver(cgw);
		cgw.run();
		
		CurrentGuessWindow currentGuess = new CurrentGuessWindow(game);
		game.addObserver(currentGuess);
		currentGuess.run();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
