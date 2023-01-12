
public class LinkedListSortingAndSearching<T> {

    static LinkedNode<Car> sortedHead;

    //PESQUISA

    /** procura um elemento especifico na linked list
     * @param head
     * @param target
     * @return
     * @param <T>
     */
    public static <T extends Comparable<? super T>> boolean linearSearch(LinkedNode head, T target){

        LinkedNode<T> current = head;
        boolean found = false;

        while (current != null && ! found){
            if(target.equals(current.getElement())){

                found = true;

            } else {

                current = current.getNext();
            }
        }

        return found;
    }


    /** insere um node no inicio da linked list
     * @param head
     * @param value
     * @return
     */
    public static LinkedNode<Integer> binarySearch(LinkedNode<Integer> head, int value) {
        LinkedNode<Integer> start = head;
        LinkedNode<Integer> last = null;

        do {
            // Find Middle
            LinkedNode<Integer> mid = getMiddleNode(start, last);

            // If middle is empty
            if (mid == null)
                return null;

            // If value is present at middle
            if (mid.getElement() == value)
                return mid;

                // If value is less than mid
            else if (mid.getElement() > value)
            {
                start = mid.getNext();
            }

            // If the value is more than mid.
            else
                last = mid;
        } while (last == null || last != start);

        // value not present
        return null;
    }


    /** encontrar o elemento do meio
     * @param head
     * @param tail
     * @return
     */
    public static LinkedNode<Integer> getMiddleNode(LinkedNode<Integer> head, LinkedNode<Integer> tail) {
        if (head == null) {
            return null;
        }

        LinkedNode<Integer> slow = head;
        LinkedNode<Integer> fast = head.getNext();

        while (fast != tail) {
            fast = fast.getNext();
            if (fast != tail) {
                slow = slow.getNext();
                fast = fast.getNext();
            }
        }
        return slow;
    }


    //ORDENAÇÃO

    /** SELECTION SORT
     *
     */
    static LinkedNode<Car> selectionSort(LinkedNode<Car> head){

        LinkedNode<Car> a, b, c, d, max;

        a = b = head;

        // While b is not the last node
        while (b.getNext() != null){

            c = d = b.getNext();

            //While d is pointing to a valid node
            while (d != null){

                int yearB = Integer.parseInt(b.getElement().getYear());
                int yearD = Integer.parseInt(d.getElement().getYear());

                if(yearB > yearD){
                    // If d appears immediately after b
                    int yearBNext = Integer.parseInt(b.getNext().getElement().getYear());

                    if (yearBNext == yearD) {
                        // Case 1: b is the head of the linked list
                        yearB = Integer.parseInt(b.getElement().getYear());
                        int yearHead = Integer.parseInt(head.getElement().getYear());

                        if (yearB == yearHead) {

                            // Move d before b
                            b.setNext(d.getNext());
                            d.setNext(b);

                            // Swap b and d pointers
                            max = b;
                            b = d;
                            d = max;

                            c = d;

                            // Update the head
                            head = b;

                            // Skip to the next element
                            // as it is already in order
                            d = d.getNext();

                            // Case 2: b is not the head of the linked list
                        } else {

                            // Move d before b
                            b.setNext(d.getNext());
                            d.setNext(b);
                            a.setNext(d);

                            // Swap b and d pointers
                            max = b;
                            b = d;
                            d = max;

                            c = d;

                            // Skip to the next element
                            // as it is already in order
                            d = d.getNext();
                        }

                        // If b and d have some non-zero
                        // number of nodes in between them
                    } else {

                        // Case 3: b is the head of the linked list
                        if (b == head) {

                            // Swap b.next and d.next
                            max = b.getNext();
                            b.setNext(d.getNext());
                            d.setNext(max);
                            c.setNext(b);

                            // Swap b and d pointers
                            max = b;
                            b = d;
                            d = max;

                            c = d;

                            // Skip to the next element
                            // as it is already in order
                            d = d.getNext();

                            // Update the head
                            head = b;

                        }
                        // Case 4: b is not the head of the linked list
                        else {

                            // Swap b.next and d.next
                            max = b.getNext();
                            b.setNext(d.getNext());
                            d.setNext(max);
                            c.setNext(b);
                            a.setNext(d);

                            // Swap b and d pointers
                            max = b;
                            b = d;
                            d = max;

                            c = d;

                            // Skip to the next element
                            // as it is already in order
                            d = d.getNext();
                        }
                    }

                } else {

                    // Update c and skip to the next element
                    // as it is already in order
                    c = d;
                    d = d.getNext();
                }
            }

            a = b;
            b = b.getNext();
        }

        return head;
    }


    /** INSERTION SORT
     */
    static LinkedNode<Car> insertionSort(LinkedNode<Car> head){

        sortedHead = null;
        LinkedNode<Car> currentNode = head;

        while (currentNode != null){

            LinkedNode<Car> nextNode = currentNode.getNext();
            insertNode(currentNode);
            currentNode = nextNode;
        }

        return sortedHead;
    }

