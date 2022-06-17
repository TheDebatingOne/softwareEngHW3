public class QueueOverflowException extends QueueException{
    public QueueOverflowException(String message){
        super(message);
    }
    public QueueOverflowException(){
        super("The queue is full");
    }
}
