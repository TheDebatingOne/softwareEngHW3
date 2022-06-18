import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ToDoListIterator implements Iterator<Task>{
    private Task nextTask;
    private Date scanningDueDate;

    public ToDoListIterator(Date scanningDueDate){
        this.scanningDueDate = scanningDueDate;
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
        return false;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Task next() {
        return null;
    }
}
