package programowanieof.laby.lab1;

public class Calculations {

    public static long twoToNth(int n, long acc) {
        if (n == 1) {
            return acc;
        } else if (n == 0) {
            return 1;
        }
        else {
            return twoToNth(n-1, acc*2);
        }
    }

    static long calculateSum(int lowerLimit, int upperLimit) {
        long sum = 0;
        for (int i = lowerLimit; i <= upperLimit; i++) {
            sum = sum + i;
        }
        return sum;
    }

}
