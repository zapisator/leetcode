public class MaximumNumberOfBallsInABox {

    public static void main(String[] args) {
        test();
    }

    static class Solution {

        public int countBalls(int lowLimit, int highLimit) {
            int[] intermediate = new int[9 + 9 + 9 + 9 + 9 + 1];
            for (int number = lowLimit; number <= highLimit; number++) {
                int sum = sum(number);
                intermediate[sum]++;
            }
            int result = intermediate[0];
            for (int number : intermediate) {
                if (number > result) {
                    result = number;
                }
            }
            return result;
        }

        private int sum(int number) {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            return sum;
        }

//        public int countBalls(int lowLimit, int highLimit) {
//            Map<Integer, Integer> ballCounter = new HashMap<>();
//            for (int number = lowLimit; number <= highLimit; number++) {
//                int sum = sum(number);
//                ballCounter.compute(sum, (key, value) -> value == null ? 1 : value + 1);
//            }
//            return Collections
//                    .max(ballCounter.entrySet(), Entry.comparingByValue())
//                    .getValue();
//        }
//
//        public int countBalls(int lowLimit, int highLimit) {
//            Map<Integer, Integer> ballCounter = new HashMap<>();
//            for (int number = lowLimit; number <= highLimit; number++) {
//                int sum = String.valueOf(number).chars()
//                        .map(Character::getNumericValue)
//                        .sum();
//                ballCounter.compute(sum, (key, value) -> value == null ? 1 : value + 1);
//            }
//            return ballCounter.entrySet().stream()
//                    .max(Map.Entry.comparingByValue())
//                    .get()
//                    .getValue();
//        }

    }

    private static void test() {
        final int[] lowLimits = new int[]{
                1
        };
        final int[] highLimits = new int[]{
                10
        };
        final int[] expectations = new int[]{
                2
        };

        for (int i = 0; i < expectations.length; i++) {
            check(lowLimits[i], highLimits[i], expectations[i]);
        }

    }

    private static void check(int lowLimit, int highLimit, int expectation) {
        int result = new Solution().countBalls(lowLimit, highLimit);
        System.out.printf(
                "input lowLimit: %10d\tinput highLimit: %10d\texpectation: %30s\tresult: %30s\t%s\n",
                lowLimit, highLimit,  expectation, result,
                result == expectation ? "PASSED" : "FAILED"
        );
    }
}
