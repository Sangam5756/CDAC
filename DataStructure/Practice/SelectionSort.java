package Practice;

public class SelectionSort {


    public static void selectionSort(int arr[] ){

        // in selection  sort , find min and replace
        for(int i=0; i<arr.length-1;i++){
            int min=i;
            for(int j=i+1; j<arr.length;j++){
                if(arr[j] < arr[min]){
                    min =j;
                }
                
          
            }

            if(i != min){
                int temp = arr[i];
                arr[i] =arr[min];
                arr[min]=temp;
            }
           
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
        selectionSort(arr);
        print(arr);

    }
}
