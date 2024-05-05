package deque;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addIsEmptySizeTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<String>();

        assertTrue("A newly initialized ArrayDeque should be empty", ad1.isEmpty());
        ad1.addFirst("front");

        assertEquals(1, ad1.size());
        assertFalse("ad1 should now contain 1 item", ad1.isEmpty());

        ad1.addLast("middle");
        assertEquals(2, ad1.size());

        ad1.addLast("back");
        assertEquals(3, ad1.size());

        System.out.println("Printing out deque: ");
        ad1.printDeque();
    }

    @Test
    public void addRemoveTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        assertTrue("ad1 should be empty upon initialization", ad1.isEmpty());

        ad1.addFirst(10);
        assertFalse("ad1 should contain 1 item", ad1.isEmpty());

        ad1.removeFirst();
        assertTrue("ad1 should be empty after removal", ad1.isEmpty());
    }

    @Test
    public void removeEmptyTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
    }

    @Test
    public void addLargeNumer() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 1000000; i++) {
            ad1.addFirst(i);
        }
        assertEquals("ad1 should contain 1000000 items", 1000000, ad1.size());


        for (int i = 0; i < 1000000; i++) {
            ad1.removeFirst();
        }
        assertTrue("ad1 should be empty after removal", ad1.isEmpty());
    }

    @Test
    public void getTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 1000000; i++) {
            ad1.addFirst(i);
        }
        assertEquals("ad1 should contain 1000000 items", 1000000, ad1.size());

        for (int i = 0; i < 1000000; i++) {
            assertEquals(i, (int) ad1.get(i));
        }
    }

    @Test
    public void getTest2() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            ad1.addFirst(i);
        }
        assertEquals("ad1 should contain 1000000 items", 5, ad1.size());

        for (int i = 0; i < 5; i++) {
            assertEquals(i, (int) ad1.get(i));
        }
    }

    public void testResize() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 1000000; i++) {
            ad1.addFirst(i);
        }
        assertEquals("ad1 should contain 1000000 items", 1000000, ad1.size());
    }

}
