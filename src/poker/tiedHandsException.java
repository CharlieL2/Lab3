package poker;

import java.util.ArrayList;

public class tiedHandsException extends Exception {

	public tiedHandsException() {
		// TODO Auto-generated constructor stub
	}

	public tiedHandsException(ArrayList<Hand> tiedHands) {
		super("Tie with two " + tiedHands.get(0).getHandStrength() + " ranking");
		// TODO Auto-generated constructor stub
	}

}
