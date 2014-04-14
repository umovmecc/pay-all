package payall;

public enum CardBanner {
	VISA("Visa"), 
	HIPERCARD("Hipercard"), 
	MASTERCARD("MasterCard"), 
	AMERICAN_EXPRESS("American Express"); 
	
	private CardBanner(String description) {
		this.description = description;
	}
	
	private String description;

	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return getDescription();
	}

}
