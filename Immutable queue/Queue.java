public interface Queue<T>{
    /**
     * Insert the element at the end of the immutable queue,
     * and returns the new queue.
     */
    public Queue<T> enQueue(T t);

    /**
     * Removes the element at the beginning of the immutable queue,
     * and returns the new queue.
     */
    public Queue<T> deQueue() throws Exception;

    public T head() throws Exception;

    public boolean isEmpty();
}