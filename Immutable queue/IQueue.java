/**
 * Queue is FIFO structure and Stack is LIFO structure
 * so essentially stack is a tail to head queue.
 * However if we use the same idea of Stack,
 * every dequeue cost O(2n) time complexity.
 * Because We need reverse stack and pop them and then reverse again.
 *
 * So the idea is we take two stack, one is head to tail ready to be dequeued,
 * and other is tail to head ready to be enqueued.
 * If we go to dequeue and find that the head to tail stack is empty,
 * only then will we reverse the tail to head stack.
 *
 * @param <T>
 */
public final class IQueue<T> implements Queue<T>{
    private final Stack<T> head_to_tail;
    private final Stack<T> tail_to_head;

    private IQueue(Stack<T> head_to_tail, Stack<T> tail_to_head){
        this.head_to_tail = head_to_tail;
        this.tail_to_head = tail_to_head;
    }
    public final static Stack reverseStack(Stack stack) throws Exception{
        Stack reversed_stack = IStack.getEmptyStack();
        while(!stack.isEmpty()){
            reversed_stack = reversed_stack.push(stack.head());
            stack = stack.pop();
        }
        return reversed_stack;
    }
    public final static Queue getEmptyQueue(){
        return EmptyQueue.getInstance();
    }

    @Override
    public final Queue<T> enQueue(T value) {
        return new IQueue<T>(head_to_tail, tail_to_head.push(value));
    }
    @Override
    public final Queue<T> deQueue() throws Exception {
        Stack<T> f = head_to_tail.pop();
        if (!f.isEmpty()){
            return new IQueue<T>(f, tail_to_head);
        }
        else if (tail_to_head.isEmpty()){
            return IQueue.getEmptyQueue();
        }
        else {
            return new IQueue<T>(IQueue.reverseStack(tail_to_head), IStack.getEmptyStack());
        }
    }
    @Override
    public final T head() throws Exception {
        return head_to_tail.head();
    }
    @Override
    public final boolean isEmpty() {
        return false;
    }

    /**
     * cos empty queue is the same,
     * we create a singleton empty queue.
     * @param <T>
     */
    private static final class EmptyQueue<T> implements Queue<T>{
        private static EmptyQueue empty_queue;

        private static final EmptyQueue getInstance(){
            if (empty_queue == null){
                empty_queue = new EmptyQueue();
            }
            return empty_queue;
        }
        @Override
        public final Queue<T> enQueue(T value) {
            Stack head_to_tail = IStack.getEmptyStack().push(value);
            Stack tail_to_head = IStack.getEmptyStack();
            return new IQueue<T>(head_to_tail, tail_to_head);
        }
        @Override
        public final Queue<T> deQueue() throws Exception {
            throw new Exception("This Queue is Empty");
        }
        @Override
        public final T head() throws Exception {
            throw new Exception("This Queue is Empty");
        }
        @Override
        public final boolean isEmpty() {
            return true;
        }
    }
}
