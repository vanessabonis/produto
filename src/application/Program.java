package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		//INSTANCIAR-LISTA
		List<Product> list = new ArrayList<>();
		
		System.out.print("Quantidade de Produtos a serem cadastrados > ");
		int n = sc.nextInt();
		
		//ADD PRODUTOS A LISTA
		for(int i=1; i<=n; i++) {
			System.out.println("Dados do Produto #" + i + ":");
			//DADOS-DO-PRODUTO
			System.out.print("Comum, Usado ou Importado (c/u/i) > ");
			char ch = sc.next().charAt(0);
			System.out.print("Nome > ");
			sc.nextLine(); //CONSUMIR-LINHA
			String name = sc.nextLine();
			System.out.print("Preço > ");
			Double price = sc.nextDouble();
			//TIPO-DO-PRODUTO
			if(ch == 'u') {
				System.out.print("Data de Fabricação (DD/MM/YYYY) > ");
				Date date = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, date));
			}else if(ch == 'i') {
				System.out.print("Custom Fee > ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}else {
				Product prod = new Product(name, price);
				list.add(prod);
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		//PRINTAR-LISTA
		//USAR-FOREACH
		for(Product prod : list) {
			System.out.println(prod.priceTag());
		}
				
		sc.close();

	}

}
