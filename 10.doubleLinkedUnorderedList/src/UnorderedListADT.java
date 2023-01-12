import exceptions.EmptyCollectionException;

public interface UnorderedListADT<T> extends ListADT<T> {

    /** adicionam o elemento na lista no local apropriado
     * @param element o elemento que vai ser adicionado na lista.
     */
    public void addToFront(T element);
    public void addToRear(T element);
    public void addAfter(T element, T target) throws EmptyCollectionException;
}
