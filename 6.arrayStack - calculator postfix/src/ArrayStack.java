import exceptions.EmptyCollectionException;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.stream.Stream;

public class ArrayStack<T> implements StackADT<T> {

    private T[] newArray; //novo structures.sortingAndSearching.array de elementos genéricos que representam a stack, com o dobro da capacidade

    private final int DEFAULT_CAPACITY = 10; //constante para representar a capacidade default do structures.sortingAndSearching.array

    public int top; //int que representa o número de elementos e a seguinte posição disponível do structures.sortingAndSearching.array

    private T[] stack; //structures.sortingAndSearching.array de elementos genéricos que representam a stack


    /** criar uma stack vazia usando a capacidade default
     *
     */
    public ArrayStack(){

        top = 0;
        stack = (T[]) (new Object[DEFAULT_CAPACITY]);
    }


    /** criar uma stack vazia usando uma capacidade específica.
     * @param initialCapacity representa a capacidade específica
     */
    public ArrayStack(int initialCapacity){

        top = 0;
        stack = (T[]) (new Object[initialCapacity]);
    }


    /** adiciona um elemento específico ao top da stack, expandindo a capacidade do stack, se necessário.
     * @param element elemento genérico que é adicionado para a stack
     */
    @Override
    public void push(T element){

        if(size() == stack.length){
            expandCapacity();
        }

        stack[top] = element;

        top++;
    }


    /** remove o elemento do top da stack e retorna a referência a ele.
     * throws (lança) um EmptyStackException se a stack estiver vazia.
     * @return T element removido do top da stack
     * @throws EmptyStackException se a stack estiver vazia
     */
    @Override
    public T pop() throws EmptyCollectionException {

        if(isEmpty()){

            throw new EmptyCollectionException("Stack");
        }

        top--;

        T result = stack[top];

        stack[top] = null;

        return result;
    }


    /** retorna a referência do elemento do top da stack.
     * o elemento não é removido da stack.
     * throws (lança) um EmptyStackException se a stack estiver vazia.
     * @return T element do top da stack
     * @throws EmptyStackException se a stack estiver vazia
     */
    @Override
    public T peek() throws EmptyCollectionException {

        if(isEmpty()){

            throw new EmptyCollectionException("Stack");
        }

        return stack[top-1];
    }


    /** retorna true se a stack estiver vazia e false caso contrário.
     * @return boolean
     */
    @Override
    public boolean isEmpty() {

        //verificar se existe algum elemento no top
        if(this.top == 0){

            return true;
        }

        return false;
    }


    /** retorna a quantidade de elementos que existe na stack.
     * @return int contador de elementos da stack
     */
    @Override
    public int size() {

        return top+1;
    }


    /** retorna em String os elementos da stack.
    * @return String os elementos da stack
    */
    @Override
    public String toString(){

        String arrayStack = "\n";

        for(int i=0; i < top; i++){

            arrayStack += stack[i] + "\n";
        }

        return arrayStack;
    }


    /** se a stack chegou ao limite de capacidade, vai se expandir a capacidade da mesma.
     *
     */
    private void expandCapacity() {

        newArray = (T[]) (new Object[DEFAULT_CAPACITY]);

        T[] test = Stream.concat(Arrays.stream(stack), Arrays.stream(newArray)).toArray(
                size -> (T[]) Array.newInstance(stack.getClass().getComponentType(), size));

        stack = test;
    }
}
