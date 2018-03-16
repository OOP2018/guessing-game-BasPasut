package application;

import guessinggame.NumberGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameController {

	@FXML
	TextField tf;
	@FXML
	Label hint;
	NumberGame game;

	public void handleGuessing(ActionEvent event) {
		int ans = 0;
		try {
			ans = Integer.parseInt(tf.getText().trim());
		} catch (Exception e) {
			tf.setText("Invalid");
			hint.setText("Invalid input try again later.");
		}
		if (game.guess(ans) == false) {
			hint.setText(String.format("%s ", ans) + game.getMessage());
		}

		else {
			hint.setText(game.getMessage());
		}
	}
	
	public void setCounter(NumberGame game){
		this.game = game;
		
	}
}
