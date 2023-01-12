public class Main {
    public static void main(String[] args)
    {
        LinkedList<Car> list = new LinkedList<Car>();
        String key = "audi";
        Integer keyInt = 2001;

        list.add(new Car("2001", "opel", "500", "light grey"));
        list.add(new Car("2015", "ford", "7000", "dark grey"));
        list.add(new Car("2014", "volvo", "15300", "white/black"));
        list.add(new Car("2021", "ford", "25500", "blue"));

        System.out.println("list: ");
        System.out.println(list.toString());

        boolean resultSearch = LinkedListSortingAndSearching.linearSearch(list.head, key);

        if(resultSearch == false){
            System.out.println("sorry, element not found");

        } else {

            System.out.println("the element is present at index: "+resultSearch);
        }

        boolean resultSorting = LinkedListSortingAndSearching.binarySearch(list.head, 0, list.count, keyInt);

        if(resultSorting == false){
            System.out.println("sorry, element not found");

        } else {

            System.out.println("the element is present at index: "+resultSearch);
        }
    }
}