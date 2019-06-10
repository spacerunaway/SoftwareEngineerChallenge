import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class IQueueTest {

    @Test
    public void testEmptyEnqueue() {
        try {
            Queue<Integer> q = IQueue.getEmptyQueue();
            q = q.enQueue(5);
            assertEquals(q.head().intValue(), 5);
        } catch (Exception expected) {}
    }
    @Test
    public void testEmptyDequeue() {
        try {
            Queue<Integer> q = IQueue.getEmptyQueue();
            q = q.deQueue();
        } catch (Exception expected) {
            assertThat(expected.getMessage(), equalTo("This Queue is Empty"));
        }
    }
    @Test
    public void testEmptyHead() {
        try {
            Queue<Integer> q = IQueue.getEmptyQueue();
            Integer v = q.head();
        } catch (Exception expected) {
            assertThat(expected.getMessage(), equalTo("This Queue is Empty"));
        }
    }
    @Test
    public void testEmptyisEmpty() {
        Queue<Integer> q = IQueue.getEmptyQueue();
        assertEquals(q.isEmpty(), true);
    }
    @Test
    public void testenQueueAndDeQueue() {
        try {
            Queue<Integer> q = IQueue.getEmptyQueue();
            q = q.enQueue(5);
            assertEquals(q.head().intValue(), 5);
            q = q.enQueue(10);
            assertEquals(q.head().intValue(), 5);
            q = q.enQueue(1);
            q = q.enQueue(13);
            q = q.enQueue(1);
            assertEquals(q.head().intValue(), 5);
            q = q.deQueue();
            q = q.deQueue();
            assertEquals(q.head().intValue(), 1);
            q = q.enQueue(12);
            assertEquals(q.head().intValue(), 1);
        } catch (Exception expected) {
            fail();
        }
    }
    @Test
    public void testisEmpty() {
        Queue<Integer> q = IQueue.getEmptyQueue();
        q = q.enQueue(12);
        assertEquals(q.isEmpty(), false);
    }
    @Test
    public void testImmutability() {
        try {
            Queue<Integer> q = IQueue.getEmptyQueue();
            q = q.enQueue(42);
            Queue<Integer> q2 = q.enQueue(5);
            Queue<Integer> q3 = q.enQueue(10);
            Queue<Integer> q4 = q2.enQueue(7);
            /**
            q = [42]
            q2 = [42,5]
            q3 = [42,10]
            q4 = [42,5,7]
             */
            q2.deQueue();
            q3 = q3.deQueue();
            q4 = q4.deQueue().deQueue();
            assertEquals(q.head().intValue(),42);
            assertEquals(q2.head().intValue(), 42);
            assertEquals(q3.head().intValue(), 10);
            assertEquals(q4.head().intValue(), 7);
            q = q.deQueue();
            q = q.enQueue(7);
            Queue<Integer> q5 = q.deQueue().enQueue(5);
            assertEquals(q.head().intValue(), 7);
            assertEquals(q5.head().intValue(), 5);
        } catch (Exception expected) {
            fail();
        }
    }
}