public class Main {
    public static void main(String[] args)
    {
        Car[] car = new Car[4];
        String key = "1526";

        car[0] = new Car("2001", "opel", "500", "light grey");
        car[1] = new Car("2015", "ford", "7000", "dark grey");
        car[2] = new Car("2014", "volvo", "15300", "white/black");
        car[3] = new Car("2021", "ford", "25500", "blue");


        for(int i=0; i < car.length; i++){

            System.out.println(car[i]);
        }


        boolean resultSearch = ArraySortingAndSearching.linearSearch(car, key);

        if(resultSearch == false){
            System.out.println("sorry, element not found");

        } else {

            System.out.println("the element is present at index: "+resultSearch);
        }

        boolean resultSorting = ArraySortingAndSearching.binarySearch(car, 0, car.length - 1, key);

        if(resultSorting == false){
            System.out.println("sorry, element not found");

        } else {

            System.out.println("the element is present at index: "+resultSearch);
        }
    }
}