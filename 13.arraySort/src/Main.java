public class Main {
    public static void main(String[] args)
    {
        Car[] car = new Car[6];
        String key = "1526";

        car[0] = new Car("11", "opel", "500", "light grey");
        car[1] = new Car("30", "ford", "7000", "dark grey");
        car[2] = new Car("24", "volvo", "15300", "white/black");
        car[3] = new Car("7", "ford", "25500", "blue");
        car[4] = new Car("31", "", "", "");
        car[5] = new Car("16", "", "", "");


        for(int i=0; i < car.length; i++){

            System.out.println(car[i]);
        }


        System.out.println("SELECTION SORT");
        ArraySortingAndSearching.selectionSort(car); //ordena por ano
        for(int i=0; i < car.length; i++){

            System.out.println(car[i]);
        }

        System.out.println("INSERTION SORT");
        ArraySortingAndSearching.insertionSort(car); //ordena por ano
        for(int i=0; i < car.length; i++){

            System.out.println(car[i]);
        }

        System.out.println("BUBBLE SORT");
        ArraySortingAndSearching.bubbleSort(car); //ordena por ano
        for(int i=0; i < car.length; i++){

            System.out.println(car[i]);
        }

        System.out.println("QUICK SORT");
        ArraySortingAndSearching.quickSort(car, 0, car.length - 1); //ordena por ano
        for(int i=0; i < car.length; i++){

            System.out.println(car[i]);
        }

        System.out.println("MERGE SORT");
        ArraySortingAndSearching.mergeSort(car, 0, car.length - 1); //ordena por ano
        for(int i=0; i < car.length; i++){

            System.out.println(car[i]);
        }
    }
}