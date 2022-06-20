import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ToDoListIterator implements Iterator<Task>{
    private int nextIndex;
    private ToDoList list;
    //nextTask is the next task in ToDoList's tasks arrayList. not the next with the correct dueDate! it's like a linked list
    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */

    public ToDoListIterator(){
        this.list = new ToDoList();
    }
    public ToDoListIterator(ToDoList toDoList){
        this.list = toDoList.clone();
        this.list.sort();
        nextIndex = 0;
    }
    @Override
    public boolean hasNext() {
        try {
            ArrayList<Task> tasks = this.list.getTasks();
            return nextIndex != tasks.size() && tasks.get(nextIndex).getDueDate().compareTo(this.list.getScanningDueDate()) < 1;
        }
        catch (NullPointerException e){
            return false;
        }
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Task next() {
        ++this.nextIndex;
        return this.list.getTasks().get(nextIndex - 1);
    }
}
