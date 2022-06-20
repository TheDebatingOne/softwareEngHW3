import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

public class ToDoList implements Cloneable, TaskIterable{
    private ArrayList<Task> tasks;
    private Date scanningDueDate;

    public ToDoList(tasks)

    public void addTask(Task newTask){
        String description = newTask.getDescription();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i) != null && tasks.get(i).getDescription().equals(description)){
                throw new TaskAlreadyExistsException();
            }
        }
        //after checking there is no other task with this description
        tasks.get(tasks.size() - 1).setNextTask(newTask);
        tasks.add(newTask);
    }

    @Override
    public String toString(){
        StringBuilder toReturn = new StringBuilder("[");
        int size = tasks.size();
        for (int i = 0; i < size; i++) {
            if (tasks.get(i) != null){
                String toAppend = tasks.get(i).toString()+",";
                toReturn.append(toAppend);
                if (i == size- 1){ //last one
                    toReturn.append("]");
                } else {
                    toReturn.append(" ");
                }
            }
        }
        return toReturn.toString();
    }


    @Override
    public ToDoList clone() {
        try {
            ToDoList copy = (ToDoList) super.clone(); //shallow copy
            copy.tasks = new ArrayList<Task>();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            int size = tasks.size(); //initializing tasks arrayList
            for (int i = 0; i < size; i++) { //deep cloning - cloning each task in tasks arrayList
                if(tasks.get(i) != null){
                    copy.tasks.add(tasks.get(i).clone());
                }
            }
            return copy;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof ToDoList)) return false;
        ToDoList toDoList = (ToDoList) obj; //down casting (we can do it since we checked instanceof)
        if (this.tasks.size() != toDoList.tasks.size()) return false; // if not the same number of tasks...
        int size = this.tasks.size();
        for (int i = 0; i < size; i++) {
            if (!toDoList.tasks.contains(this.tasks.get(i))){ //if not containing same task (description and date)

                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode(){
        int hash = 1;
        int size  = tasks.size();
        for (int i = 0; i < size; i++) {
            hash = (hash * tasks.get(i).hashCode()) % Integer.MAX_VALUE;
        }
        return hash;
    }


    @Override
    public void setScanningDueDate(Date scanningDueDate) {
        this.scanningDueDate = scanningDueDate;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Task> iterator() {
        return new ToDoListIterator(this);
    }

    public void sort(){
        Collections.sort(this.tasks);
    }

}
