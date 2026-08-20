package TwoPointers;
public class ValidPalindromeII {
        public static boolean validPalindrome(String s) {

            int i = 0;
            int j = s.length() - 1;

            while (i < j) {

                if (s.charAt(i) != s.charAt(j)) {

                    // Skip left character
                    if (isPalindrome(s, i + 1, j)) {
                        return true;
                    }

                    // Skip right character
                    return isPalindrome(s, i, j - 1);
                }

                i++;
                j--;
            }

            return true;
        }

        private static boolean isPalindrome(String s, int i, int j) {

            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }

                i++;
                j--;
            }

            return true;
        }

    public static void main(String[] args) {
        System.out.println(validPalindrome("aaaaza"));
    }
}
