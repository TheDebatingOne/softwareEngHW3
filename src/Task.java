import java.util.Date;

public class Task implements Cloneable {


    private String description;
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
            Task copy = (Task) super.clone();
            copy.dueDate = (Date) this.dueDate.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString(){
        String dateString = this.dueDate.toString();
        return "(" + this.description + "," + dateString + ")";
    }
}
