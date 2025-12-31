package Practice;

public class InsertionSort {


    public static void insertionSort(int arr[] ){

        // in selection  sort , find min and replace
       for(int i=1; i<arr.length; i++){
            int curr = arr[i];
            int pos = i - 1;
            while(  pos >=0 && arr[pos]> curr){
                arr[pos+1] =arr[pos];
                pos--;
            }
            arr[pos+1] =curr;


       }

    }

    public  static void print(int arr[]){
        for (int element : arr) {
			System.out.print(element + " ");
		}
        System.out.println();
    }

    public static void main(String[] args) {
        
 int arr[] = { 5,4,3,2,1,454,4545,4,0};
        print(arr);
        insertionSort(arr);
        print(arr);

    }
}
