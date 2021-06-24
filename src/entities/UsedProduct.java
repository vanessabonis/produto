package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	//ATRIBUTOS
	private Date manufactureDate;

	//CONSTRUTORES
	public UsedProduct() {
		super();
	}
	
	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	//GET-SET
	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	//MÉTODOS
	@Override
	public String priceTag() {
		return getName()
				+ " (used) $ " 
				+ String.format("%.2f", getPrice())
				+ "(Manufacture date: "
				+ sdf.format(manufactureDate)
				+ ")";
	}
	
	
	

}
