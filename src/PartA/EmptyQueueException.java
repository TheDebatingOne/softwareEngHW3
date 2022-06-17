public class EmptyQueueException extends QueueException{
    public EmptyQueueException(String message){
        super(message);
    }
    public EmptyQueueException(){
        super("The queue is empty");
    }
}
