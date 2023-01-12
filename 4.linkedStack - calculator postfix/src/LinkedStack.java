import exceptions.NullException;

public class LinkedStack<T> {

    int count;
    LinkedNode<T> top;

    public LinkedStack(){

        this.count = 0;
        this.top = null;
    }


    /**
     *
     * @param element
     */
    public void push(T element){

        //definir linkednode
        LinkedNode<T> newNode = new LinkedNode<>(element);
        newNode.setElement(element);

        //se a stack está vazia
        if(this.top == null){

            this.top = newNode;

            //se a stack não estiver vazia
        } else {

            newNode.setNext(top);
            top = newNode;
        }

        this.count++;
    }

    /**
     *
     * @return
     * @throws NullException
     */
    public T pop() throws NullException{

        if(isEmpty()){

            throw new NullException("Não existem elementos na structures.sortingAndSearching.linkedlist");
        }

        T result = top.getElement();
        top = top.getNext();
        count--;

        return result;
    }


    /**
     *
     * @return
     * @throws NullException
     */
    public T peek() throws NullException{

        if(isEmpty()){

            throw new NullException("Stack");
        }

        LinkedNode<T> temp = this.top;

        return temp.getElement();
    }

    public boolean isEmpty(){

        return count == 0;
    }

    public int size(){

        return count;
    }

    @Override
    public String toString() {

        LinkedNode<T> current = top;
        String linkedStack = "\n";

        while (current != null){

            linkedStack += current.getElement().toString() + "\n";
            current = current.getNext();
        }

        return linkedStack;
    }
}
