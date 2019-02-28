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
}
