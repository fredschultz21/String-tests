import java.util.Scanner;
import java.util.Arrays;

public class HW1 {
    public static void main(String[] args) {
        System.out.println("mismatch test of ATCGAT and TAGCTA:     " + mismatch("ATCGAT", "TAGCTA"));
        System.out.println("mismatch test of ATCGAT and TAGCAA:     " + mismatch("ATCGAT", "TAGCAA"));
        System.out.println("mismatch test of ATCGAT and TATCTT:     " + mismatch("ATCGAT", "TATCTT"));
        System.out.println("mismatch test of GTCG and TAGCTA:     " + mismatch("GTCG", "TAGCTA"));
        System.out.println();
        System.out.println("removeZeros test of (1, -2, 3):     " + Arrays.toString(removeZeros(new int[]{1,-2,3})));
        System.out.println("removeZeros test of (1, 0, 0):     " + Arrays.toString(removeZeros(new int[]{1,0,0})));
        System.out.println("removeZeros test of (1, 0, -2, 0, 3):     " + Arrays.toString(removeZeros(new int[]{1,0,-2,0,3})));
        System.out.println("removeZeros test of (0, 0):     " + Arrays.toString(removeZeros(new int[]{0,0})));
        System.out.println();
        System.out.println("vowelCount test of homework:     " + Arrays.toString(vowelCount("homework")));
        System.out.println("vowelCount test of sun goes down early:     " + Arrays.toString(vowelCount("sun goes down early")));
        System.out.println("vowelCount test of fly:     " + Arrays.toString(vowelCount("fly")));
        System.out.println();
        String exstring = "6 fun. 3 hello   10    <> 2  25  4 wow!";
        Scanner sc = new Scanner(exstring);
        System.out.println("printString test of (6 fun. 3 hello   10    <> 2  25  4 wow!): ");
        printStrings(sc);
        System.out.println();
        System.out.print("showTwos test of 7:     ");
        showTwos(7);
        System.out.print("showTwos test of 18:     ");
        showTwos(18);
        System.out.print("showTwos test of 68:     ");
        showTwos(68);
        System.out.print("showTwos test of 120:     ");
        showTwos(120);
    }

/* Write the mismatch method here. The method takes two Strings
and returns the number of mismatches */

    //Mismatch checks which string is longer first, then adds the difference in lengths to totaldiff.
    //It then simply increments total diff every time there's a mismatch, then returns totaldiff.
    public static int mismatch(String strA, String strB) {
        int totaldiff = 0;
        int shortestlen = 0;
        if (strA.length() < strB.length()) {
            shortestlen = strA.length();
            totaldiff += strB.length() - strA.length();
        } else if (strA.length() > strB.length()) {
            shortestlen = strB.length();
            totaldiff += strA.length() - strB.length();
        } else {
            shortestlen = strA.length();
        }
        for (int i = 0; i < shortestlen; i++) {
            if (strA.charAt(i) == 'A') {
                if (strB.charAt(i) != 'T') {
                    totaldiff += 1;
                }
            } else if (strA.charAt(i) == 'T') {
                if (strB.charAt(i) != 'A') {
                    totaldiff += 1;
                }
            } else if (strA.charAt(i) == 'G') {
                if (strB.charAt(i) != 'C') {
                    totaldiff += 1;
                }
            } else if (strA.charAt(i) == 'C') {
                if (strB.charAt(i) != 'G') {
                    totaldiff += 1;
                }
            }
        }
        return totaldiff;
    }

/* Write the removeZeros method here. The method takes an array
of integers and returns a new array */

    //First the number of zeros is counted to assure there
    //is minimal extra space unused in the rebuild array (B).
    //It rebuilds B using every element of A that isn't a 0, then returns B.
    public static int[] removeZeros(int[] A) {
        int zeros = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                zeros++;
            }
        }
        int[] B = new int[A.length - zeros];
        int step = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != 0) {
                B[step] = A[i];
                step++;
            } else {}
        }
        return B;
    }




/* Write the vowelCount method here. The method takes a String
and returns a new array of integers
representing the counts of each vowel in the String. */

    //An array of length 5 is initialized to count up each vowel.
    //The string is iterated one character at a time, checking for vowels
    //and adding 1 to each array once each vowel is seen.
    public static int[] vowelCount(String A) {
        int[] vowels = new int[5];
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'a') {
                vowels[0]++;
            } else if (A.charAt(i) == 'e') {
                vowels[1]++;
            } else if (A.charAt(i) == 'i') {
                vowels[2]++;
            } else if (A.charAt(i) == 'o') {
                vowels[3]++;
            } else if (A.charAt(i) == 'u') {
                vowels[4]++;
            }
        }
        return vowels;
    }


/* Write the printStrings method here. The method takes a Scanner
holding a sequence of integer/string pairs and prints to the console
(System.out) one line of output for each pair, with the given
String repeated the given number of times. */

    //The method takes a scanner object. While there's a next token,
    //the method keeps scanning. Once the integer and the string are received,
    //the string is printed out for the same times as the integer.
    public static void printStrings(Scanner s) {
        while (s.hasNext()) {
            int repeats = s.nextInt();
            String line = s.next();
            for (int i = 0; i < repeats; i++) {
                System.out.print(line);
            }
            System.out.println();
        }
    }


/* Write the showTwos method here. The method takes an int and prints
on the console factors of 2 in a given integer in the format
specified in the assignment. */

    //g is reduced repeatedly by being divided by 2, but only if 2 goes in
    //without a remainder. An array of the 2s is built up. Once g can't be
    //divided by 2 anymore, the equation is printed.
    public static void showTwos(int g) {
        int permg = g;
        int[] nums = new int[10];
        int j = 0;
        while (g % 2 == 0) {
            g = g / 2;
            nums[j] = 2;
            j++;
        }
        nums[j] = g;
        System.out.print(permg + " = " + nums[0]);
        int t = 1;
        while (nums[t] != 0) {
            System.out.print(" * " + nums[t]);
            t++;
        }
        System.out.println();
    }
}