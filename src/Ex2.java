public class Ex2 {
    public static void main(String[] args) {
        int [] arr1= {43,6,5,7,87} ;
        int [] arr2 = {33,47,60};
        System.out.println(locationOfProximityLevel(arr1,arr2));
    }
    public static int sumOfNumber (int numberFromArr) {
        int numOfDigit;
        int sumOfDigit=0;
        do {
            numOfDigit= numberFromArr% 10;
            numberFromArr= numberFromArr/ 10;
            sumOfDigit = sumOfDigit + numOfDigit;
        }while (numberFromArr %10 != 0) ;

   return sumOfDigit;
    }
    public static int locationOfProximityLevel (int [] arr1, int [] arr2) {
        int sumArr1;
        int count;
        int maxCount=0;
        int locationMaxCount=0;
        for (int i=0; i< arr1.length; i++) {
            count=0;
            sumArr1=sumOfNumber(arr1[i]);
            for(int j=0;j<arr2.length;j++){
                if(sumArr1==sumOfNumber(arr2[j])){
                    count++;
                }
            }
            if (count> maxCount) {
                maxCount=count;
                locationMaxCount=i;
            }
        }
        return locationMaxCount;

    }

}
