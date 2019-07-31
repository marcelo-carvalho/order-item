package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;


public class Order {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	private List<OrderItem> itens = new ArrayList<>();
	private Client client = new Client();

	public Order() {
	}
	
	public Order(Date moment, OrderStatus status) {
		this.moment = moment;
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public List<OrderItem> getItens() {
		return itens;
	}
	
	public void addItem(OrderItem item) {
		itens.add(item);
	}
	
	public void removeItem(OrderItem item) {
		itens.remove(item);
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public double total() {
		double sum = 0;
		for (OrderItem item : itens) {
			sum += item.getPrice();
		}
		return sum;
	}
	
	public String toString() {
		
		StringBuilder sc = new StringBuilder();
		sc.append("ORDER SUMMARY: \n");
		sc.append("Order moment: " + sdf.format(moment) + "\n");
		sc.append("Order status: " + status.toString() + "\n");
		sc.append(client + "\n");
		sc.append("Order items: \n");
		
		for(OrderItem item : itens) {
			sc.append(item + "\n");
		}
		sc.append("Total price: $" + total());
		
		return sc.toString();
	}
}
