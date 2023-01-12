import exceptions.NullException;

import java.util.Objects;

public class LinkedList<T> {

    int count;
    LinkedNode<T> head, tail;

    public LinkedList(){

        this.count = 0;
        this.head = null;
        this.tail = null;
    }

    /** adicionar um novo elemento na head da lista
     * @param element
     */
    public void add(T element){

        //definir LinkedNode
        LinkedNode<T> newNode = new LinkedNode<T>(element);
        newNode.setElement(element);

        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            newNode.setNext(head);
            head = newNode;
        }
        this.count++;
    }


    /** remover o node que contém o elemento existente na lista
     * @param element
     * @throws NullException
     */
    public void remove(T element) throws NullException {

        //armazenar início da structures.sortingAndSearching.linkedlist
        LinkedNode<T> temp = this.head;
        //node anterior fica com valor null
        LinkedNode<T> prev = null;

        if(this.count == 0){

            throw new NullException("Não existem elementos na structures.sortingAndSearching.linkedlist");
        }

        if(temp != null && temp.getElement() == element){

            head = temp.getNext();
        }

        //procurar o elemento e guarda o node anterior
        while (temp != null && temp.getElement() != element){

            prev = temp;
            temp = temp.getNext();
        }

        //se só existir um elemento
        if(this.head == this.tail){

            this.head = null;
            this.tail = null;
        }

        //se o node anterior é o head
        if(prev == null){

            this.head = temp.getNext();

        } else {
            //se o node anterior é o tail ou se está no meio
            prev.setNext(temp.getNext());

            if(prev.getNext() == null){

                tail = prev;
            }
        }

        this.count--;
    }


    /** retorna a lista
     * @return
     */
    @Override
    public String toString() {

        LinkedNode<T> current = head;
        String list = "\n";

        while(current != null) {

            list += current.getElement().toString() + "\n";
            current = current.getNext();
        }
        return list;
    }


    /** retorna true ou false, dependendo se os elementos são iguais
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LinkedList<?> other = (LinkedList<?>) obj;
        if (this.count != other.count) {
            return false;
        }
        if (!Objects.equals(this.head, other.head)) {
            return false;
        }
        if (!Objects.equals(this.tail, other.tail)) {
            return false;
        }
        return true;
    }
}
