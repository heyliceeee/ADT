import exceptions.EmptyCollectionException;
import exceptions.NonComparableElementException;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.stream.Stream;

public class ArrayOrderedList<T> implements OrderedListADT<T> {
    /** VARIÁVEIS **/
    private final int DEFAULT_CAPACITY = 100;
    protected T[] arrayList, newArrayList;
    protected int front, rear, count;


    public ArrayOrderedList() {

        this.arrayList = (T[])(new Object[DEFAULT_CAPACITY]);
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }


    /**
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {

        if(isEmpty()){

            throw new EmptyCollectionException("a structures.sortingAndSearching.array list está vazia");
        }

        T result = arrayList[front];
        arrayList[front] = null;

        for(int i=0; i < this.rear; i++){

            this.arrayList[i] = this.arrayList[i + 1];
        }

        this.rear--;
        this.count++;

        return result;
    }


    /**
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T removeLast() throws EmptyCollectionException {

        if(isEmpty()){

            throw new EmptyCollectionException("a structures.sortingAndSearching.array list está vazia");
        }

        this.rear--;

        T result = arrayList[rear];
        arrayList[rear] = null;

        this.count++;

        return result;
    }


    /**
     * @param element o elemento que vai ser removido da lista
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T remove(T element) throws EmptyCollectionException {

        if(isEmpty()){

            throw new EmptyCollectionException("a structures.sortingAndSearching.array list está vazia");
        }

        if(!contains(element)){

            throw new EmptyCollectionException("o elemento não existe");
        }

        int pos = 0;

        for (int i = 0; i < this.rear; i++) {
            if (element.equals(arrayList[i])) {
                pos = i;
            }
        }

        T result = arrayList[pos];
        arrayList[pos] = null;

        for (int j = pos; j < this.rear; j++) {

            this.arrayList[j] = this.arrayList[j+1];
        }

        this.rear--;
        this.count++;

        return result;
    }


    /**
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T first() throws EmptyCollectionException {

        if(isEmpty()){

            throw new EmptyCollectionException("a structures.sortingAndSearching.array list está vazia");
        }

        return arrayList[front];
    }


    /**
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T last() throws EmptyCollectionException {

        if(isEmpty()){

            throw new EmptyCollectionException("a structures.sortingAndSearching.array list está vazia");
        }

        return arrayList[rear - 1];
    }


    /**
     * @param target é o elemento está sendo procurado na lista
     * @return
     */
    @Override
    public boolean contains(T target) {

        boolean found = false;
        int i = 0;

        while (i < this.rear && !found){
            if(target.equals(arrayList[i])){

                found = true;
            }

            i++;
        }

        return found;
    }


    /**
     * @return
     */
    @Override
    public boolean isEmpty() {

        return rear == 0;
    }


    /**
     * @return
     */
    @Override
    public int size() {

        return this.rear;
    }


    /**
     * @return
     */
    @Override
    public Iterator<T> iterator() {

        return new BasicIterator<>();
    }


    /**
     * @param element o elemento que vai ser adicionado á lista
     * @throws NonComparableElementException
     */
    @Override
    public void add(T element) throws NonComparableElementException {

        if (!(element instanceof Comparable))
            throw new NonComparableElementException("O elemento ou classe não é comparável");
        if(size() == arrayList.length) {
            expandCapacity();
        }

        Comparable<T> temp = (Comparable<T>)element;
        int i = 0;

        while(i < rear && temp.compareTo(arrayList[i]) > 0) {
            i++;
        }

        for (int j = this.rear; j > i; j--) {
            arrayList[j] = arrayList[j-1];
        }
        this.arrayList[i] = element;
        rear++;
        count++;
    }


    /** se a arraylist chegou ao limite de capacidade, vai se expandir a capacidade da mesma.
     *
     */
    private void expandCapacity(){

        newArrayList = (T[]) (new Object[DEFAULT_CAPACITY]);

        T[] test = Stream.concat(Arrays.stream(arrayList), Arrays.stream(newArrayList)).toArray(
                size -> (T[]) Array.newInstance(arrayList.getClass().getComponentType(), size));

        arrayList = test;
    }


    /**
     * @param <T>
     */
    public class BasicIterator<T> implements Iterator<T> {
        /** VARIÁVEIS **/
        private final int size;
        private final T[] items;
        private int current, expectedCount;

        public BasicIterator() {

            this.items = (T[]) ArrayOrderedList.this.arrayList;
            this.size = ArrayOrderedList.this.rear;
            this.current = 0;
            this.expectedCount = ArrayOrderedList.this.count;
        }


        @Override
        public boolean hasNext() {

            if(expectedCount != count){

                throw new ConcurrentModificationException("concorrência");
            }

            return (this.items[this.current] != null);
        }


        @Override
        public T next() {

            T temp = items[this.current];

            if(hasNext()){

                this.current++;
            }

            return temp;
        }
    }


    /**
     * @param i
     * @return
     */
    public T get(int i) {

        if(i >= this.rear || i < 0){

            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + i);
        }

        return arrayList[i];
    }


    /**
     * @return
     */
    @Override
    public String toString(){

        String s = "\n";

        for (int i = 0; i < this.rear; i++) {

            s += arrayList[i] + "\n";
        }

        return s;
    }
}
