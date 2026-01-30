
import java.util.Queue;
import java.util.LinkedList;

/**
 * Code to generate 'n' binary numbers
 *
 */
public class BinaryNumbers {
    public static void generateBinary(int n) {
        Queue<String> q = new LinkedList<String>();
        q.add("1");

        for (int i = 1; i <= n; i++) {
            String s = q.remove();     // dequeue front
            System.out.print(s + " "); // print it

            q.add(s + "0");            // enqueue s0
            q.add(s + "1");            // enqueue s1
        }
    }

    public static void main(String[] args) {
        generateBinary(5);
    }
 }
