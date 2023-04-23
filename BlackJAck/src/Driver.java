
public class Driver {
	public static void main(String[] args) {
		Deck x = new Deck();
		System.out.println("should work");
		
		for(int i = 0; i < 52; i++) {
		System.out.println(x.drawACard().toString());
		}
		
		System.out.println(x.getCardsLeft());
		System.out.println("mixed");
		x.shuffle();
		for(int i = 0; i < 52; i++) {
			System.out.println(x.drawACard().toString());
			}
	}
}
