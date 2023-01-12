public class DoubleNode<T> {

    private DoubleNode<T> next, prev;
    private T element;

    public DoubleNode(){

        next = null;
        prev = null;
        element = null;
    }

    public DoubleNode(T elem){

        next = null;
        element = elem;
        prev = null;
    }

    public DoubleNode<T> getNext() {

        return next;
    }

    public DoubleNode<T> getPrev() {

        return prev;
    }

    public T getElement() {

        return element;
    }

    public void setElement(T element) {

        this.element = element;
    }

    public void setNext(DoubleNode<T> dnode) {

        this.next = dnode;
    }

    public void setPrev(DoubleNode<T> dnode) {

        this.prev = dnode;
    }

    @Override
    public String toString() {

        return "{"+"element="+element+'}';
    }
}
