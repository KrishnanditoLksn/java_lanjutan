package org.example.innerclass.burger;

public class Meal {

    private Item burger;
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
        burger = new Item("regular", "burger");
        drink = new Item("coke", "drink", 1.5);
        System.out.println(drink.name);
        side = new Item("fries", "side", 2.0);
    }


    public double getTotal() {
        double total = burger.price + drink.price + side.price;

        return Item.getPrice(total, conversionRate);
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%26s$%.2f".formatted(burger, drink, side, "Total due:", getTotal());
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

        public Burger(String name, String type, double price) {
            super(name, type, price);
        }



    }

}
