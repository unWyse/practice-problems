public class Solution {
    public string LongestPalindrome(string s) {

        string longest = "";
        for(int i = 0; i < s.Length; i++){
            
            string newString = ExpandSelection(i, 1, s);

            if (newString.Length > longest.Length){
                longest = newString;
            }
        }

        return longest;

    }

    private string ExpandSelection(int start, int len, string s){
        
        if( start > 0 && start+len < s.Length && IsPal(s.Substring(start-1,len+2)) ){
            return ExpandSelection(start-1, len+2, s);
        }
        else if ( start >= 0 && start+len < s.Length && IsPal(s.Substring(start,len+1)) ){
            return ExpandSelection(start, len+1, s);
        }
        else 
        {
            return s.Substring(start, len);
        }

    }

    private bool IsPal(string subStr){
        
        int startIndex = 0;
        int endIndex = subStr.Length - 1;

        while (startIndex < endIndex) {
            if (subStr[startIndex] != subStr[endIndex])
                return false;
            startIndex++;
            endIndex--;
        }

        return true;

    }
}
