public class Ass1_InsertionSort {

    public static void printArr(int arr[]) {
        System.out.println();
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void insertionSort(int arr[]) {
        // in order to sort the element using the insertion
        // take the element check with neighout till start and if its bigger shigt by
        // one and put there
        // if not then move forward
        // we assume that first elemetn is already sorted
        // then we start from the 1

        // step 1 start the loop and get access to
        // first is already sorted then dont do anything for the

        for (int i = 1; i < arr.length; i++) {

            // here then we start
            int current = arr[i]; // element to check
            int position = i - 1;

            // this will stop either position become -1 or the curr become greater then arr
            // elemet position
            while (position >= 0 && current < arr[position]) {
                arr[position + 1] = arr[position];
                position--;
            }
            // hey after the length put the current at the position where it belongs
            arr[position + 1] = current;

        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 5, 3, 0 };

        printArr(arr);
        insertionSort(arr);
        printArr(arr);
    }

}
