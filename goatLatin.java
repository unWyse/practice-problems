/*
You are given a string sentence that consist of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.) The rules of Goat Latin are as follows:

    If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
        For example, the word "apple" becomes "applema".
    If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
        For example, the word "goat" becomes "oatgma".
    Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
        For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.

Return the final sentence representing the conversion from sentence to Goat Latin.

Constraints:
    1 <= sentence.length <= 150
    sentence consists of English letters and spaces.
    sentence has no leading or trailing spaces.
    All the words in sentence are separated by a single space.
*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++){
            result += goatLatin(words[i]) + goatHelper(i+1);
        }
        return result.trim();
    }
    
    private String goatLatin(String s){
        Matcher matcher = Pattern.compile("^[aeiou]", Pattern.CASE_INSENSITIVE).matcher(s);
        if(matcher.find()){
            return s + "ma";
        }else{
            return s.substring(1, s.length()) + s.substring(0,1) + "ma";
        }
    }
    private String goatHelper(int a){
        String result = "";
        while (a > 0){
            result += "a";
            a--;
        }
        return result + " ";
    }
}
