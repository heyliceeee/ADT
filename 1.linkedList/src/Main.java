
public class Main {
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<String>();

        list.add("a");
        list.add("c");
        list.add("b");

        System.out.println("list: ");
        System.out.println(list.toString());

        try {

            list.remove("b");
            System.out.println("lista depois de remover: ");
            System.out.println(list.toString());

        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
}