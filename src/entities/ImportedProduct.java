package entities;

public class ImportedProduct extends Product{
	//ATRIBUTOS
	private Double customsFee;
	
	//CONSTRUTORES
	public ImportedProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	//GET-SET
	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}

	//MÉTODOS
	public Double totalPrice() {
		return getPrice() + customsFee;
	}
	
	@Override
	public String priceTag() {
		return super.getName() 
				+ " $ " 
				+ String.format("%.2f", totalPrice())
				+ "(Customs fee: $ "
				+ String.format("%.2f", customsFee)
				+ ")";
				
	}
	
	
}
