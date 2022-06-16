/*
You are given row x col grid representing a map where grid[i][j] = 1 represents land 
and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is 
completely surrounded by water, and there is exactly one island (i.e., one or more 
connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water 
around the island. One cell is a square with side length 1. The grid is rectangular, 
width and height don't exceed 100. Determine the perimeter of the island.

Constraints:
    row == grid.length
    col == grid[i].length
    1 <= row, col <= 100
    grid[i][j] is 0 or 1.
    There is exactly one island in grid.
*/
class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    //for each "land square"
                    perimeter += countWater(grid, i, j);
                }
            }
        }
        return perimeter;
    }
    
    private int countWater(int[][] grid, int i, int j){
        // given grid and coords
        // returns count of adjacent zeros and edges
        int result = 0;
        //check (grid[i-1,j])
        if(i-1<0 || grid[i-1][j]==0){
            result++;
        }
        //check (grid[i,j-1])
        if(j-1<0 || grid[i][j-1]==0){
            result++;
        }
        //check (grid[i+1,j])
        if(i+1>=grid.length || grid[i+1][j]==0){
            result++;
        }
        //check (grid[i,j+1])
        if(j+1>=grid[i].length || grid[i][j+1]==0){
            result++;
        }
        return result;
    }
}
