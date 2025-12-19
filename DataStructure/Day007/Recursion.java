public class Recursion {

    public static int SumOfArrayUsingRecursion(int[] arr, int size) {

        if (size == 0) {
            return 0;
        }

        // 1 + 2 + 3 + 4
        return arr[size - 1] + SumOfArrayUsingRecursion(arr, size - 1);
    }

    static public int factorialUsingRecursion(int n) {
        // 5*4*2*2*1;
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorialUsingRecursion(n - 1);
    }

    public static int fibonnacci(int n) {

        // 0 1 1 2 3 5
        // 0+1->1->1+1->2->1+2->3->3+1->5
        if (n <= 1) {
            return n;
        }

        return fibonnacci(n - 1) + fibonnacci(n - 2);

    }

    public static int binarySearchRecursive(int arr[], int left, int right, int target) {
        int mid = left + (right - left) / 2;

        if (left > right) {
            return -1;
        }

        if (arr[mid] == target) {
            return mid;

        } else if (arr[mid] > target) {
            return binarySearchRecursive(arr, left, mid - 1, target);
        } else {
            return binarySearchRecursive(arr, mid + 1, right, target);
        }

    }

    public static String reverseUsingRecursion(String str){

        if(str.length() ==1){
            return str;
        }
        // abc
        // c b a

        return str.charAt(str.length()-1)+ reverseUsingRecursion(str.substring(0,str.length()-1));
    }


    public static boolean isPalindrome(String str,int left,int right){

        if(left > right){
            
            return true;
        }

        if(str.charAt(left)!=str.charAt(right)){
            return false;
        }
        
        return isPalindrome(str, left+1, right-1);

    }



    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        // System.out.println(SumOfArrayUsingRecursion(arr,arr.length));
        // System.out.println(factorialUsingRecursion(5));
        // System.out.println(fibonnacci(5));
        // System.out.println(binarySearchRecursive(arr, 0, arr.length - 1, 5));
        // System.out.println(reverseUsingRecursion("sangam"));
        String str ="sssaaaass";
        System.out.println(isPalindrome(str, 0, str.length()-1));
    }
}
