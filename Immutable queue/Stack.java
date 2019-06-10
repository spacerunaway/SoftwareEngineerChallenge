public interface Stack<T>{
    /**
     * Insert the element at the end of the immutable stack,
     * and returns the new stack.
     */
    public Stack<T> push(T t);
    /**
     * Remove the element at the end of the immutable stack,
     * and returns the new stack.
     */
    public Stack<T> pop() throws Exception;

    public T head() throws Exception;

    public boolean isEmpty();
}