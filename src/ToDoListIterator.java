import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ToDoListIterator implements Iterator<Task>{
    private int nextIndex;
    private ToDoList list;
    //nextTask is the next task in ToDoList's tasks arrayList. not the next with the correct dueDate! it's like a linked list
    private Date scanningDueDate;
    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */

    public ToDoListIterator(ToDoList toDoList){
        this.list = toDoList.clone();
        this.list.sort();
        nextIndex = 0;
    }
    @Override
    public boolean hasNext() {
        return nextIndex != list.si && (scanningDueDate == null || scanningDueDate.compareTo(nextTask.getDueDate()) <= 0);
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
        nextTask = nextTask.getNextTask();
        return nextTask;
    }
}
