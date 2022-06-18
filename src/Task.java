import java.util.Date;

public class Task implements Cloneable {


    private final String description;
    private Date dueDate;

    public Task(String description, Date date){
        this.description = description;
        this.dueDate = date;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    @Override
    public Task clone() {
        try {
            Task copy = (Task) super.clone(); //shallow cloning
            copy.dueDate = (Date) this.dueDate.clone(); //deep cloning
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return copy;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString(){
        String dateString = this.dueDate.toString();
        return "(" + this.description + "," + dateString + ")";
    }

    @Override
    public boolean equals (Object obj){
        if(!(obj instanceof Task)) return false; //if not task at all...
        Task task = (Task) obj; //downcasting
        return this.description.equals(task.description) && this.dueDate.equals(task.dueDate);
    }

    @Override
    public int hashCode(){
        return description.hashCode() * dueDate.hashCode();
    }
}
