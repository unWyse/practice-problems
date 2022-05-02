/*
Given two binary strings a and b, return their sum as a binary string.

Constraints:
    1 <= a.length, b.length <= 10^4
    a and b consist only of '0' or '1' characters.
    Each string does not contain leading zeros except for the zero itself.
*/
class Solution {
    public String addBinary(String a, String b) {
        char[] result = new char[Integer.max(a.length(),b.length())+1];
        
        int i  = result.length;
        int aP = a.length();
        int bP = b.length();
        
        char carry = '0';
        while(aP > 0 && bP > 0){
            i--; aP--; bP--;
            if(a.charAt(aP)=='1' && b.charAt(bP)=='1'){
                result[i] = carry;
                carry = '1';
            }else if(a.charAt(aP)=='1' || b.charAt(bP)=='1'){
                if(carry=='1'){
                    result[i] = '0';
                    //carry = '1';
                }else{
                    result[i] = '1';
                    carry = '0';
                }
            }else{
                result[i] = carry;
                carry = '0';
            }
        }
        while(aP > 0){
            i--; aP--;
            if(a.charAt(aP)=='1'){
                if(carry=='1'){
                    result[i] = '0';
                    //carry = '1';
                }else{
                    result[i] = '1';
                    carry = '0';
                }
            }else{
                result[i] = carry;
                carry = '0';
            }
        }
        while(bP > 0){
            i--; bP--;
            if(b.charAt(bP)=='1'){
                if(carry=='1'){
                    result[i] = '0';
                    //carry = '1';
                }else{
                    result[i] = '1';
                    carry = '0';
                }
            }else{
                result[i] = carry;
                carry = '0';
            }
        }
        
        
        if (carry == '1') result[0] = '1';
        return new String(result).trim();
    }
}
