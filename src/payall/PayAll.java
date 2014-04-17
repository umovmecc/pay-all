package payall;

import payall.interfaces.Payment;
import payall.model.VisaPayment;

public class PayAll {

	private Printer printer;	
	private Payment payment;
	
	public PayAll(Printer printer) {
		this.printer = printer;
		this.payment = new VisaPayment();
	}
	
	public void payFor(Client client, double value) {
		printer.printMessage(this.payment.pay(value,client));
	}

}
