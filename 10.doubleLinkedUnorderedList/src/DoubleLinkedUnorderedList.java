import exceptions.EmptyCollectionException;

public class DoubleLinkedUnorderedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {

    public DoubleLinkedUnorderedList(){
        super();
    }

    @Override
    public void addToFront(T element) {

        DoubleNode<T> newNode = new DoubleNode<T>(element);
        newNode.setElement(element);

        //if (head == null) {

            newNode.setNext(head);
            newNode.setPrev(null);

            //head = newNode;
            //tail = newNode;
        //}

        if(head != null){
            head.setPrev(newNode);
        }

        //newNode.setNext(head);

        //head.setPrev(newNode);
        head = newNode;
        tail = newNode;

        count++;
    }

    @Override
    public void addToRear(T element) {

        DoubleNode<T> newNode = new DoubleNode<T>(element);
        newNode.setElement(element);

        DoubleNode<T> last = head;

        newNode.setNext(null);

        if (head == null){
            newNode.setPrev(null);

            head = newNode;
            tail = newNode;

            return;
        }

        while (last.getNext() != null){

            last = last.getNext();
        }

        last.setNext(newNode);

        newNode.setPrev(last);

        count++;
    }

    @Override
    public void addAfter(T element, T target) throws EmptyCollectionException {

        DoubleNode<T> newnode = new DoubleNode<T>(element);
        newnode.setElement(element);

        boolean found = false;

        // 1º caso - A lista está vazia
        if (isEmpty()) {
            head = newnode;
            tail = newnode;
        }
        else {
            DoubleNode<T> current = head;
            while (current != null && !found) {
                if (target.equals(current.getElement())) {
                    found = true;
                }
                else {
                    current = current.getNext();
                }
            }

            if(current.getNext() == null) {
                current.setNext(newnode);
                newnode.setPrev(current);
                tail = newnode;
            }
            else {
                DoubleNode<T> next = current.getNext();
                current.setNext(newnode);
                newnode.setPrev(current);
                newnode.setNext(next);
                next.setPrev(newnode);
            }
        }
        count++;
    }
}
