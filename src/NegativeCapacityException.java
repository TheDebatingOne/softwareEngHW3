public class NegativeCapacityException extends QueueException{
    public NegativeCapacityException(String message){
        super(message);
    }
    public NegativeCapacityException(){
        super("The queue must have non-negative capacity!");
    }
}
