from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        n = len(nums)
        k %= n
        nums[:] = nums[::-1]
        nums[:k] = nums[:k][::-1]
        nums[k:] = nums[k:][::-1]

        # nums[:]=nums[n-k:]+nums[:n-k]

        for _ in range(k):
            nums.insert(0, nums.pop())


s = Solution()
s.rotate([1,2,3,4,5,6,7], 3)