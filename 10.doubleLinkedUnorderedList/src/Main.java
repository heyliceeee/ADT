import exceptions.EmptyCollectionException;

public class Main {
    public static void main(String[] args) throws EmptyCollectionException {
        DoubleLinkedUnorderedList<String> playlist = new DoubleLinkedUnorderedList<>();

        System.out.println("playlist vazia: " + playlist.isEmpty() + "\n");

        //adicionar
        playlist.addToFront("a");
        playlist.addToFront("b");
        playlist.addToFront("c");
        playlist.addToFront("d");
        playlist.addToFront("e");
        playlist.addToFront("f");
        playlist.addToFront("g");
        playlist.addToFront("h");
        playlist.addToFront("i");
        playlist.addToFront("j");
        playlist.addToFront("k");

        System.out.println("playlist: " + playlist.toString() + "\n");

        //retornar a referencia do elemento top
        //retornar música a ser reproduzida
        System.out.println("first: "+playlist.first().toString()  + "\n");
        System.out.println("last: "+playlist.last().toString()  + "\n");

        //remover o elemento top e retorna a referencia do mesmo
        //remover a musica a ser reproduzida
        System.out.println("remove first: "+playlist.removeFirst().toString()  + "\n");
        System.out.println("remove last: "+playlist.removeLast().toString()  + "\n");

        System.out.println("contains a: "+playlist.contains("c") + "\n");

        System.out.println("remove g: "+playlist.remove("g") + "\n");

        //adicionar
        playlist.addToRear("a");
        playlist.addToRear("b");
        playlist.addToRear("c");
        playlist.addToRear("d");
        playlist.addToRear("e");
        playlist.addToRear("f");
        playlist.addToRear("g");
        playlist.addToRear("h");
        playlist.addToRear("i");
        playlist.addToRear("j");
        playlist.addToRear("k");
        playlist.addToRear("l");

        System.out.println("playlist: " + playlist.toString() + "\n");

        //retornar a referencia do elemento top
        //retornar música a ser reproduzida
        System.out.println("first: "+playlist.first().toString()  + "\n");
        System.out.println("last: "+playlist.last().toString()  + "\n");

        //remover o elemento top e retorna a referencia do mesmo
        //remover a musica a ser reproduzida
        System.out.println("remove first: "+playlist.removeFirst().toString()  + "\n");
        System.out.println("remove last (new last): "+playlist.removeLast().toString()  + "\n");

        //adicionar
        playlist.addAfter("l", "b");

        System.out.println("playlist: " + playlist.toString() + "\n");

        System.out.println("playlist vazia: " + playlist.isEmpty() + "\n");
    }
}