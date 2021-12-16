import java.util.Random;
import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        lotteryNumber();
    }
    public static void lotteryNumber () {
        final int SIZE = 4;
        boolean ifProper = false;
        Random rnd = new Random();
        int num;
        int code;
        int tens;
        int hundreds;
        int thousands;
        do {
            num = rnd.nextInt(1234, 6544);
            code = num;
            for (int i = 0; i < SIZE; i++) {
                int digit = num % 10;
                num = num / 10;
                if (digit != 0 && digit != 7 && digit != 8 && digit != 9) {
                    ifProper = true;
                } else {
                    ifProper = false;
                    break;
                }
            }
            num = code;
            int[] organsTheNumber = dismantlingNumber(num);
            thousands = organsTheNumber[0];
            hundreds = organsTheNumber[1];
            tens = organsTheNumber[2];
            int digit = organsTheNumber[3];
            if (digit == tens || digit == hundreds || digit == thousands) {
                ifProper = false;
            }
            if (tens == hundreds || tens == thousands) {
                ifProper = false;
            }
            if (hundreds == thousands) {
                ifProper = false;
            }
        }
        while (!ifProper);
        boolean isLegal;
        int[] organsTheNumber;
        int[] organsTheNumberOfGuess;
        int countOfAccurate;
        int countPartial;
        int count = 0;
        int amountOfGuesses;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("A 4-digit number was selected. You need to find out what he is." +
                    " Each time you enter a number and we will tell you how many digits you guessed exactly in the exact position" +
                    " and how many digits you guessed correctly but the position is wrong.\n" +
                    "Choose how many guesses you want for the game - 20/15/10 / " +
                    "\"0 for Surprising track\" where we will select the amount of guesses.");
            amountOfGuesses = scanner.nextInt();
        } while (amountOfGuesses != 20 && amountOfGuesses != 15 && amountOfGuesses != 10 && amountOfGuesses != 0);

        if (amountOfGuesses == 0) {
            amountOfGuesses = rnd.nextInt(5, 26);
        }

        while (count < amountOfGuesses) {
            count++;

            do {
                isLegal = true;
                countOfAccurate = 0;
                countPartial = 0;
                System.out.println("Enter code with 4 numbers");
                int guess = scanner.nextInt();
                if (guess < 1233 || guess > 6544) {
                    isLegal = false;
                }
                organsTheNumber = dismantlingNumber(num);
                organsTheNumberOfGuess = dismantlingNumber(guess);
                for (int k = 0; k < SIZE; k++) {
                    if (organsTheNumberOfGuess[k] == 0 || organsTheNumberOfGuess[k] == 7 ||
                            organsTheNumberOfGuess[k] == 8 || organsTheNumberOfGuess[k] == 9) {
                        isLegal = false;
                        break;
                    }
                }
                if (isLegal) {
                    int amountOfDuplicate;
                    for (int i = 0; i < SIZE; i++) {
                        amountOfDuplicate = 0;
                        int currentI = organsTheNumberOfGuess[i];
                        for (int j = i + 1; j < SIZE; j++) {
                            if (currentI == organsTheNumberOfGuess[j]) {
                                amountOfDuplicate++;
                                if (amountOfDuplicate == 1) {
                                    count = count + 2;
                                    isLegal = false;
                                    System.out.println("You entered a double number and therefore you were fined on 2 occasions");
                                }
                            }
                        }
                        break;
                    }
                    if (count >= amountOfGuesses) {
                        System.out.println("you failed. the code is" + " " + num);
                        break;
                    }
                    }
            }
            while (!isLegal);
            for (int i = 0; i < SIZE; i++) {
                if (organsTheNumber[i] == organsTheNumberOfGuess[i]) {
                    countOfAccurate++;
                    organsTheNumberOfGuess[i] = 0;
                }
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (organsTheNumber[i] == organsTheNumberOfGuess[j]) {
                        countPartial++;
                    }
                }
            }
            System.out.println("you guess" + "  " + countOfAccurate + "  " + "accurate numbers and" + "  " + countPartial +
                    "  " + "partial numbers");
            if (countOfAccurate == 4) {
                System.out.println("you won!!");
                break;
            }
            if (count > amountOfGuesses) {
                System.out.println("you failed. the code is" + " " + num);
            }
        }
        }
    public static int [] dismantlingNumber (int number) {
        final int SIZE_OF_ARRAY =4;
        int [] organsTheNumber= new int [SIZE_OF_ARRAY];
        int tens;
        int hundreds;
        int thousands;
        int digit = number % 10;
        int current = number/10;
        tens= current %10;
        current = current/10;
        hundreds = current%10;
        thousands = current/10;
        organsTheNumber[0] = thousands;
        organsTheNumber[1]= hundreds;
        organsTheNumber[2] = tens;
        organsTheNumber[3] = digit;
        return organsTheNumber;
    }
}