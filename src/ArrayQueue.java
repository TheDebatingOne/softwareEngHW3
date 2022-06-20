import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

public class ArrayQueue<E extends Cloneable> implements Queue<E>, Cloneable, Iterable<E> {
    private Cloneable[] data; //the array itself, containing the data
    private int maxCapacity; //max capacity of the arrayQueue
    private int front; //index of front of queue
    private int rear; //index of rear of queue
    //IMPORTANT: rear<front is possible
    private int numElements; //num of elements in the queue
    public ArrayQueue(int maxCapacity){
        if(maxCapacity < 0){
            throw new NegativeCapacityException();
        }
        this.maxCapacity = maxCapacity;
        this.data = new Cloneable[maxCapacity];
        this.front = -1;
        this.rear = -1;
        this.numElements = 0;
    }

    @Override
    public void enqueue(E element) {
        if (numElements == maxCapacity){
            throw new QueueOverflowException();
        }
        this.rear = (rear + 1) % maxCapacity; //cyclic, in order to use all available capaity...
        if(this.isEmpty()){ //if empty, "resetting" the queue
            this.front = 0;
            this.rear = 0;
        }
        this.numElements +=1;
        this.data[rear] = element;
    }

    @Override
    public E dequeue() {
        if(this.isEmpty()){ //the queue is empty
            throw new EmptyQueueException();
        }
        E toReturn = (E) data[front];
        this.data[front] = null;
        this.front = (front + 1) % maxCapacity; //cyclic, in order to use all available capaity..
        this.numElements -= 1;
        if(numElements == 1){ //if only one element (meaning front == end)
            front = -1; //"resetting" the array to empty, as in constructor
            rear = -1;
        }
        return toReturn;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            throw new EmptyQueueException();
        }
        return (E) data[front];
    }

    @Override
    public int size() {
        return this.numElements;
    }

    @Override
    public boolean isEmpty() {
        return numElements == 0 || front < 0 || rear < 0;
    }

    @Override
    public ArrayQueue<E> clone() {
        ArrayQueue<E> copy = null;
        try {
            copy = (ArrayQueue<E>) super.clone(); //initial shallow copy
            Method method = data[front].getClass().getMethod("clone");
            for (int i = 0; i < maxCapacity; i++){ //deep copy required
                copy.data[i] = (Cloneable) method.invoke(data[i]);
            }

        }
        catch (CloneNotSupportedException | NullPointerException e){
            return null;
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return copy;
    }


    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator<E>(this);
    }

    public int getRear() {
        return rear;
    }

    public Cloneable[] getData() {
        return data;
    }


}
