package ru.boiko.se;

public class App {

    public static void main(String[] args) {
        createChainingHashMap();
    }

    private static void createChainingHashMap() {
        final MyChainingHashMap<Character, Integer> map = new MyChainingHashMap<Character, Integer>();
        map.put('a', 1);
        map.put('r', 7);
        map.put('i', 22);
        map.put('t', 31);
        map.put('l', 678);
        map.put('z', 32);

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
