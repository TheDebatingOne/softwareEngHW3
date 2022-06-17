import java.util.ArrayList;

public class ToDoList {
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
}
