import exceptions.EmptyCollectionException;

public interface QueueADT<T> {

    /** adiciona um elemento na cauda da queue.
     * @param element o elemento que vai ser adicionado na cauda da queue
     */
    public void enqueue(T element);


    /** remove e retorna o elemento da cabeça da queue.
     * @return o elemento da cabeça da queue
     */
    public T dequeue() throws EmptyCollectionException;


    /** retorna sem remover o elemento da cabeça da queue.
     * @return o primeiro elemento da queue
     */
    public T first() throws EmptyCollectionException;


    /** retorna true se a queue não conter nenhum elemento.
     * @return true se a queue estiver vazia
     */
    public boolean isEmpty();


    /** retorna o número de elementos da queue.
     * @return o número de elementos da queue
     */
    public int size();


    /** retorna uma string da queue.
     * @return uma string da queue
     */
    @Override
    public String toString();
}
