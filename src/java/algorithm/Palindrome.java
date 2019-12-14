package algorithm;

/**
 * 判断字符串是否是回文数
 */
public class Palindrome {

    /**
     * 使用StringBuilder辅助
     * @param string  判断是否为回文数的字符串
     * @return
     */
    public static boolean isPalindromeUseStringBuilder(String string) {
        if (string == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder(string);
        sb.reverse();
        return sb.equals(string);
    }

    /**
     * 不使用其他类
     */
    public static boolean isPalindrome(String string) {
        if (string == null) {
            return false;
        }
        int length = string.length();
        //int mid = length >> 1;
        //String leftStr = string.substring(0, mid);
        //String rightStr = string.substring(mid, length);
        //int rightLength = rightStr.length();
        //for (int i = 0; i < mid; i++) {
        //    if (leftStr.charAt(i) != rightStr.charAt(rightLength - i - 1)) {
        //        return false;
        //    }
        //}

        // 简化上面的代码逻辑，不对字符串进行划分，使用一个字符串一个索引从字符串头部开始，一个索引从字符串尾部开始
        for (int i = 0; i < length / 2; i++) {
            if (string.charAt(i) != string.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "abcba";
        System.out.println(isPalindrome(a));
    }
}
