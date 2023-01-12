import exceptions.EmptyCollectionException;

import java.util.Iterator;

public interface ListADT<T> extends Iterable<T> {

    /** remove e retorna o primeiro elemento da lista
     * @return o primeiro elemento da lista
     * @throws EmptyCollectionException
     */
    public T removeFirst() throws EmptyCollectionException;


    /** remove e retorna o último elemento da lista
     * @return o último elemento da lista
     * @throws EmptyCollectionException
     */
    public T removeLast() throws EmptyCollectionException;


    /** remove e retorna o específico elemento da lista.
     * @param element o elemento que vai ser removido da lista
     * @return
     * @throws EmptyCollectionException
     */
    public T remove(T element) throws EmptyCollectionException;


    /** retorna uma referência do primeiro elemento da lista.
     * @return uma referência do primeiro elemento da lista
     * @throws EmptyCollectionException
     */
    public T first() throws EmptyCollectionException;


    /** retorna uma referência do último elemento da lista.
     * @return uma referência do último elementi da lista
     * @throws EmptyCollectionException
     */
    public T last() throws EmptyCollectionException;

    /** retorna true se a lista conter o elemento específico
     * @param target é o elemento está sendo procurado na lista
     * @return true se na lista conter o elemento
     */
    public boolean contains(T target);


    /** retorna true se a lista não conter elementos.
     * @return true se a lista não conter elementos
     */
    public boolean isEmpty();


    /** retorna o número de elementos da lista.
     * @return o número de elementos da lista
     */
    public int size();


    /** retorna um iterador para os elementos da lista.
     * @return um iterador sobre os elementos da lista
     */
    public Iterator<T> iterator();


    /** retorna uma string da lista.
     * @return uma string da lista
     */
    @Override
    public String toString();
}
