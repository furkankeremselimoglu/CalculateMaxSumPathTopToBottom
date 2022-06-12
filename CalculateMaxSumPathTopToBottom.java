public class CalculateMaxSumPathTopToBottom {
    public static void main(String[] args) {
        int[][] input = {
                {1},
                {8, 4},
                {2, 6, 9},
                {8, 5, 9, 3}
        };

        int[][] input2 = {
                {215},
                {193, 124},
                {117, 237, 442},
                {218, 935, 347, 235},
                {320, 804, 522, 417, 345},
                {229, 601, 723, 835, 133, 124},
                {248, 202, 277, 433, 207, 263, 257},
                {359, 464, 504, 528, 516, 716, 871, 182},
                {461, 441, 426, 656, 863, 560, 380, 171, 923},
                {381, 348, 573, 533, 447, 632, 387, 176, 975, 449},
                {223, 711, 445, 645, 245, 543, 931, 532, 937, 541, 444},
                {330, 131, 333, 928, 377, 733, 017, 778, 839, 168, 197, 197},
                {131, 171, 522, 137, 217, 224, 291, 413, 528, 520, 227, 229, 928},
                {223, 626, 034, 683, 839, 053, 627, 310, 713, 999, 629, 817, 410, 121},
                {924, 622, 911, 233, 325, 139, 721, 218, 253, 223, 107, 233, 230, 124, 233}
        };

        System.out.print("The Max Sum Path Top to Bottom for input 1 is: ");
        solve(input);

        System.out.print("The Max Sum Path Top to Bottom for input 2 is: ");
        solve(input2);
    }

    public static void solve(int[][] array) {
        // Changing primes to Integer.MIN_VALUE
        changePrimesToMin(array);
        // Calculating the max sum top to bottom by starting top of the pyramid
        System.out.println(calculateMaxSumPathTopToBottom(array, 0, 0, array.length));
    }

    // This method calls recursively to find the maximum sum top to bottom
    public static int calculateMaxSumPathTopToBottom(int[][] array, int i, int j, int row_length) {
        if(i == row_length) {
            return 0;
        } else {
            return array[i][j] + Math.max(calculateMaxSumPathTopToBottom(array, i + 1, j, row_length), calculateMaxSumPathTopToBottom(array, i + 1, j + 1, row_length));
        }
    }

    // Changing the prime numbers to Integer.MIN_VALUE
    public static void changePrimesToMin(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (isPrime(array[i][j])) {
                    array[i][j] = Integer.MIN_VALUE;
                }
            }
        }
    }

    // This method finds the number is prime or not
    public static boolean isPrime(int number) {
        if(number < 2) {
            return false;
        } else {
            for(int checkNumber = 2; checkNumber < number; checkNumber++) {
                if(number % checkNumber == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
