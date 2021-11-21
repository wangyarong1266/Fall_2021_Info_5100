package edu.northeastern.hw5;

import java.util.ArrayList;
import java.util.List;

public class Question3 {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("1234", 10);
        Item item2 = new Item("5678", 40);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.pay(new PayPal("myemail@example.com"));
        cart.pay(new CreditCard("1234567890123456"));
    }
}

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCard implements PaymentStrategy {
    private String cardNumber;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("CreditCard : $" + amount);
    }
}

class PayPal implements PaymentStrategy {
    private String email;

    public PayPal(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("PayPal : $" + amount);
    }
}

class Item {
    private String id;
    private int price;

    public Item(String id, int price) {
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Item item) {

            return this.price == item.getPrice() && this.id.equals(item.getId());
        }
        return false;
    }
}

class ShoppingCart {

    private List<Item> items;
    private int total;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.total = 0;
    }

    public void addItem(Item item) {
        items.add(item);
        total += item.getPrice();
    }

    public void removeItem(Item item) {
        if (items.remove(item)) {
            total -= item.getPrice();
        }
    }

    public int calculateTotal() {
        return total;
    }

    public void pay(PaymentStrategy strategy) {
        strategy.pay(calculateTotal());
    }
}
