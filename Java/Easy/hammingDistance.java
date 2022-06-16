/*
The Hamming distance between two integers is the number of positions at which the 
corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.

Constraints:
    0 <= x, y <= 2^31 - 1
*/
class Solution {
    public int hammingDistance(int x, int y) {
        //convert both to binary
        char[] xBin = Integer.toBinaryString(x).toCharArray();
        char[] yBin = Integer.toBinaryString(y).toCharArray();
        
        //reduce repeated code by always putting greater number first
        if(x >= y) return hamming(xBin, yBin);
        return hamming(yBin, xBin);
    }
    
    private int hamming(char[] greater, char[] lesser){
        int hamming = 0;
        
        int offset = Math.abs(greater.length - lesser.length);
        
        //check extra bits in longer array, count 1s and add to hamming
        for (int i = 0; i < offset; i++) {
            if(greater[i] == '1') hamming++;
        }
        
        //use offset to compare remaining bits
        for (int i = 0; i < lesser.length; i++) {
            if (greater[i+offset] != lesser[i]) hamming++;
        }
        
        
        return hamming;
        
    } 
}

//class Solution {
//    public int hammingDistance(int x, int y) {
//         //convert both to binary
//         char[] xBin = Integer.toBinaryString(x).toCharArray();
//         char[] yBin = Integer.toBinaryString(y).toCharArray();
        
//         //comare binary - count number of differences 
//         int hamming = 0;
        
//         int offset = Math.abs(xBin.length - yBin.length);
//         if(x >= y) {
//             //check extra bits in longer array, count 1s and add to hamming
//             for (int i = 0; i < offset; i++) {
//                 if(xBin[i] == '1') hamming++;
//             }
//             //use offset to compare remaining bits
//             for (int i = 0; i < yBin.length; i++) {
//                 if (xBin[i+offset] != yBin[i]) hamming++;
//             }
//         }
//         else{
//             //check extra bits in longer array, count 1s and add to hamming
//             for (int i = 0; i < offset; i++) {
//                 if(yBin[i] == '1') hamming++;
//             }
//             //use offset to compare remaining bits
//             for (int i = 0; i < xBin.length; i++) {
//                 if (yBin[i+offset] != xBin[i]) hamming++;
//             }
//         }
        
//         return hamming;
//    }
//}
