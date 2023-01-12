import exceptions.EmptyCollectionException;

public class Main {
    public static void main(String[] args) throws EmptyCollectionException {
        CircularArrayQueue<String> queue = new CircularArrayQueue<>();

        //adiciona elemento na cauda
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");

        System.out.println(queue.toString());

        //retorna o 1º elemento
        System.out.println("first: "+queue.first());

        //remove o elemento da cabeça
        queue.dequeue();

        System.out.println("queue depois de remover: ");
        System.out.println(queue.toString());

        //retorna o 1º elemento
        System.out.println("first: "+queue.first());
    }
}