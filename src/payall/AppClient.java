package payall;


public class AppClient {

	public static void main(String[] args) {
		Client clientA = new Client();
		Client clientB = new Client();
		Client clientC = new Client();
		Client clientD = new Client();
		
		clientA.setCardBannerType(CardBanner.VISA);
		clientB.setCardBannerType(CardBanner.HIPERCARD);
		clientC.setCardBannerType(CardBanner.MASTERCARD);
		clientD.setCardBannerType(CardBanner.AMERICAN_EXPRESS);
		
		Printer printer = new Printer();
		PayAll payAll = new PayAll(printer);
		
		try {
			payAll.payFor(clientA, 250.7);
			payAll.payFor(clientB, 423.0);
			payAll.payFor(clientC, 1950.4);
			payAll.payFor(clientD, 850.5);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

}
