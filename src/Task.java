import java.util.Date;

public class Task implements Cloneable, Comparable<Task> {


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

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }


    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param otherTask the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(Task otherTask) {
        return (dueDate.compareTo(otherTask.getDueDate())); //Due date based comparison

    }
}
