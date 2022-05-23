/*
There are n rings and each ring is either red, green, or blue. The rings are distributed across ten 
rods labeled from 0 to 9.

You are given a string rings of length 2n that describes the n rings that are placed onto the rods. 
Every two characters in rings forms a color-position pair that is used to describe each ring where:

    The first character of the ith pair denotes the ith ring's color ('R', 'G', 'B').
    The second character of the ith pair denotes the rod that the ith ring is placed on ('0' to '9').

For example, "R3G2B1" describes n == 3 rings: a red ring placed onto the rod labeled 3, a green ring 
placed onto the rod labeled 2, and a blue ring placed onto the rod labeled 1.

Return the number of rods that have all three colors of rings on them.

Constraints:
    rings.length == 2 * n
    1 <= n <= 100
    rings[i] where i is even is either 'R', 'G', or 'B' (0-indexed).
    rings[i] where i is odd is a digit from '0' to '9' (0-indexed).
*/
class Solution {
  //this solution is over-engineered because it counts the total of each color ring on each rod, where it need only confirm it exists
    public int countPoints(String rings) {
        Map<Integer,Map<Character,Integer>> rods = new HashMap<Integer,Map<Character,Integer>>();
        char color;
        int rod;
        for(int i = 0; i < rings.length(); i += 2) {
            color = rings.charAt(i);
            rod = rings.charAt(i+1)-48;
            //if this rod not in map, add it and then add the (color,1) pair
            if(rods.get(rod) == null) {
                rods.put(rod, new HashMap<Character,Integer>());
                rods.get(rod).put(color,1);
            }
            //otherwise increase the count of this color ring in the map
            else {
                //if color not exists on this rod then add the (color,1) pair
                if(rods.get(rod).get(color) == null) {
                    rods.get(rod).put(color,1);
                } 
                //otherwise simply update the count
                else {
                    rods.get(rod).put(color, rods.get(rod).get(color)+1);
                }
            }
        }
        int count = 0;
        for(int set : rods.keySet()) {
            if(rods.get(set).get('R') != null && rods.get(set).get('G') != null && rods.get(set).get('B') != null) count++;
        }
        return count;
    }
}
