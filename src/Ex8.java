import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        System.out.println(popularSubstring(unitedStrings()));
    }

    public static String[] unitedStrings() {
        int count = 0;
        int locationInArray = 0;
        String str;
        Scanner scanner = new Scanner(System.in);
        final int SIZE_ARRAY = 1000;
        String[] current = new String[SIZE_ARRAY];
        do {
            System.out.println("enter string");
            str = scanner.nextLine();
            for (int i = locationInArray; i < current.length; i++) {
                current[i] = str;
                locationInArray++;
                count++;
                break;
            }
        }
        while (str.length() >= 4);
        String[] arrayOfStrings = new String[count];
        arrayCopy(arrayOfStrings, current);
        return arrayOfStrings;
    }

    public static String[] allSubStringsOfTheWord(String s) {
        int count = 0;
        int x = 0;
        int j = 0;
        int location = 0;
        String[] randomArray = new String[s.length() * s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (j = x + 1; j < s.length(); j++) {
                randomArray[location] = subString(s, i, j);
                count++;
                location++;
            }
            x++;
        }
        String[] arrayOfSubstring = new String[count];
        arrayCopy(arrayOfSubstring, randomArray);
        return arrayOfSubstring;
    }



    public static String subString(String str, int start, int stop) {
        String str2 = "";
        for (int i = start; i <= stop; i++) {
            str2 = str2 + str.charAt(i);
        }
        return str2;
    }

    public static boolean isEquals(String str1, String str2) {
        boolean isEquals = false;
        if (str1.length() == str2.length()) {
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) == str2.charAt(i)) {
                    isEquals = true;
                } else {
                    isEquals = false;
                    break;
                }
            }
        }
        return isEquals;
    }

    public static String popularSubstring(String[] str) {
        final int SIZE_ARRAY = 0;
        String[] afterSwitch = new String[SIZE_ARRAY];
        for(int m=0; m< str.length; m++){
            afterSwitch = new String[afterSwitch.length + allSubStringsOfTheWord(str[m]).length];
        }

        int location = 0;
        int secondLocation = 0;
        for (int k = 0; k < str.length; k++) {
            String[] x = allSubStringsOfTheWord(str[k]);
            for (int i = secondLocation; i< x.length; i++) {
                for (int j = secondLocation; x[j] !=null; j++) {
                    if (x[j] != null) {
                        afterSwitch[location] = x[secondLocation];
                        location++;
                        secondLocation++;

                    }
                    else {
                        secondLocation = 0;
                        break;
                    }
                    break;
                }
            }
            secondLocation = 0;
        }
        int countMax =0;
        int count;
        String maxSubstring="";
        String suspiciousAsAMaximum= "";
        String current;
        for (int i=0;i< afterSwitch.length; i++) {
            count=0;
            current= afterSwitch[i];
            for (int j=0;j< afterSwitch.length; j++) {
                if (isEquals(current,afterSwitch[j])) {
                    count++;
                    suspiciousAsAMaximum=afterSwitch[j];
                }
                if (count> countMax) {
                    countMax=count;
                    maxSubstring = suspiciousAsAMaximum;
                }
            }
        }
        return maxSubstring;
    }

    public static String[] arrayCopy (String[] str1, String[] str2) {
        for(int i=0; i< str1.length; i++) {
            str1[i] = str2[i];
        }
        return str2;
    }

}





