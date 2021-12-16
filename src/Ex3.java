public class Ex3 {
    public static void main(String[] args) {
        factorization(18);

    }
    public static boolean isPrimeNumber(int number) {
        int count = 0;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        if (count == 0) {
            return true;
        }
        return false;
    }
    public static int [] factorization(int number) {
        int[] arr1 = new int[number];
        int digit;
        int count=0;
        int division = 2;
        int valueI = 0;
        while (!isPrimeNumber(number)) {
            if (number % division == 0) {
                digit = division;
                number = number / division;
                for (int i = valueI; i < arr1.length;) {
                    arr1[i] = digit;
                    count++;
                    valueI++;
                    break;
                }
            } else {
                division++;
            }
        }
        for (int i = valueI; i < arr1.length;) {
            arr1[i] = number;
            count++;
            break;
        }
        int[] finalArr = new int[count];
        int locationInArray=0;
        for (int j=locationInArray;j<finalArr.length;j++) {
            for (int i=locationInArray;i< arr1.length;i++) {
                if (arr1[i] !=0) {
                    finalArr[j] = arr1[i];
                    locationInArray++;
                    break;
                }
            }
        }
        for (int i =0; i < finalArr.length; i++) {
            System.out.print(finalArr[i]+ " ");

        }
        return finalArr;
    }
}

