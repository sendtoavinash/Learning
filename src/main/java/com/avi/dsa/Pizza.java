package com.avi.dsa;


import java.util.*;

class Pizza {
    public String name;
    public int price_S;
    public int price_M;
    public int price_L;

    public Pizza(String name, int price_S, int price_M, int price_L) {
        this.name = name;
        this.price_S = price_S;
        this.price_M = price_M;
        this.price_L = price_L;
    }
}

class OrderItem {
    public String name;
    public String size;
    public int quantity;

    public OrderItem(String name, String size, int quantity) {
        this.name = name;
        this.size = size;
        this.quantity = quantity;
    }
}

class Solution {
    public int solution(Pizza[] menu, OrderItem[] order) {
        Map<String, Pizza> pizzaMap = new HashMap<>();
        for (Pizza pizza : menu) {
            pizzaMap.put(pizza.name, pizza);
        }

        int baseCost = 0;
        List<Integer> smallPrices = new ArrayList<>();
        List<Integer> mediumPrices = new ArrayList<>();
        List<Integer> largePrices = new ArrayList<>();
        Map<String, Integer> largePizzaCount = new HashMap<>();
        Map<String, Integer> smallPizzaCount = new HashMap<>();

        for (OrderItem item : order) {
            Pizza pizza = pizzaMap.get(item.name);
            int price = 0;
            switch (item.size) {
                case "Small":
                    price = pizza.price_S;
                    smallPrices.add(pizza.price_S * item.quantity);
                    smallPizzaCount.put(item.name, item.quantity);
                    break;
                case "Medium":
                    price = pizza.price_M;
                    mediumPrices.add(pizza.price_M * item.quantity);
                    break;
                case "Large":
                    price = pizza.price_L;
                    largePrices.add(pizza.price_L * item.quantity);
                    largePizzaCount.put(item.name, item.quantity);
                    break;
            }
            baseCost += price * item.quantity;
        }

        // Applying Discount 1: "Buy 3, the cheapest one is free!"
        int discount1Cost = calculateDiscount1Cost(baseCost, smallPrices, mediumPrices, largePrices);

        // Applying Discount 2: "Buy 5 for 100"
        int discount2Cost = calculateDiscount2Cost(baseCost, smallPrices, mediumPrices, largePrices);

        // Applying Discount 3: "For every Large pizza, get a free Small one!"
        int discount3Cost = calculateDiscount3Cost(baseCost, largePizzaCount, smallPizzaCount, pizzaMap);

        // Applying Discount 4: "Buy 3 Large, pay for 3 Medium!"
        int discount4Cost = calculateDiscount4Cost(baseCost, largePizzaCount, pizzaMap);

        // Find the minimum cost among all scenarios
        return Math.min(Math.min(Math.min(baseCost, discount1Cost), discount2Cost), Math.min(discount3Cost, discount4Cost));
    }

    private int calculateDiscount1Cost(int baseCost, List<Integer> smallPrices, List<Integer> mediumPrices, List<Integer> largePrices) {
        int discount1Cost = baseCost;
        List<Integer> allPrices = new ArrayList<>();
        allPrices.addAll(smallPrices);
        allPrices.addAll(mediumPrices);
        allPrices.addAll(largePrices);
        Collections.sort(allPrices);
        int freePizzas = allPrices.size() / 3;
        for (int i = 0; i < freePizzas; i++) {
            discount1Cost -= allPrices.get(i);
        }
        return discount1Cost;
    }

    private int calculateDiscount2Cost(int baseCost, List<Integer> smallPrices, List<Integer> mediumPrices, List<Integer> largePrices) {
        int discount2Cost = baseCost;
        List<Integer> allPrices = new ArrayList<>();
        allPrices.addAll(smallPrices);
        allPrices.addAll(mediumPrices);
        allPrices.addAll(largePrices);
        int totalPizzas = 0;
        for (int price : allPrices) {
            totalPizzas += price / price;
        }
        int setsOfFive = totalPizzas / 5;
        discount2Cost = baseCost - setsOfFive * 500 + setsOfFive * 100;
        return discount2Cost;
    }

    private int calculateDiscount3Cost(int baseCost, Map<String, Integer> largePizzaCount, Map<String, Integer> smallPizzaCount, Map<String, Pizza> pizzaMap) {
        int discount3Cost = baseCost;
        for (Map.Entry<String, Integer> entry : largePizzaCount.entrySet()) {
            String pizzaName = entry.getKey();
            int largeCount = entry.getValue();
            int smallCount = smallPizzaCount.getOrDefault(pizzaName, 0);
            Pizza pizza = pizzaMap.get(pizzaName);
            int freeSmallPizzas = Math.min(largeCount, smallCount);
            discount3Cost -= freeSmallPizzas * pizza.price_S;
        }
        return discount3Cost;
    }

    private int calculateDiscount4Cost(int baseCost, Map<String, Integer> largePizzaCount, Map<String, Pizza> pizzaMap) {
        int discount4Cost = baseCost;
        for (Map.Entry<String, Integer> entry : largePizzaCount.entrySet()) {
            String pizzaName = entry.getKey();
            int largeCount = entry.getValue();
            Pizza pizza = pizzaMap.get(pizzaName);
            int setsOfThree = largeCount / 3;
            discount4Cost -= setsOfThree * (pizza.price_L - pizza.price_M) * 3;
        }
        return discount4Cost;
    }
}
