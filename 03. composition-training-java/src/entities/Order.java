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
	
	// Cria uma lista para instanciar vários pedidos de itens
	List<OrderItem> items = new ArrayList<>();
	
	Client client;
	
	public Order() {
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
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

	// Adiciona o item de pedido (OrderItem) a lista (Order)
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		double totalPrice = 0.0;
		for(OrderItem item : items) {
			totalPrice += item.subTotal();
		}
		return totalPrice;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nORDER SUMMARY:\n");
		sb.append("Order moment: ");
		sb.append(sdf.format(moment));
		sb.append("\nOrder status: ");
		sb.append(status);
		sb.append(client);
		sb.append("\nOrder items:\n");
		for(OrderItem o : items) {
			sb.append(o);
		}
		sb.append("Total price: $");
		sb.append(total());
		return sb.toString();
	}
}
