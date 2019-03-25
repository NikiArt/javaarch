package ru.boiko.se;

public class App {

    public static void main(String[] args) {
        System.out.println(exp(5, 4));
        System.out.println(expLoop(2, 10));
        createChainingHashMap();
    }

    private static void createChainingHashMap() {
        final MyChainingHashMap<String, String> map = new MyChainingHashMap<String, String>();
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

    public static double expLoop(double value, int power) {
        if (value == 0) return 0;
        if (power == 0) return 1;

        int currentpower = power < 0 ? power * (-1) : power;

        double result = 1;
        while (currentpower > 0) {
            result = result * value;
            currentpower--;
        }
        if (power < 0) result = 1 / result;
        return result;
    }


}
