package guessinggame;
import java.util.Random;

/**
 * The Class that let you guess the number between 0 to the upperbound that you
 * fill in the parameter. It's will also tell you that the number you guess is
 * too large or to small.
 * 
 * @author BasPasut
 *
 */
public class BasGame extends NumberGame {
	/**
	 * The most number that you can guess.
	 */
	public int upperBound;

	/**
	 * The number that you have to guess.
	 */
	public int secretNumber;

	/**
	 * Count the times that you guess the secret number.
	 */
	public int count;
	
	/**
	 * Initialize the new default game and you can give the upperbound in this game, too
	 * @param upperBound
	 */
	public BasGame(int upperBound) {
		this.upperBound = upperBound;
		long seed = System.nanoTime();
		Random rand = new Random(seed);
		this.secretNumber = rand.nextInt(upperBound) + 1;
	}

	/**
	 * Tell you whether the number you guess is correct or not. If the number
	 * you guess is equal to the secret number, it'll return true, otherwise
	 * it'll return false.
	 * 
	 * @param number that you guess.
	 * @return true if your guess is equal to secretNumber and false if not.
	 */
	public boolean guess(int number) {
		count++;
		if (secretNumber == number) {
			super.setMessage("Congratulation!! The secret number is " + secretNumber);
			setChanged();
			notifyObservers(number);
			return true;
		} else if (number > secretNumber) {
			super.setMessage("too large");
			setChanged();
			notifyObservers(number);
			return false;
		} else {
			super.setMessage("too small");
			setChanged();
			notifyObservers(number);
			return false;
		}
	}
	
	/**
	 * Get the number of times that you guess.
	 * @return the number of times that you guess.
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * The highest number that you have to guess.
	 * @return the highest number that you have to guess.
	 */
	public int getUpperBound() {
		return upperBound;
	}
	
	/**
	 *This method will show the status of the game. 
	 *@return the title of the game.
	 */
	public String toString() {
		return "Guess the number between 1 - " + upperBound;

	}

}
