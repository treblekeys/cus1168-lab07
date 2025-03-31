//Jinqing Mei
package academy.javapro.lab7;

public class AlternativeArithmetic {
    /**
     * Adds two integers without using the '+' operator
     * Uses bitwise operations:
     * 1. XOR (^) to add bits without considering carry
     * 2. AND (&) with left shift to calculate carry
     * 3. Repeats until there's no carry left
     */
    public static int addWithoutPlus(int a, int b) {
        // Base case: if one of the numbers is 0, return the other
        if (b == 0) {
            return a;
        }
        if (a == 0) {
            return b;
        }

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    /**
     * Divides two integers without using the '/' operator
     * Uses a binary approach by finding how many times the divisor
     * fits into the dividend by repeated subtraction, but optimized
     * to use bit shifting for better performance
     */
    public static int divideWithoutDivideOperator(int dividend, int divisor) {
        // Handle edge cases
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by 0");
        }
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }

        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert to positive for the algorithm
        long absDividend = Math.abs(dividend);
        long absDivisor = Math.abs(divisor);

        // Use a binary approach for division
        int result = 0;
        while (absDividend >= absDivisor) {
            long temp = absDivisor;
            long multiple = 1;
            while (absDividend >= temp << 1) {
                temp <<= 1;
                multiple <<= 1;
            }
            absDividend -= temp;
            result += multiple;
        }
       return isNegative ? -result : result;
    }

    /**
     * BONUS: Subtract without using the '-' operator
     * Uses the property that a - b = a + (-b)
     */
    public static int subtractWithoutMinusOperator(int a, int b) {
        // Negate b and add to a
        return addWithoutPlus(a, ~b + 1); // ~b + 1 is the two's complement of b (equivalent to -b)
    }

    /**
     * Test all implementations
     */
    public static void main(String[] args) {
        // Test cases for addition
        int[][] additionTests = {
                {5, 3},     // 8
                {-2, 7},    // 5
                {0, 0},     // 0
                {-5, -3},   // -8
                {100, 200}, // 300
                {Integer.MAX_VALUE, 1}, // Edge case: handling overflow
                {-100, 100} // Additional: adding to zero
        };

        System.out.println("Testing addition without '+' operator:");
        for (int[] test : additionTests) {
            int result = addWithoutPlus(test[0], test[1]);
            int expected = test[0] + test[1];
            System.out.println(test[0] + " + " + test[1] + " = " + result +
                    (result == expected ? " (Correct)" : " (Incorrect, expected " + expected + ")"));
        }

        // Test cases for division
        int[][] divisionTests = {
                {10, 2},    // 5
                {15, 3},    // 5
                {8, 4},     // 2
                {7, 2},     // 3 (integer division)
                {100, 10},  // 10
                {-15, 3},   // -5 (negative dividend)
                {15, -3},   // -5 (negative divisor)
                {0, 5},     // 0 (dividend is 0)
                {1024, 2}   // 512 (power of 2 divisor)
        };

        System.out.println("\nTesting division without '/' operator:");
        for (int[] test : divisionTests) {
            try {
                int result = divideWithoutDivideOperator(test[0], test[1]);
                int expected = test[0] / test[1];
                System.out.println(test[0] + " / " + test[1] + " = " + result +
                        (result == expected ? " (Correct)" : " (Incorrect, expected " + expected + ")"));
            } catch (ArithmeticException e) {
                System.out.println(test[0] + " / " + test[1] + " = " + e.getMessage());
            }
        }

        // Test cases for bonus subtraction
        int[][] subtractionTests = {
                {10, 3},    // 7
                {5, 8},     // -3
                {0, 0},     // 0
                {-5, -3},   // -2
                {100, 50}   // 50
        };

        System.out.println("\nTesting subtraction without '-' operator:");
        for (int[] test : subtractionTests) {
            int result = subtractWithoutMinusOperator(test[0], test[1]);
            int expected = test[0] - test[1];
            System.out.println(test[0] + " - " + test[1] + " = " + result +
                    (result == expected ? " (Correct)" : " (Incorrect, expected " + expected + ")"));
        }
    }
}