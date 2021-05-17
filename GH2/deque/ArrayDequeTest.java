package deque;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class ArrayDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());
        /*
		System.out.println("Printing out deque: ");
		lld1.printDeque();
		*/
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {


        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {


        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        ArrayDeque<String>  lld1 = new ArrayDeque<String>();
        ArrayDeque<Double>  lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {


        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {


        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }
    }

    @Test
    public void testingPrint(){
        ArrayDeque<Integer> arr1 = new ArrayDeque<>();
        for (int i = 1; i <101; i+=1){
            arr1.addLast(i);
        }
        arr1.printDeque();
    }

    @Test
    public  void equalsTest(){
        ArrayDeque<Integer> test1 = new ArrayDeque<>();
        ArrayDeque<Integer> test2 = new ArrayDeque<>();
        ArrayDeque<Integer> test3 = new ArrayDeque<>();
        for (int i = 0; i < 100; i+=1){
            test1.addLast(i);
            test2.addLast(i);
            test3.addLast(4);
        }
        System.out.println(test1.equals(test1));
        System.out.println(test1.equals(test2));
        System.out.println(test1.equals(test3));

    }

    @Test
    public  void testingIterator(){
        ArrayDeque<Integer> iter_test = new ArrayDeque<>();
        Iterator<Integer> seer = iter_test.iterator();

        for (int i = 1; i < 101; i+=1){
            iter_test.addLast(i);
        }
        for (int i : iter_test){
            System.out.println(i);
        }
        iter_test.printDeque();
    }

    @Test
    public  void getTests(){
        ArrayDeque<Integer> get_test = new ArrayDeque<>();

        for (int i = 1; i < 101; i+=1){
            get_test.addLast(i);
        }
        get_test.printDeque();

        System.out.println(get_test.get(0));
        System.out.println(get_test.get(1));
        System.out.println(get_test.get(2));
        System.out.println(get_test.get(3));
        System.out.println(get_test.get(4));

        get_test.removeFirst();
        get_test.removeFirst();
        get_test.removeFirst();
        get_test.removeFirst();
        get_test.removeFirst();

        get_test.printDeque();

        System.out.println(get_test.get(0));
        System.out.println(get_test.get(1));
        System.out.println(get_test.get(2));
        System.out.println(get_test.get(3));
        System.out.println(get_test.get(4));
    }

    @Test
    public  void guitarTests(){
        ArrayDeque<Double> guitar_test = new ArrayDeque<>();

        for (int i = 0; i < 50; i+=1){
            guitar_test.addLast((double) 0);
        }
        System.out.println(guitar_test.size());
        guitar_test.printDeque();

        int capacity = guitar_test.size();
        for (int i = 0; i < capacity; i+=1) {
            guitar_test.removeLast();
        }

        System.out.println(guitar_test.size());
        guitar_test.printDeque();

        for (int i = 0; i < capacity; i+=1) {
            double r = Math.random() - 0.5;
            guitar_test.addLast((double)i);
        }

        System.out.println(guitar_test.size());
        guitar_test.printDeque();

        double first_val = guitar_test.get(0);
        double second_val = guitar_test.get(1);
        double replace_val = (0.996 * (1/2 * (first_val + second_val)));


        guitar_test.removeFirst();
        guitar_test.addLast(replace_val);

        System.out.println(guitar_test.size());
        guitar_test.printDeque();

    }

    @Test
    public  void moreEqualsTest() {

        ArrayDeque<Integer> test1 = new ArrayDeque<>();
        LinkedListDeque<Integer> test2 = new LinkedListDeque<>();
        ArrayDeque<Integer> test3 = new ArrayDeque<>();
        for (int i = 0; i < 100; i+=1) {

            test1.addLast(i);
            test2.addLast(i);
        } 
        test3.addFirst(44);

        System.out.println(test1.equals(test1));
        System.out.println(test1.equals(test2));
        System.out.println(test1.equals(test3));


        ArrayDeque<Integer> emptyArr = new ArrayDeque<>();
        ArrayDeque<Integer> emptyArr2 = new ArrayDeque<>();
        LinkedListDeque<Integer> emptyLink = new LinkedListDeque<>();

        assertEquals(emptyArr.equals(emptyArr2), true);
        assertEquals(emptyArr.equals(emptyLink), true);

    }

    @Test
    public void hasNextTest() {

        ArrayDeque<Integer> emptyArr = new ArrayDeque<>();
        ArrayDeque<Integer> Arr2 = new ArrayDeque<>();

        assertEquals(emptyArr.iterator().hasNext(), false);

        for (int i = 0; i < 100; i += 1) {
            Arr2.addLast(i);
        }

        int index = 0;

        while (Arr2.iterator().hasNext()) {

            System.out.println(Arr2.get(index));
            index += 1;
        }

    }

}
