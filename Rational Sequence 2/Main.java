import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        in.nextLine();

        for (int i = 0; i < cases; i++) {
            String[] split = in.nextLine().split(" ");
            int p = Integer.parseInt(split[1].split("/")[0]);
            int q = Integer.parseInt(split[1].split("/")[1]);
            ArrayList<String> direction = new ArrayList<>();

            while (p > 1 || q > 1) {
                if (p > q) {
                    direction.add("R");
                    p -= q;
                } else {
                    direction.add("L");
                    q -= p;
                }
            }
            int location = 0;
            int leftCount = 0;
            for (String s: direction) {
                if (s.equals("L")) {
                    location = (2 * (location + 1));
                    leftCount++;
                } else {
                    location = (2 * location + 1);
                    leftCount--;
                }
            }
            location = location - leftCount;
            System.err.println(leftCount);

            if (leftCount > 0) {
                System.out.println(split[0] + " " + (location));
            } else {
                System.out.println(split[0] + " " + (location + 1));
            }
        }
    }
}
