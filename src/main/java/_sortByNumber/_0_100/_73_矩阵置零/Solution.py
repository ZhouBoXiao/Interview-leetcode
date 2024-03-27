
'''
给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
'''
from typing import List


class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        row = len(matrix)
        col = len(matrix[0])
        zero_first = [False, False]
        for i in range(row):
            if matrix[i][0] == 0:
                zero_first[0] = True
                break
        for i in range(col):
            if matrix[0][i] == 0:
                zero_first[1] = True
                break
        for i in range(1, row):
            for j in range(1, col):
                if matrix[i][j] == 0:
                    matrix[i][0] = matrix[0][j] = 0
        for i in range(1, row):
            for j in range(1, col):
                if matrix[i][0] == 0 or matrix[0][j] == 0:
                    matrix[i][j] = 0
        if zero_first[0]:
            for i in range(row):
                matrix[i][0] = 0
        if zero_first[1]:
            for i in range(col):
                matrix[0][i] = 0