    static void insertNode(LinkedNode<Car> head){

        if(sortedHead == null || Integer.parseInt(sortedHead.getElement().getYear()) >= Integer.parseInt(head.getElement().getYear())){

            head.setNext(sortedHead);
            sortedHead = head;

            return;
        }

        LinkedNode<Car> currentNode = sortedHead;

        while (currentNode.getNext() != null && Integer.parseInt(currentNode.getNext().getElement().getYear()) < Integer.parseInt(head.getElement().getYear())) {

            currentNode = currentNode.getNext();
        }

        head.setNext(currentNode.getNext());
        currentNode.setNext(head);

        return;
    }


    /** BUBBLE SORT
     */
    public static void bubbleSort(LinkedNode<Car> head){

        if (head != null) {
            LinkedNode<Car> current=null, new_head=null, move_node=null;

            while (head != null) {

                current = head;
                move_node = head;

                while (current != null) {
                    //When current node value is grator than previous node
                    String currentNext = String.valueOf(current.getNext());
                    int currentNextElem = Integer.parseInt(current.getNext().getElement().getYear());
                    int move_nodeElem = Integer.parseInt(move_node.getElement().getYear());

                    if (currentNext != null && currentNextElem > move_nodeElem) {
                        //Swap node values
                        move_node = current.getNext();
                    }
                    current = current.getNext();
                }

                int move_nodeElem = Integer.parseInt(move_node.getElement().getYear());
                int headElem = Integer.parseInt(head.getElement().getYear());

                if (move_nodeElem == headElem) {
                    head = (head).getNext();
                }

                move_node.setNext(new_head);
                new_head = move_node;
            }
            //make new head
            head = new_head;
        } else {
            System.out.println("Empty Linked list");
        }
    }


    /** QUICK SORT
     * @param start
     * @param end
     * @return
     */
    private static LinkedNode<Car> partitionLast(LinkedNode<Car> start, LinkedNode<Car> end){

        if(start == end || start == null || end == null){

            return start;
        }

        LinkedNode<Car> pivot_prev = start;
        LinkedNode<Car> curr = start;
        Car pivot = end.getElement();

        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end) {

            String yearStart = start.getElement().getYear();
            String pivotStart = pivot.getYear();

            if (yearStart.compareTo(pivotStart) < 0) {
                // keep tracks of last modified item
                pivot_prev = curr;
                Car temp = curr.getElement();
                curr.setElement(start.getElement());
                start.setElement(temp);
                curr = curr.getNext();
            }

            start = start.getNext();
        }

        // swap the position of curr i.e.
        // next suitable index and pivot
        Car temp = curr.getElement();
        curr.setElement(pivot);
        end.setElement(temp);

        // return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }

    public static <T extends Comparable<? super T>> void quickSort(LinkedNode<Car> start, LinkedNode<Car> end){

        if(start == end){

            return;
        }

        // split list and partion recurse
        LinkedNode<Car> prev = partitionLast(start, end);
        quickSort(start, prev);

        // if pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if(prev != null && prev == start){

            quickSort(prev.getNext(), end);

            // if pivot is in between of the list,
            // start from next of pivot,
            // since we have pivot_prev, so we move two nodes
        } else if(prev != null && prev.getElement() != null) {

            quickSort(prev.getNext().getNext(), end);
        }
    }


    /** MERGE SORT
     *
     */
    public static <T extends Comparable<? super T>> LinkedNode<Car> mergeSort(LinkedNode<Car> head){

        // Base case : if head is null
        if (head == null || head.getNext() == null) {
            return head;
        }

        // get the middle of the list
        LinkedNode<Car> middle = getMiddle(head);
        LinkedNode<Car> nextofmiddle = middle.getNext();

        // set the next of middle node to null
        middle.setNext(null);

        // Apply mergeSort on left list
        LinkedNode<Car> left = mergeSort(head);

        // Apply mergeSort on right list
        LinkedNode<Car> right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        LinkedNode<Car> sortedlist = sortedMerge(left, right);

        return sortedlist;
    }

    public static LinkedNode<Car> sortedMerge(LinkedNode<Car> a, LinkedNode<Car> b){

        LinkedNode<Car> result = null;

        /* Base cases */
        if (a == null){

            return b;
        }

        if (b == null){

            return a;
        }

        /* Pick either a or b, and recur */
        int yearA = Integer.parseInt(a.getElement().getYear());
        int yearB = Integer.parseInt(b.getElement().getYear());

        if (yearA <= yearB) {

            result = a;
            result.setNext(sortedMerge(a.getNext(), b));

        } else {

            result = b;
            result.setNext(sortedMerge(a, b.getNext()));
        }

        return result;
    }

    public static LinkedNode<Car> getMiddle(LinkedNode<Car> head){

        // Base case
        if (head == null){

            return head;
        }

        LinkedNode<Car> fastptr = head.getNext();
        LinkedNode<Car> slowptr = head;

        // Move fastptr by two and slow ptr by one
        // Finally slowptr will point to middle node
        while (fastptr != null) {

            fastptr = fastptr.getNext();

            if (fastptr != null) {

                slowptr = slowptr.getNext();
                fastptr = fastptr.getNext();
            }
        }

        return slowptr;
    }
}
