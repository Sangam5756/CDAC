package Practice;

public class BinarySearch{


    public static int binarySearch(int arr[], int target){

        int low =0;
       int high =arr.length-1;
            int ans=-1;
        while(low < high){
            int mid = (low+high)/2;

            if(arr[mid] == target){
                ans=mid;
                return mid;

            }else if(arr[mid] > target){
                    high=mid-1;
            }else{
                low= mid+1;
            }

        }

        return ans;


    }


    public static void main(String args[]){
            int arr[] = { 1, 2, 3, 4, 5};
           System.out.println( binarySearch(arr,4));
    }
}