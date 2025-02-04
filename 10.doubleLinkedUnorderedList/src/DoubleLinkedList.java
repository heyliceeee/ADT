import exceptions.EmptyCollectionException;

import java.util.Iterator;

public class DoubleLinkedList<T> implements ListADT<T> {

    protected DoubleNode<T> head, tail;
    protected int count;

    public DoubleLinkedList() {

        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {

        if (isEmpty()){

            throw new EmptyCollectionException("List");
        }

        DoubleNode<T> current = head;

        head = head.getNext();
        head.setPrev(null);

        this.count--;
        return current.getElement();
    }

    @Override
    public T removeLast() throws EmptyCollectionException {

        DoubleNode<T> last = tail;

        if (isEmpty()){

            throw new EmptyCollectionException("List");
        }

        if(tail == null || tail.getNext() == null){

            throw new EmptyCollectionException("double list vazia");
        }

        while (last.getNext().getNext() != null){

            last = last.getNext();
        }

        //last = last.getPrev();
        last.setNext(null);

        this.count--;
        return last.getElement();
    }

    @Override
    public T remove(T element) throws EmptyCollectionException {

        if (isEmpty()){

            throw new EmptyCollectionException("List");
        }

        boolean found = false;
        DoubleNode<T> previous = null;
        DoubleNode<T> current = head;

        while (current != null && !found) {
            if (element.equals (current.getElement())){

                found = true;

            } else {
                previous = current;
                current = current.getNext();
            }

        }
        if (!found){

            throw new EmptyCollectionException("List");
        }

        if (size() == 1) {

            head = tail = null;

        } else if (current.equals (head)) {

            head = current.getNext();

        } else if (current.equals (tail)) {

            tail = previous;
            tail.setNext(null);

        } else {

            previous.setNext(current.getNext());
        }

        count--;

        return current.getElement();
    }

    @Override
    public T first() throws EmptyCollectionException {

        if (isEmpty()){

            throw new EmptyCollectionException("a lista está vazia");
        }

        T result = head.getElement();

        return result;
    }

    @Override
    public T last() throws EmptyCollectionException {

        if (isEmpty()){

            throw new EmptyCollectionException("a lista está vazia");
        }

        DoubleNode<T> last = head;

        while (last.getNext() != null){

            last = last.getNext();
        }

        return last.getElement();
    }

    @Override
    public boolean contains(T target) {
        DoubleNode<T> data = head;
        boolean found = false;
        int i = 0;

        while (i < this.count && !found) {
            if (target.equals(data.getElement())) {

                found = true;

            } else {

                data = data.getNext();
            }
            i++;
        }

        return found;
    }

    @Override
    public boolean isEmpty() {

        return (count == 0);
    }

    @Override
    public int size() {

        return this.count;
    }

    @Override
    public Iterator<T> iterator() {

        return new BasicIterator<T>(this);
    }

    public class BasicIterator<T> implements Iterator<T> {
        private DoubleNode<T> current;

        public BasicIterator(DoubleLinkedList<T> list) {

            current = list.head;
        }

        @Override
        public boolean hasNext() {

            return this.current != null;
        }

        @Override
        public T next() {
            T data = current.getElement();
            current = current.getNext();

            return data;
        }
    }

    @Override
    public String toString() {

        DoubleNode<T> current = this.head;

        String s = "\n";

        while(current != null) {

            s += current.getElement().toString() + "\n";
            current = current.getNext();
        }

        return s;
    }
}
