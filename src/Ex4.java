public class Ex4 {
    public static void main(String[] args) {
        int [] arr = {14,15,12,13};
        System.out.println(fullArray(arr));
        System.out.println(fullArraySorted(arr));
    }
    public static boolean fullArray (int [] numbers) {
        boolean isSequential= false;
        int maxOfNumber =0;
        int minOfNumber=999999;
        for (int i=0; i< numbers.length; i++) {
            if (numbers[i] > maxOfNumber ) {
                maxOfNumber = numbers[i];
            }
            if (numbers[i]< minOfNumber) {
                minOfNumber= numbers[i];
            }
        }
        int minimumNumber = minOfNumber;
        int count=0;
        if (numbers.length == 1) {
            return true;
        }
            for (int j = 0; j < numbers.length; j++) {
                if (minimumNumber > maxOfNumber-1){
                    break;
                }
                if (numbers[j] == minimumNumber+1) {
                    minimumNumber++;
                    count++;
                    isSequential = true;
                    j = j - count;
                    count = 0;
                }
                else {
                    isSequential = false;
                    count++;
                }
            }
        return isSequential;
    }

    public static boolean fullArraySorted (int [] arr) {
        boolean isSequential = false;
        for (int i=0; i< arr.length-1; i++) {
            if (arr[i] == arr[i+1] +1) {
                isSequential=true;
            }
            else {
                isSequential = false;
                break;
            }
        }
        return isSequential;
    }
}
