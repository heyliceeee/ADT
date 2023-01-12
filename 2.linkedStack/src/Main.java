import exceptions.NullException;

public class Main {
    public static void main(String[] args) throws NullException {
        LinkedStack<String> list = new LinkedStack<String>();

        list.push("a");
        list.push("b");

        System.out.println(list.toString());

        //retorna elemento do topo
        System.out.println("peek: "+list.peek());

        //remover o elemento do topo
        list.pop();

        System.out.println("lista depois de remover: ");
        System.out.println(list.toString());

        //retorna elemento do topo
        System.out.println("peek: "+list.peek());
    }
}