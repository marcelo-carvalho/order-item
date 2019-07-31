package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US); 
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.next();
		System.out.print("Birth date: ");
		String birthDate = sc.next();
		
		Client client = new Client(name, email, sdf.parse(birthDate));
		
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next();
		System.out.print("How many items to this order? ");
		int numberOfItens = sc.nextInt(); 
		
		Order order = new Order(new Date(System.currentTimeMillis()), OrderStatus.valueOf(status));
				
		for(int i =1; i <= numberOfItens; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product Name: ");
			String productName = sc.next();
			System.out.print("Product Price: ");
			double productPrice = sc.nextDouble();
			Product product = new Product(productName, productPrice);
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			order.addItem(new OrderItem(quantity, product));
		}
				
		order.setClient(client);
		System.out.println();
		System.out.println(order.toString());
		
		sc.close();
	}

}
