import exceptions.EmptyCollectionException;

public interface StackADT<T> {

    /** adiciona um elemento ao top da stack.
     * @param element elemento que vai ser adicionado na stack
     */
    public void push(T element);


    /** remove e retorna o elemento do top da stack.
    * @return T element removido do top da stack
    */
    public T pop() throws EmptyCollectionException;


    /** retorna sem remover o elemento do top da stack.
     * @return T element do top da stack
     */
    public T peek() throws EmptyCollectionException;


    /** retorna true se a stack não conter elementos.
     * @return boolean consoante se a stack estiver ou não vazia
     */
    public boolean isEmpty();


    /** retorna o número de elementos da stack.
     * @return int número de elementos da stack
     */
    public int size();


    /** retorna uma representação de string da stack.
     * @return String representação da stack
     */
    @Override
    public String toString();
}
