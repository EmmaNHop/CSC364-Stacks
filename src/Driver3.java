
//Emma Hopkins -- this code reads the file's data
import java.io.*;
        import java.util.*;
public class  Driver3 {
    public static Stack S1;
    public static Stack S2;
    public static Scanner inp;
    public static File f;
    public static String fname;
    public static int x;
    public static void main(String[] args) {
        System.out.print("Please enter a path or name of input file : ");
        inp = new Scanner(System.in);
        fname = inp.nextLine();
        f = new File(fname);
        try {
            inp = new Scanner(f);
        } catch (Exception E) {
            System.out.println("File not found");
        }

        S1 = new Stack();
        S2 = new Stack();

        int N = Integer.parseInt( inp.nextLine()) ;
        int count = 0;

        System.out.println("SORTED LIST");
        System.out.println("---------------");

        while (inp.hasNextLine()) {
            x = Integer.parseInt(inp.nextLine());

 // pop out the first element
// But you cannot pop( ) from an EMPTY Stack!!! and the stacks start off empty.
            //S1.push(x);

//  while the S1 stack is NOT empty AND S1.top( ) < x
            while(!S1.isEmpty() && S1.top() < x) {
                S2.push(S1.pop());       //   <--- this line is actual code to use
            }

//  Now push x  onto S1
            S1.push(x);
//  while stack S2 is NOT empty
            while (!S2.isEmpty()) {
                S1.push(S2.pop());       // <-- again this line is actual code to use
            }

        }
        // Now you can print out the sorted list with the following code
// you may need to clean it up a bit

        while( !S1.isEmpty( ) && count < N ) {
            count++;
            System.out.println(count + ":" + S1.pop());
        }
    }
}