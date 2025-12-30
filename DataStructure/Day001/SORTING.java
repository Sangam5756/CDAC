/*
 * Bubble Sort
 * ------------------
 * Statement : You are given a list of integers. Your task is to sort the list
 * in ascending order using
 * the Bubble Sort algorithm
 * --------------------------------
 * 
 * Example 1:
 * 
 * Input: 5 2 9 1 5
 * Output : 1 2 5 5 9
 * 
 * -------------------
 * Example 2 :
 * Input : 10 3 8 4 2 7
 * Output : 2 3 4 7 8 10
 * 
 * Note : Stop early if the array is already sorted ( no elements are swapped)
 * 
 */

public class SORTING {

    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    public static void selectionSort(int []arr){


        for(int i=0; i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i]= arr[j];
                    arr[j]= temp;
                }
            }
        }

    }


    
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
    }

    public static void insertionSort(int arr[]){

        
        for(int i =1; i<arr.length; i++){
            // see the curr to comapre arr[i]
            int curr = arr[i];
            // pos of previous element
            int prevPos = i - 1;
            // now check that if arr[pos] > curr; means arr[0] > ar[1] if yes
            // move forward and just put arr[0] to arr[1] and then do position decrement
            // now also one more need to check post should be >0  if it becomes the -1 then stop
            // or no greater element on left so tat time 
            // wheereever the pos is just after that put curr
            // arr[pos+1] =curr

            while( prevPos >= 0 && arr[prevPos] > curr ){
                arr[prevPos+1] =arr[prevPos];
                prevPos--;
            }
            // now we are at -1 or the index left og that no greater than curr
            // so put curr at next to prevPOs
            arr[prevPos+1] =curr;

        }
    }

    public static void main(String[] args) {

        int arr[] = {
                5, 4, 3, 2, 1
        };
        printArr(arr);
        System.out.println();
        // bubbleSort(arr);
        // selectionSort(arr);
        insertionSort(arr);
        printArr(arr);

    }
}