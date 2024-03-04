package src.main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParenSymmetry {


    private Boolean isBalanced(String s) {
        // implement this method
        int length = s.length();
        int i = 0;
        char[] ch = s.toCharArray();
        int open = 0;
        int closed = 0;
        boolean flag = false;
        while (i < length) {
            if (ch[i] == ')') {
                open++;
            } else if (ch[i] == '(') {
                closed++;
            }
            i++;
        }

        if (open == closed) {
            System.out.println("Balanced string");
            flag = true;
        } else {
            System.out.println("Not balanced string");
            flag = false;
        }

        return flag;
    }

    private void checkFile(String filename) {
        // open file named filename
        File file = new File(filename);

        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                boolean b = isBalanced(str);
                System.out.println(b);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();
        ps.checkFile("./TestStrings1.txt");
        Boolean b0 = ps.isBalanced("(    ())!()");
        System.out.println(b0);
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
