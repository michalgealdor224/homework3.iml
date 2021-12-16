import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {

        System.out.println(switchLetter());
    }
    public static char[] findMostAndSecondLetters(String str) {
        final int SIZE_ARRAY = 2;
        char[] mostAndSecondMostLetters = new char[SIZE_ARRAY];
        int countLetters = 0;
        int amountOfMaxLetters = 0;
        int secondAmountOfLetters = 0;
        char mostCommonChar = ' ';
        char secondCommonChar = ' ';
        for (int i = 0; i < str.length(); i++) {
            char currentI = str.charAt(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == currentI) {
                    countLetters++;
                }
            }
            if (countLetters > amountOfMaxLetters && str.charAt(i) != ' ') {
                secondAmountOfLetters = amountOfMaxLetters;
                amountOfMaxLetters = countLetters;
                mostCommonChar = str.charAt(i);
            } else if (countLetters > secondAmountOfLetters && mostCommonChar != str.charAt(i) && str.charAt(i) != ' ' ) {
                secondAmountOfLetters = countLetters;
                secondCommonChar = str.charAt(i);
            }
            countLetters = 0;

        }
        mostAndSecondMostLetters[0]=mostCommonChar;
        mostAndSecondMostLetters[1]=secondCommonChar;
        return mostAndSecondMostLetters;
    }
                 public static String switchLetter( ) {
                     Scanner scanner = new Scanner(System.in);
                     System.out.println("enter string");
                     String str =scanner.nextLine();
                 char[] arrayOfLetters =findMostAndSecondLetters(str);
                char mostLetter= arrayOfLetters [0];
                char secondLetter= arrayOfLetters [1];
                String afterSwitch = "";
                for (int k = 0; k < str.length(); k++) {
                    if (str.charAt(k) == mostLetter) {
                        afterSwitch +=secondLetter;

                    } else if (str.charAt(k) == secondLetter) {
                        afterSwitch += mostLetter;

                    } else {
                        afterSwitch +=str.charAt(k);
                    }
                }
        return afterSwitch;
    }

}
