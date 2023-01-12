import exceptions.EmptyCollectionException;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class CircularArrayQueue<T> implements QueueADT<T> {

    private int DEFAULT_CAPACITY = 100;
    private T[] queue, newQueue;
    private int front, rear, count;


    public CircularArrayQueue(){

        count = 0;
        front = 0;
        rear = 0;
        queue = (T[]) (new Object[this.DEFAULT_CAPACITY]);
    }


    /** adicionar o elemento na cauda da structures.sortingAndSearching.array queue.
     * @param element o elemento que vai ser adicionado na cauda da structures.sortingAndSearching.array queue
     */
    @Override
    public void enqueue(T element) {

        //verificar se a structures.sortingAndSearching.array queue está cheia
        if(isFull()){
            expandCapacity();

        } else {

            queue[rear] = element;
            rear = (rear + 1) % queue.length;
            count++; //aumentar o nª de elementos na structures.sortingAndSearching.array queue
        }
    }


    /** retorna true se o count for igual ao tamanho da queue, e false caso contrário.
     * @return
     */
    private boolean isFull() {

        return (count == queue.length);
    }


    /** remove e retorna um elemento da cabeça da structures.sortingAndSearching.array queue.
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T dequeue() throws EmptyCollectionException {

        T result;

        if(isEmpty()){

            throw new EmptyCollectionException("a structures.sortingAndSearching.array queue está vazia");

        } else {

            result = queue[front];
            queue[front] = null;
            front = (front + 1) % queue.length;

            count--;
        }

        return result;
    }


    /** retorna o elemento que está na cabeça da structures.sortingAndSearching.array queue
     * @return o elemento que está na cabeça
     * @throws EmptyCollectionException
     */
    @Override
    public T first() throws EmptyCollectionException {

        if(isEmpty()){

            throw new EmptyCollectionException("a structures.sortingAndSearching.array queue está vazia");
        }

        return queue[front];
    }


    /** retorna true se a cabeça for igual a -1, e false caso contrário.
     * @return
     */
    @Override
    public boolean isEmpty() {

        return (count == 0);
    }


    /** retorna a contagem de elementos da structures.sortingAndSearching.array queue.
     * @return
     */
    @Override
    public int size() {

        return this.count;
    }


    /** se a queue chegou ao limite de capacidade, vai se expandir a capacidade da mesma.
     *
     */
    private void expandCapacity(){

        newQueue = (T[]) (new Object[DEFAULT_CAPACITY]);

        T[] test = Stream.concat(Arrays.stream(queue), Arrays.stream(newQueue)).toArray(
                size -> (T[]) Array.newInstance(queue.getClass().getComponentType(), size));

        queue = test;
    }


    /** retorna uma string composta pelos resultados de toString de cada elemento.
     * @return
     */
    @Override
    public String toString(){

        String arrayqueue = "";

        if(isEmpty()){

            System.out.print("Queue is Empty");
        }

        System.out.print("Elements in the circular queue are: ");

        if (rear >= front){
            for(int i = front; i < rear; i++){

                arrayqueue += queue[i] + " | ";
            }

        } else {

            for(int i = front; i < count; i++){

                arrayqueue += queue[i] + " | ";
            }
        }

        return arrayqueue;
    }
}
