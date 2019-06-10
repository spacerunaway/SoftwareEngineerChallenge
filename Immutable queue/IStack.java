/**
 * When I make a data structure immutable, First I think the basically trick:
 * an operation which “changes” the data structure does so by constructing a new data structure.
 * The original data structure stays the same.
 *
 * However, How can that possibly be efficient?
 * The idea is to allocating memory all over the place!
 * @param <T>
 */
public final class IStack<T> implements Stack<T>{
    private final T head;
    private final Stack<T> tail;

    private IStack(T value, Stack<T> tail){
        this.head = value;
        this.tail = tail;
    }
    public final static Stack getEmptyStack(){
        return EmptyStack.getInstance();
    }
    @Override
    public final Stack<T> push(T value){
        return new IStack<T>(value,this);
    }
    @Override
    public final Stack<T> pop(){
        return tail;
    }
    @Override
    public final T head(){
        return head;
    }
    @Override
    public final boolean isEmpty(){
        return false;
    }

    /**
     * cos empty stack is the same,
     * we create a singleton empty stack.
     * @param <T>
     */
    private static final class EmptyStack<T> implements Stack<T>{
        private static EmptyStack empty_stack;

        public final static EmptyStack getInstance(){
            if (empty_stack == null){
                empty_stack = new EmptyStack();
            }
            return empty_stack;
        }

        @Override
        public final IStack<T> push(T value){
            return new IStack<T>(value,this);
        }
        @Override
        public final IStack<T> pop() throws Exception{
            throw new Exception("This stack is Empty");
        }
        @Override
        public final T head() throws Exception{
            throw new Exception("This stack is Empty");
        }
        @Override
        public final boolean isEmpty(){
            return true;
        }
    }
}