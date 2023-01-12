import exceptions.NonComparableElementException;

public interface OrderedListADT<T> extends ListADT<T> {

    /** adiciona o elemento na lista no local apropriado
     * @param element o elemento que vai ser adicionado á lista
     */
    public void add(T element) throws NonComparableElementException;
}
