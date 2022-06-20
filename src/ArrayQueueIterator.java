import java.util.Iterator;

public class ArrayQueueIterator<E extends Cloneable> implements Iterator<E> {
    private ArrayQueue<E> arrayQueue;
    private int nextIndex;


    public ArrayQueueIterator(ArrayQueue<E> arrayQueue){
        this.arrayQueue = arrayQueue;
        this.nextIndex = 0;
    }



    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */

    @Override
    public boolean hasNext() {
        return !(nextIndex > this.arrayQueue.getRear());
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public E next() {
        ++nextIndex;
        return (E) this.arrayQueue.getData()[nextIndex - 1];
    }
}
