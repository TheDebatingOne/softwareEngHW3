import java.util.ArrayList;

public class ToDoList implements Cloneable{
    private ArrayList<Task> tasks;

    public void addTask(Task task){
        String description = task.getDescription();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i) != null && tasks.get(i).getDescription().equals(description)){
                throw new TaskAlreadyExistsException();
            }
        }
        //after checking there is no other task with this description
        tasks.add(task);
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
        boolean foundTask; //a flag to mark finding a task with same description (aka equal task)
        for (int i = 0; i < size; i++) {
            foundTask = false;
            for (int j = 0; j < size; j++) {
                Task taskA = this.tasks.get(i);
                Task taskB = toDoList.tasks.get(j);
                if(taskA.getDescription().equals(taskB.getDescription())){
                    foundTask = true;
                    if (!taskA.getDueDate().equals(taskB.getDueDate())){
                        return false;
                    }
                }
            }
            if (!foundTask){ //if we first list has a task which second list doesn't have...
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
}
