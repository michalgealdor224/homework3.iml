public class Ex1 {
    public static void main(String[] args) {
        int[] arr = {12, 34, 56, 23};
        System.out.println(numberChange.minimumChangeNumber(arr));
    }
    static class numberChange {
        public static boolean changeNumber(int number) {
            boolean isChange = false;
            int tens;
            int digit = 0;
            while (number > 10) {
                digit = number % 10;
                number = number / 10;
                tens = number % 10;
                if (digit % 2 == 0 && tens % 2 != 0 || digit % 2 != 0 && tens % 2 == 0) {
                    isChange = true;
                } else {
                    isChange = false;
                    break;
                }
            }
            if (digit % 2 == 0 && number % 2 == 0 || digit % 2 != 0 && number % 2 != 0) {
                isChange = false;
            }
            return isChange;
        }

        public static int sumOfNumber(int numberFromArr) {
            int numOfDigit=0;
            int sumOfDigit = 0;
            do {
                numOfDigit = numberFromArr % 10;
                numberFromArr = numberFromArr / 10;
                sumOfDigit = sumOfDigit + numOfDigit;
            } while (numberFromArr % 10 != 0);

            return sumOfDigit;
        }

        public static int minimumChangeNumber(int[] arr) {
            int sumOfOrgans;
            int maxSum = 0;
            int locationOfMaxSum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (changeNumber(arr[i])) {
                    sumOfOrgans = sumOfNumber(arr[i]);
                    if (sumOfOrgans > maxSum) {
                        maxSum = sumOfOrgans;
                        locationOfMaxSum = i;
                    }
                } else return -1;
            }
            return locationOfMaxSum;
        }
    }
}

