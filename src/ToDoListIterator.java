import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ToDoListIterator implements Iterator<Task>{
    private Task nextTask;
    //nextTask is the next task in ToDoList's tasks arrayList. not the next with the correct dueDate! it's like a linked list
    private Date scanningDueDate;
    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */

    public ToDoListIterator(Task nextTask, Date scanningDueDate){
        this.nextTask = nextTask;
        this.scanningDueDate = scanningDueDate;
    }
    @Override
    public boolean hasNext() {
        if (scanningDueDate != null){ //if there's a date

        }
        return false; //if no next
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Task next() {
        if (!hasNext()){
            throw new  NoSuchElementException();
        }
        return this.nextTask;
    }
}
