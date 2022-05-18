/*
There is a robot starting at the position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this 
robot ends up at (0, 0) after it completes its moves.

You are given a string moves that represents the move sequence of the robot where moves[i] represents its ith move. Valid 
moves are 'R' (right), 'L' (left), 'U' (up), and 'D' (down).

Return true if the robot returns to the origin after it finishes all of its moves, or false otherwise.

Note: The way that the robot is "facing" is irrelevant. 'R' will always make the robot move to the right once, 'L' will 
always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.

Constraints:
    1 <= moves.length <= 2 * 10^4
    moves only contains the characters 'U', 'D', 'L' and 'R'.
*/
class Solution {
    public boolean judgeCircle(String moves) {
      //making use of some java 8 functionality here
        if (moves.chars().filter(ch -> ch == 'U').count() != moves.chars().filter(ch -> ch == 'D').count()) return false;
        if (moves.chars().filter(ch -> ch == 'R').count() != moves.chars().filter(ch -> ch == 'L').count()) return false;
        return true;
    }
}
