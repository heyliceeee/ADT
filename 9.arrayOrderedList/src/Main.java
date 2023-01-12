import exceptions.EmptyCollectionException;
import exceptions.NonComparableElementException;

public class Main {
    public static void main(String[] args) throws NonComparableElementException, EmptyCollectionException {
        ArrayOrderedList<String> playlist = new ArrayOrderedList<String>();

        System.out.println("playlist vazia: " + playlist.isEmpty() + "\n");

        //adicionar
        playlist.add("a");
        playlist.add("b");
        playlist.add("c");
        playlist.add("d");
        playlist.add("e");
        playlist.add("f");
        playlist.add("g");
        playlist.add("h");
        playlist.add("i");
        playlist.add("j");
        playlist.add("k");

        System.out.println("playlist: " + playlist.toString() + "\n");

        //retornar a referencia do elemento top
        //retornar música a ser reproduzida
        System.out.println("first: "+playlist.first().toString()  + "\n");
        System.out.println("last: "+playlist.last().toString()  + "\n");

        //remover o elemento top e retorna a referencia do mesmo
        //remover a musica a ser reproduzida
        System.out.println("remove first: "+playlist.removeFirst().toString()  + "\n");
        System.out.println("remove last: "+playlist.removeLast().toString()  + "\n");

        System.out.println("contains b: "+playlist.contains("b") + "\n");

        System.out.println("remove g: "+playlist.remove("g") + "\n");

        //adicionar
        playlist.add("a");
        playlist.add("b");
        playlist.add("c");
        playlist.add("d");
        playlist.add("e");
        playlist.add("f");
        playlist.add("g");
        playlist.add("h");
        playlist.add("i");
        playlist.add("j");
        playlist.add("k");

        System.out.println("playlist: " + playlist.toString() + "\n");

        //retornar a referencia do elemento top
        //retornar música a ser reproduzida
        System.out.println("first: "+playlist.first().toString()  + "\n");
        System.out.println("last: "+playlist.last().toString()  + "\n");

        //remover o elemento top e retorna a referencia do mesmo
        //remover a musica a ser reproduzida
        System.out.println("remove first: "+playlist.removeFirst().toString()  + "\n");
        System.out.println("remove last: "+playlist.removeLast().toString()  + "\n");

        //adicionar
        playlist.add("a");
        playlist.add("b");
        playlist.add("c");
        playlist.add("d");
        playlist.add("e");
        playlist.add("f");
        playlist.add("g");
        playlist.add("h");
        playlist.add("i");
        playlist.add("j");
        playlist.add("k");

        System.out.println("playlist: " + playlist.toString() + "\n");

        System.out.println("playlist vazia: " + playlist.isEmpty() + "\n");
    }
}