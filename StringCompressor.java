public class StringCompression {

    public static String compressString(String s) {
        if (s.isEmpty()) return "";   //simply check if our string is empty, if it is we output nothing

        StringBuilder result = new StringBuilder();  //this where we are going to store our result
        int count = 1;

        for (int i = 1; i < s.length(); i++) { //loop through whole string
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++; // here we are checking if our letter i is equal to previous letter, if it is we increment our counter
            } else {
                result.append(s.charAt(i - 1)).append(count);
                count = 1;  // here if we get our new letter, reduce counter to 1 and save the character
            }
        }

        result.append(s.charAt(s.length() - 1)).append(count); // here we append the last character

        return result.toString();
    }


    public static String decompressString(String s) {
        if (s.isEmpty()) return "";  //simply check if our string is empty, if it is we output nothing

        StringBuilder result = new StringBuilder(); //this where we are going to store our result

        for (int i = 0; i < s.length(); i += 2) { //loop through whole string, one letter and number, that's why i +=2
            char character = s.charAt(i);  // get the character needed
            int count = Character.getNumericValue(s.charAt(i + 1));  // Convert number to int


            for (int j = 0; j < count; j++) {
                result.append(character); // what's the number that many times we add it to the result, for example a3 = aaa
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Compression Tests
        System.out.println(compressString("aaabb"));  // Output: "a3b2"
        System.out.println(compressString("abc"));    // Output: "a1b1c1"
        System.out.println(compressString(""));       // Output: ""

        // Decompression Tests
        System.out.println(decompressString("a3b2"));  // Output: "aaabb"
        System.out.println(decompressString("a1b1c1")); // Output: "abc"
        System.out.println(decompressString(""));       // Output: ""
    }
}
