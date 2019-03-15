package ru.boiko.se;

public class App {

    public static void main(String[] args) {
        System.out.println(exp(5, 4));
    }

    private static double exp(int value, int power) {
        if (value == 0) return 0;
        if (power == 0) return 1;

        if (power > 0) {
            return exp(value, --power) * value;
        } else {
            return 1 / exp(value, (power * (-1)));
        }
    }


}
