package Practice;

public class BubbleSort {


    public static void bubbleSort(int arr[] ){

        // in bubble sort , compare adjacent
        for(int i=0; i<arr.length;i++){

            for(int j=i+1; j<arr.length;j++){
                
                if(arr[i]> arr[j]){
                    int temp =arr[i];
                    arr[i] =arr[j];
                    arr[j] =temp;
                    
                }

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
        bubbleSort(arr);
        print(arr);

    }
}
