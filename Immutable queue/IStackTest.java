import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class IStackTest {

    @Test
    public void testEmptyPush() {
        try {
            Stack<Integer> stack = IStack.getEmptyStack();
            stack = stack.push(5);
            assertEquals(stack.head().intValue(), 5);
        } catch (Exception expected) {}
    }
    @Test
    public void testEmptyPop() {
        try {
            Stack<Integer> stack = IStack.getEmptyStack();
            stack = stack.pop();
        } catch (Exception expected) {
            assertThat(expected.getMessage(), equalTo("This stack is Empty"));
        }
    }
    @Test
    public void testEmptyHead() {
        try {
            Stack<Integer> stack = IStack.getEmptyStack();
            Integer v = stack.head();
        } catch (Exception expected) {
            assertThat(expected.getMessage(), equalTo("This stack is Empty"));
        }
    }
    @Test
    public void testEmptyisEmpty() {
        Stack<Integer> stack = IStack.getEmptyStack();
        assertEquals(stack.isEmpty(), true);
    }
    @Test
    public void testPushAndPop() {
        try {
            Stack<Integer> stack = IStack.getEmptyStack();
            stack = stack.push(5);
            assertEquals(stack.head().intValue(), 5);
            stack = stack.push(10);
            assertEquals(stack.head().intValue(), 10);
            stack = stack.push(1);
            stack = stack.push(13);
            stack = stack.push(1);
            assertEquals(stack.head().intValue(), 1);
            stack = stack.pop();
            stack = stack.pop();
            assertEquals(stack.head().intValue(), 1);
            stack = stack.push(12);
            assertEquals(stack.head().intValue(), 12);
        } catch (Exception expected) {
            fail();
        }
    }
    @Test
    public void testisEmpty() {
        Stack<Integer> stack = IStack.getEmptyStack();
        stack = stack.push(12);
        assertEquals(stack.isEmpty(), false);
    }
    @Test
    public void testImmutability() {
        try {
            Stack<Integer> stack = IStack.getEmptyStack();
            stack = stack.push(42);
            Stack<Integer> stack2 = stack.push(5);
            Stack<Integer> stack3 = stack.push(10);
            Stack<Integer> stack4 = stack2.push(7);
            assertEquals(stack.head().intValue(), 42);
            assertEquals(stack2.head().intValue(), 5);
            assertEquals(stack3.head().intValue(), 10);
            assertEquals(stack4.head().intValue(), 7);
            Stack<Integer> stack5 = stack4.pop();
            assertEquals(stack4.head().intValue(), 7);
            assertEquals(stack5.head().intValue(), 5);
        } catch (Exception expected) {
            fail();
        }
    }
}