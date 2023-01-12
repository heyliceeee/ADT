import exceptions.EmptyCollectionException;

public class LinkedQueue<T> implements QueueADT<T> {

    int count;

    LinkedNode<T> front, rear;

    public LinkedQueue(){

        this.count = 0;
        this.front = null;
        this.rear = null;
    }


    /** adicionar o elemento na cauda da queue
     * @param element o elemento que vai ser adicionado na cauda da queue
     */
    @Override
    public void enqueue(T element){

        //definir LinkedNode
        LinkedNode<T> newNode = new LinkedNode<T>(element);
        newNode.setElement(element);

        //verificar se a queue está vazia
        if(front == null){

            rear = newNode;
            front = newNode;

        } else {

            rear.setNext(newNode);
            rear = newNode;
        }

        this.count++;
    }


    /** remove e retorna um elemento da cabeça da queue
     * @return o elemento removido da cabeça da queue
     * @throws EmptyCollectionException
     */
    @Override
    public T dequeue() throws EmptyCollectionException {

        if(isEmpty()){

            throw new EmptyCollectionException("a queue está vazia");
        }

        //definir linkedNode
        LinkedNode<T> temp = this.front;

        //avançar para o próximo node
        this.front = this.front.getNext();

        //se a queue ficar vazia
        if(front == null){

            this.rear = null;
        }

        //node removido
        T item = temp.getElement();

        this.count--;

        return item;
    }


    /** retorna o elemento que está na cabeça da queue
     * @return o elemento que está na cabeça
     * @throws EmptyCollectionException
     */
    @Override
    public T first() throws EmptyCollectionException{

        if(isEmpty()){

            throw new EmptyCollectionException("a queue está vazia");
        }

        //elemento da cabeça
        T result = front.getElement();

        return result;
    }


    /** retorna true se a contagem dos elementos é 0, e false caso contrário
     * @return
     */
    @Override
    public boolean isEmpty(){

        return (count == 0);
    }


    /** retorna a contagem de elementos da queue
     * @return
     */
    @Override
    public int size(){

        return this.count;
    }


    /** retorna uma string composta pelos resultados de toString de cada elemento
     * @return
     */
    @Override
    public String toString(){

        LinkedNode<T> current = this.front;

        String queue = "\n";

        while (current != null){

            queue += current.getElement().toString() + "\n";

            current = current.getNext();
        }

        return queue;
    }
}
