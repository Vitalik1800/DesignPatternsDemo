package com.vs18.designpatternsdemo.builder;

import androidx.annotation.NonNull;
import java.util.*;

public class Pizza {

    private final String size, dough, sauce;
    private final List<String> toppings;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.dough = builder.dough;
        this.sauce = builder.sauce;
        this.toppings = builder.toppings;
    }

    @NonNull
    @Override
    public String toString() {
        return "Піца:\n" +
                " Розмір: " + size + "\n" +
                " Тісто: " + dough + "\n" +
                " Соус: " + sauce + "\n" +
                " Топінги: " + String.join(", ", toppings);
    }

    public static class Builder {
        private String size = "Середня";
        private String dough = "Стандартне";
        private String sauce = "Томатний";
        private final List<String> toppings = new ArrayList<>();

        public Builder size(String size) {
            this.size = size;
            return this;
        }

        public Builder dough(String dough) {
            this.dough = dough;
            return this;
        }

        public Builder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public Builder topping(String topping) {
            this.toppings.add(topping);
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
