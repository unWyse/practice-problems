/*
An image smoother is a filter of the size 3 x 3 that can be applied to each cell 
of an image by rounding down the average of the cell and the eight surrounding 
cells (i.e., the average of the nine cells in the blue smoother). If one or more 
of the surrounding cells of a cell is not present, we do not consider it in the 
average (i.e., the average of the four cells in the red smoother).

Given an m x n integer matrix img representing the grayscale of an image, return 
the image after applying the smoother on each cell of it.

Constraints:
    m == img.length
    n == img[i].length
    1 <= m, n <= 200
    0 <= img[i][j] <= 255
*/
class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] ans = new int[img.length][img[0].length];
        
        int sum;
        int count;
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                sum = img[i][j];
                count = 1;
                //RT
                if (i-1 >= 0 && j-1 >= 0) {
                    sum += img[i-1][j-1];
                    count++;
                }
                //RC
                if (i-1 >= 0) {
                    sum += img[i-1][j];
                    count++;
                }
                //RB
                if (i-1 >= 0 && j+1 < img[0].length) {
                    sum += img[i-1][j+1];
                    count++;
                }
                //CT
                if (j-1 >= 0) {
                    sum += img[i][j-1];
                    count++;
                }
                //skip self
                //CB
                if (j+1 < img[0].length) {
                    sum += img[i][j+1];
                    count++;
                }
                //LT
                if (i+1 < img.length && j-1 >= 0) {
                    sum += img[i+1][j-1];
                    count++;
                }
                //LC
                if (i+1 < img.length) {
                    sum += img[i+1][j];
                    count++;
                }
                //LB
                if (i+1 < img.length && j+1 < img[0].length) {
                    sum += img[i+1][j+1];
                    count++;
                }
                
                ans[i][j] = sum/count;
            }
        }
        return ans;
    }
}
