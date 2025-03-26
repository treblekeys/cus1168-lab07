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
        // TODO: return a if b is 0
        // TODO: return b if a is 0

        // TODO:Create a while loop that runs until b is 0. This loop will calculate the sum of a and b
            // TODO: create a variable carry and assign it the result of the bitwise AND operation between a and b
            // TODO: assign the result of the bitwise XOR operation between a and b to a
            // TODO: assign the result of the left shift operation on carry by 1 to b
        // TODO return a because it contains the sum of a and b
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Divides two integers without using the '/' operator
     * Uses a binary approach by finding how many times the divisor
     * fits into the dividend by repeated subtraction, but optimized
     * to use bit shifting for better performance
     */
    public static int divideWithoutDivideOperator(int dividend, int divisor) {
        // Handle edge cases
        // TODO: throw an ArithmeticException if divisor is 0
        // TODO: return 0 if dividend is 0
        // TODO: return dividend if divisor is 1

        // TODO: create a boolean variable isNegative and assign it the result of the XOR operation between dividend and divisor

        // Convert to positive for the algorithm
        // TODO: create a long variable absDividend and assign it the absolute value of dividend
        // TODO: create a long variable absDivisor and assign it the absolute value of divisor

        // Use a binary approach for division
        // TODO: create an int variable result and assign it 0
        // TODO: while absDividend is greater than or equal to absDivisor
            // TODO: create a long variable temp and assign it the value of absDivisor
            // TODO: create a long variable multiple and assign it 1
            // TODO: while absDividend is greater than or equal to temp shifted left by 1
                // TODO: shift temp left by 1
                // TODO: shift multiple left by 1
            // TODO: subtract temp from absDividend
            // TODO: add multiple to result using the += operator

        // TODO: return the result if isNegative is false
        throw new UnsupportedOperationException("Not implemented yet");
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