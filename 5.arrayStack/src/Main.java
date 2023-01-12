import exceptions.EmptyCollectionException;

public class Main {
    public static void main(String[] args) throws EmptyCollectionException {
        ArrayStack<String> playlist = new ArrayStack<String>();

        System.out.println("playlist vazia: " + playlist.isEmpty() + "\n");

        //adicionar
        playlist.push("heroes tonight - janji, johnning");
        playlist.push("pompeii zyzz - cuasarz");
        playlist.push("part of me hardstyle - sick cvnt");
        playlist.push("diamonds hardstyle - sick cvnt");
        playlist.push("sweater weather - remzcore");
        playlist.push("star walkin' - lil nas x");

        System.out.println("playlist: " + playlist.toString() + "\n");

        //retornar a referencia do elemento top
        //retornar música a ser reproduzida
        System.out.println("música a tocar: "+playlist.peek().toString()  + "\n");

        //remover o elemento top e retorna a referencia do mesmo
        //remover a musica a ser reproduzida
        System.out.println("música que acabou de tocar: "+playlist.pop().toString()  + "\n");

        System.out.println("playlist: " + playlist.toString() + "\n");

        //retornar a referencia do elemento top
        //retornar música a ser reproduzida
        System.out.println("música a tocar: "+playlist.peek().toString()  + "\n");

        //remover o elemento top e retorna a referencia do mesmo
        //remover a musica a ser reproduzida
        System.out.println("música que acabou de tocar: "+playlist.pop().toString() + "\n");

        System.out.println("playlist: " + playlist.toString() + "\n");

        System.out.println("playlist vazia: " + playlist.isEmpty() + "\n");
    }
}