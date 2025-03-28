package org.example.innerclass.burger;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private Burger burger;
    private Item drink;
    private Item side;
    private double price = 5.0;

    private double conversionRate;

    //attribute can access directly without getter/setters

    public Meal() {
        this(1);
    }

    public Meal(double conversionRate) {
        this.conversionRate = conversionRate;
        burger = new Burger("regular");
        drink = new Item("coke", "drink", 1.5);
        System.out.println(drink.name);
        side = new Item("fries", "side", 2.0);
    }


    public double getTotal() {
        double total = burger.getPrice() + drink.price + side.price;

        return Item.getPrice(total, conversionRate);
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%26s$%.2f".formatted(burger, drink, side, "Total due:", getTotal());
    }

    public void addToppings(String... selectedTopings) {
        burger.addTopings(selectedTopings);
    }

    public class Item {
        private String name;
        private String type;
        private double price;


        public Item(String name, String type) {
            this(name, type, type.equals("burger") ? Meal.this.price : 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        private static double getPrice(double price, double rate) {
            return price * rate;
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name, getPrice(price, conversionRate));
        }
    }

    public class Burger extends Item {
        private List<Item> toppings = new ArrayList<>();

        public Burger(String name) {
            super(name, "burger", 5.0);
        }

        public double getPrice() {
            double total = super.price;

            for (Item topping : toppings) {
                total += topping.price;
            }
            return total;
        }

        public void addTopings(String... topings) {
            for (String i : topings) {
                Toppings toppings1 = Toppings.valueOf(i.toUpperCase());
                toppings.add(new Item(toppings1.name(), "TOPPING", toppings1.getPrice()));
            }
        }


        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(super.toString());

            for (Item topping : toppings) {
                stringBuilder.append("\n");
                stringBuilder.append(topping);
            }
            return stringBuilder.toString();
        }
    }


    enum Toppings {
        BEACON,
        BBQ,
        CHEESE;

        private double getPrice() {
            return switch (this) {
                case BEACON -> 0.1;

                case BBQ -> 0.2;

                case CHEESE -> 0.6;
            };
        }
    }
}
