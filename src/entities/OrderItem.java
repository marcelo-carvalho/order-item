package entities;

public class OrderItem {
	
	private int quantity;
	private double price;
	
	private Product product = new Product();
	
	public OrderItem() {	
	}

	public OrderItem(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.price = product.getPrice() * quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public double subTotal() {
		return price;
	}
	
	public String toString() {
		return product + " Quantity: " + quantity + ", Subtotal: " + price;
	}
}
