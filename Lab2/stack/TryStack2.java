
public class TryStack2 {

    // Change this file as much or as little as you need to.

    /**
     * Main driver method that will reverse an array.
     *
     * @param args
     */

    public static  void printArray(Integer[] l) {
        System.out.println();

        for (int i=0; i<l.length; i++) {
            System.out.print(l[i] + "\t");
        }
        System.out.println();

    }
    public static Integer[] rev(Integer[] l) {
        Integer[] n = new Integer[l.length];
        LinkedStack<Integer> St = new LinkedStack<>();

        for (int i = 0; i < l.length; i++){
            St.push(l[i]);
        }

        System.out.println("\nInspecting stack (top..bottom): " + St);// testing

        for (int i = 0; i < l.length; i++) {
            n[i] = (Integer) (St.pop());
        }
        return n;
    }
    public static void main(String[] args) {
        Integer[] array= new Integer[50];
        for (int i = 0; i < 50; i++) {
            array[i] =i*2;
        }
        printArray(array);
        array =rev(array);
        printArray(array);

    }
    }



