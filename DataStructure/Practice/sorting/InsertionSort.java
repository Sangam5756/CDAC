
/**
 * Class shows insertion sort.
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		
		int arr[] = { 29, 19, 32, 2, 6 };
		
		for (int cardIndex = 1; cardIndex < arr.length; cardIndex++) {
			int currentCard = arr[cardIndex]; // the card in right hand.
			int position = cardIndex - 1; //start from left hand.
			while (position >= 0 && currentCard < arr[position]) {
				arr[position + 1] = arr[position]; // shift only (no swap)
				position--;
			}
			//always goes one index behind, hence + 1;
			arr[position + 1] = currentCard; 
		}
		for (int element : arr) {
			System.out.print(element + " ");
		}
	}

}
