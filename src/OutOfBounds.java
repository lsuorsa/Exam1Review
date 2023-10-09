import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class OutOfBounds {
    private int min;
    private int max;
    private static int low = 0;
    private static int high = 0;

    public static void main(String[] args) {
        try {
            System.out.println("This is a change");
            // initialization for file input and output
            File fileIn = new File("values.txt");
            File fileOut = new File("counts.txt");
            FileInputStream vals = new FileInputStream(fileIn);
            FileOutputStream out = new FileOutputStream(fileOut);
            Scanner scnr = new Scanner(vals);
            Scanner oneLine;
            PrintWriter output = new PrintWriter(out);

            int count = 0; // stores number of ints on a line
            String next; // stores values that are not ints on the line

            while (scnr.hasNextLine()) { // Loops for every line.
                oneLine = new Scanner(scnr.nextLine()); // takes one line and puts it into a scanner.
                while (true) { // loops until the next value is not an int.
                    if (oneLine.hasNextInt()) { // counts ints
                        oneLine.nextInt();
                        count++;
                    }
                    else { // if not an int
                        if (oneLine.hasNext()) { // checks for the case where it is not the end of the line.
                            next = oneLine.next();
                            if (next.equals("//")) {
                                output.write(count + "\n"); // if commented.
                            } else {
                                output.write("Invalid \n"); // if not.
                            }
                        }
                        else { // if it is the end of the line.
                            output.write(count + "\n");
                        }
                        break; // breaks the loop for the oneLine scanner.
                    }
                }
                count = 0; // resets the count for every line.
            }
            output.flush();
            output.close();
            scnr.close();
        }
        catch (Exception e) {
            System.out.println("File Not Found");
        }



    }

    public OutOfBounds(int mi, int ma) { min = mi; max = ma; }

    public void process(int value) { // checks if a single value is in bounds.
        if (value < min) {
            low++;
        }
        else if (value > max) {
            high++;
        }
    }
    public void process(ArrayList<Integer> values) { // checks an array of numbers to see if they are in bounds.
        for (int value : values) {
            process(value);
        }
    }

    // return functions
    public int tooLow() {
        return low;
    }
    public int tooHigh() {
        return high;
    }
}
