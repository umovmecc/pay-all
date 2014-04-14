package payall;

import static payall.CardBanner.*;
import static java.lang.String.format;

public class PayAll {

	private Printer printer;	
	
	public PayAll(Printer printer) {
		this.printer = printer;
	}
	
	public void payFor(Client client, double value) {
		if (VISA.equals(client.getCardBanner())) {
			printer.printMessage(format("Value %s paid on Visa card banner in cash with discount of 5%%", value));
		} else if (MASTERCARD.equals(client.getCardBanner())) {
			printer.printMessage(format("Value %s paid on MasterCard card banner in 3 times without discount", value));
		} else if (HIPERCARD.equals(client.getCardBanner())) {
			printer.printMessage(format("Value %s paid on Hipercard card banner in 12 times", value));
		} else {
			throw new RuntimeException(format("Card banner %s is not suported yet!", client.getCardBanner()));
		}
	}

}
