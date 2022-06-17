public class TaskAlreadyExistsException extends RuntimeException{
    public TaskAlreadyExistsException(){
        super("A task with the same description already exists!");
    }
}
