import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        System.out.println(normalString("3**2)"));
           }
           public static boolean normalString (String str) {
               boolean ifNormal = false;
               String numbers = "0123456789";
               if (str.length() <= 3) {
                   ifNormal = false;
               }
               for (int i = 0; i < str.length(); i++) {
                   if (ifNormal) {
                   }
                   char current = str.charAt(i);
                   for (int j = 0; j < numbers.length(); j++) {
                       if (current == numbers.charAt(j)) {
                           ifNormal = true;
                           break;
                       }
                   }
               }
               for (int j = 0; j < str.length(); j++) {
                   if (str.charAt(j) == str.charAt(j + 1)) {
                       ifNormal = false;
                       return false;
                   }
               }
               for (int k = 0; k < str.length(); k++) {
                   if (str.charAt(k) == '(') {
                       for (int m = k; m < str.length(); m++) {
                           if (str.charAt(m + 2) == ')') {
                               ifNormal = true;
                               break;
                           }
                       }
                   }
               }
               for (int f=0; f< str.length();f++) {
                   if (str.charAt(f) == ')') {
                       for (int m = 0; m < f; m++) {
                           if (str.charAt(m) == '(') {
                               ifNormal = true;
                           }
                       }
                       if (ifNormal == false) {
                           return false;
                       }
                   }
               }
               for (int s = 0; s < str.length(); s++) {
                   if (str.charAt(s) != '*' && str.charAt(s + 1) == '(') {
                       ifNormal = false;
                       break;
                   }
               }
               return ifNormal;
    }
}
