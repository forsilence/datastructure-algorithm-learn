package com.learn.algorithms.leetcode.medium;

/**
给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-image
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class Rotate {

	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for(int row = 0; row < n / 2; row++) {
			for(int col = 0; col < (n + 1) / 2; col++){
				int temp = matrix[col][n - row - 1];
				matrix[col][n - row - 1] = matrix[row][col];
				matrix[row][col] = matrix[n - col - 1][row];
				matrix[n - col - 1][row] = matrix[n - row - 1][n - col - 1];
				matrix[n - row - 1][n - col - 1] = temp;
			}
		}
	}
}
