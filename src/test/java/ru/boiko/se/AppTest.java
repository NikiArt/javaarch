package ru.boiko.se;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class AppTest {
    public static final int ARRAY_VOLUME = 800;
    public static final int MIN_BORDER = 500;
    public static final int MAX_BORDER = 15000;
    public static final int ITERATION_VOLUME = 10;
    private long start;
    private long finish;
    private long timeConsumedMillis;

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void ArraySortSpeedTest() {
        final IntCmp comparator = new IntCmp();
        System.out.println("num\t|\tselection\t|\tinsertion");
        for (int i = 0; i < ITERATION_VOLUME; i++) {
            System.out.print("" + (i + 1) + "\t");
            final MyArrayList listS = createCalc();
            final MyArrayList listI = copyList(listS);
            start = System.currentTimeMillis();
            listS.selectionSort(comparator);
            finish = System.currentTimeMillis();
            timeConsumedMillis = finish - start;
            System.out.print("|\t\t" + timeConsumedMillis + "\t");
            start = System.currentTimeMillis();
            listI.insertionSort(comparator);
            finish = System.currentTimeMillis();
            timeConsumedMillis = finish - start;
            System.out.print("|\t\t" + timeConsumedMillis);
            System.out.println();
        }
    }

    public static String reverse(String original) {
        if (original.length() == 0) return original;
        StringBuilder sb = new StringBuilder();
        MyArrayStack<Character> stack = new MyArrayStack<Character>();

        for (int i = 0; i < original.length(); i++) {
            stack.push(original.charAt(i));
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    private MyArrayList copyList(MyArrayList listS) {
        final MyArrayList<Integer> currentList = new MyArrayList<>();
        for (int i = 0; i < listS.size(); i++) {
            currentList.add((Integer) listS.get(i));
        }
        return currentList;
    }

    private MyArrayList createCalc() {
        final MyArrayList<Integer> currentList = new MyArrayList<>();
        for (int i = 0; i < ARRAY_VOLUME; i++) {
            int val = (int) (Math.random() * (MAX_BORDER - MIN_BORDER) + MIN_BORDER);
            currentList.add(val);
        }
        return currentList;
    }

    @Test
    public void reverseStringFun() {
        String currentString = "abcdef";
        System.out.println(currentString);
        String reversString = reverse(currentString);
        System.out.println(reversString);

    }

    @Test
    public void balanceTree() {
        int treeNumber = 20;
        int treeHeight = 6;
        int balanced = 0;
        int value = 0;
        for (int i = 0; i < treeNumber; i++) {
            MyTreeMap<Integer, Integer> map = new MyTreeMap<>();

            while (map.height() < treeHeight + 1) {
                value = (int) (Math.random() * 200 - 100);
                map.put(value, value);
                //System.out.println(map.height());
            }
            if (map.isBalanced()) balanced++;
        }

        System.out.println(balanced);
        double balancedP = (balanced / treeNumber) * 100;

        System.out.println("Balanced trees - " + balancedP + "%");
    }

    @Test
    public void graph() {
        Graph g = new Graph(6);
        g.addEdge(0, 2);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(5, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 2);
        g.addEdge(4, 2);
        g.addEdge(5, 0);

        WidthFirstPaths bfp = new WidthFirstPaths(g, 0);
        System.out.println(bfp.hasPathTo(5));
        System.out.println(bfp.pathTo(3));
        System.out.println(bfp.pathTo(5));
        System.out.println(bfp.distTo(1));
        System.out.println(bfp.distTo(2));
        System.out.println(bfp.distTo(3));
        System.out.println(bfp.distTo(4));
        System.out.println(bfp.distTo(5));
    }
}
