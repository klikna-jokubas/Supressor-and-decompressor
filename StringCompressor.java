public class StringCompressor {
    public static String compressString(String s) {
        if (s.isEmpty()) return ""; //simply check if our string is empty, if it is we output nothing

        StringBuilder result = new StringBuilder(); //this where we are going to store our result
        int count = 1;

        for (int i = 1; i < s.length(); i++) { //loop through whole string
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;  // here we are checking if our letter i is equal to previous letter, if it is we increment our counter
            } else {
                result.append(s.charAt(i - 1)).append(count);
                count = 1;  // here if we get our new letter, reduce counter to 1 and save the character
            }
        }


        result.append(s.charAt(s.length() - 1)).append(count); // here we append the last character

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressString("aaabb"));
        System.out.println(compressString("abc"));
        System.out.println(compressString(""));
    }
}
