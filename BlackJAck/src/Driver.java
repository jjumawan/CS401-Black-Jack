public class Driver {
	public static void main(String[] args) {
		Card temp = new Card();
		Deck x = new Deck();
		Hand myHand = new Hand();

		myHand.addCardToHand(x.drawACard());

		System.out.println(temp.toString());

		x.shuffle();

		System.out.println(temp.toString());

		System.out.println(myHand.getValue());
		System.out.println("Testing the table ---------------");
		Table xy = new Table();

		xy.getTimer();

		System.out.println("End of testing" + " \n _______\n"
				+ "|A      |\n"
				+ "|       |\n"
				+ "|   ♠   |\n"
				+ "|       |\n"
				+ "|_______|\n"
				+ "");

	}
}