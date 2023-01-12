public class ArraySortingAndSearching<T> {

    //PESQUISA

    /** procura num structures.sortingAndSearching.array usando uma pesquisa linear
     * @param data structures.sortingAndSearching.array a ser ordenado
     * @param target elemento a ser procurado
     * @return true se o elemento for encontrado
     * @param <T>
     */
    public static <T extends Comparable<? super T>> boolean linearSearch (Car[] data, T target){

        int i = 0;
        boolean found = false;

        while (!found && i < data.length){

            T year = (T) data[i].getYear();
            T brand = (T) data[i].getBrand();
            T price = (T) data[i].getPrice();
            T color = (T) data[i].getColor();

            if(year.compareTo(target) == 0 || brand.compareTo(target) == 0 || price.compareTo(target) == 0 || color.compareTo(target) == 0){

                found = true;
            }

            i++;
        }

        //se n foi encontrado
        return found;
    }


    /** pesquisa num structures.sortingAndSearching.array usando uma pesquisa binária
     * @param data
     * @param min
     * @param max
     * @param target
     * @return
     * @param <T>
     */
    public static <T extends Comparable<? super T>> boolean binarySearch (Car[] data, int min, int max, T target){

        boolean found = false;

        if(min > max){

            return found;

        } else {

            int midpoint = (min + max) / 2; //determinar o midpoint

            T year = (T) data[midpoint].getYear();
            T brand = (T) data[midpoint].getBrand();
            T price = (T) data[midpoint].getPrice();
            T color = (T) data[midpoint].getColor();

            if(year.compareTo(target) == 0 || brand.compareTo(target) == 0 || price.compareTo(target) == 0 || color.compareTo(target) == 0) {

                found = true;

            } else if (year.compareTo(target) > 0 || brand.compareTo(target) > 0 || price.compareTo(target) > 0 || color.compareTo(target) > 0){

                return binarySearch(data, midpoint + 1, max, target);

            } else {

                return binarySearch(data, midpoint - 1, min, target);
            }
        }

        return found;
    }


    //ORDENAÇÃO

    /** ordena um array usando a selection sort
     * @param data
     * @param <T> dados do array a ser ordenado
     */
    public static <T extends Comparable<? super T>> void selectionSort(Car[] data){

        int min, n = data.length;
        Car temp;
        T yearMin, yearScan;

        for(int i=0; i < n-1; i++){

            min = i;

            yearMin = (T) data[min].getYear();

            for(int scan=i+1; scan < n; scan++){

                yearScan = (T) data[scan].getYear();

                if(yearScan.compareTo(yearMin) < 0){

                    min = scan;
                }
            }

            //trocar os valores
            temp = data[min];
            data[min] = data[i];
            data[i] = temp;
        }
    }


    /** ordena um array usando a insertion sort
     * @param data
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void insertionSort(Car[] data){

        int n=data.length, j;
        T yearPos, yearMin;
        Car temp;

        for(int i=1; i < n; i++){
            //shift valores grandes para a direita
            for(j=i; j > 0; j--){

                yearPos = (T) data[j].getYear();
                yearMin = (T) data[j-1].getYear();

                if(yearPos.compareTo(yearMin) < 0){

                    temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                }
            }
        }
    }


    /** ordena um array usando a bubble sort
     * @param data
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void bubbleSort(Car[] data){

        int n=data.length, pos, scan;
        Car temp;
        T yearScan, yearNext;

        for(pos=n-1; pos >= 0; pos--){
            for(scan=0; scan <= pos-1; scan++){

                yearScan = (T) data[scan].getYear();
                yearNext = (T) data[scan+1].getYear();

                if(yearScan.compareTo(yearNext) > 0){

                    //trocar de valores
                    temp = data[scan];
                    data[scan] = data[scan+1];
                    data[scan+1] = temp;
                }
            }
        }
    }


    /** ordena um array usando o quick sort
     * @param data o array a ser ordenado
     * @param min valor min
     * @param max valor max
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void quickSort(Car[] data, int min, int max){

        int indexOfPartition;

        if(min < max){

            //criar partições
            indexOfPartition = findPartition(data, min, max);

            //ordenar o lado esquerdo
            quickSort(data, min, indexOfPartition-1);

            //ordenar o lado direito
            quickSort(data, indexOfPartition+1, max);
        }
    }

    /** usado no quick sort para encontrar a partição
     * @param data array a ser ordenado
     * @param min min valor
     * @param max max valor
     * @return
     * @param <T>
     */
    private static <T extends Comparable<? super T>> int findPartition(Car[] data, int min, int max){

        Car pivot = data[max];
        int i=(min-1), j;
        int yearMin, yearPivot;

        for(j=min; j <= max-1; j++){

            yearMin = Integer.parseInt(data[j].getYear());
            yearPivot = Integer.parseInt(pivot.getYear());

            //se o elemento atual é menor que o pivot
            if(yearMin < yearPivot){

                //incrementa o index do elemento menor
                i++;
                swap(data, i, j);
            }
        }

        swap(data, i+1, max);
        return (i+1);
    }

    /** swap 2 elementos
     * @param data
     * @param i
     * @param j
     */
    static void swap(Car[] data, int i, int j){

        Car temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }


    /** ordena um array usando a merge sort
     * @param data array a ser ordenado
     * @param min min valor
     * @param max max valor
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void merge(Car[] data, int min, int mid, int max){

        int i, j, k, n1 = mid - min + 1, n2 = max - mid;
        Car[] leftArray = new Car[n1], rightArray = new Car[n2];
        int yearLeft, yearRight;

        //copy dados para temp arrays
        for(i=0; i < n1; i++){

            leftArray[i] = data[min+i];
        }

        for(j=0; j < n2; j++){

            rightArray[j] = data[mid+1+j];
        }

        i=0;
        j=0;
        k = min;

        while (i < n1 && j < n2){

            yearLeft = Integer.parseInt(leftArray[i].getYear());
            yearRight = Integer.parseInt(rightArray[j].getYear());

            if(yearLeft <= yearRight){

                data[k] = leftArray[i];
                i++;

            } else {

                data[k] = rightArray[j];
                j++;
            }

            k++;
        }

        while (i < n1){

            data[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2){

            data[k] = rightArray[j];
            j++;
            k++;
        }
    }

    static void mergeSort(Car[] data, int min, int max){

        if(min < max){

            int mid = (min + max)/2;

            mergeSort(data, min, mid);
            mergeSort(data, mid+1, max);
            merge(data, min, mid, max);
        }
    }
}
