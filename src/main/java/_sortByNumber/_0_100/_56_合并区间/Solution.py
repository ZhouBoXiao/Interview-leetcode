from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals = sorted(intervals, key=lambda x: x[0])
        temp = intervals[0]
        ans = []
        for ls in intervals[1:]:
            if temp[1] >= ls[0]:
                temp = [temp[0], max(temp[1], ls[1])]
            else:
                ans.append(temp)
                temp = ls

        ans.append(temp)
        return ans

