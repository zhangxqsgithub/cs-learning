package main

import "math"

// 缺失的第一个正数
// Link https://leetcode.cn/problems/first-missing-positive/
func firstMissingPositive(nums []int) int {

	// 把所有的数放到 map 中
	mp := map[int]bool{}
	for _, v := range nums {
		mp[v] = true
	}

	// 从 1 开始依次遍历每个数，若遇到不存在的数则退出遍历，这个数就是第一个确实的正数
	res := 1
	for mp[res] {
		res++
	}

	return res
}

// 要求 O(n) 的时间复杂度 O(1) 的空间复杂度
func firstMissingPositive2(nums []int) int {
	n := len(nums)
	for i := 0; i < n; i++ {
		if nums[i] != math.MaxInt {
			nums[i]--
		}
	}
	for i := 0; i < n; i++ {
		// 0 <= nums[i] && nums[i] < n 因为结果在 (0, n] 所以这里我们用到的数组的下标应该是 [0, n)
		// nums[i] != i 要是 nums[i] 已经在第 i 个位置上了，那么就不用交换了
		// nums[i] != nums[nums[i]] 防止无限交换
		for 0 <= nums[i] && nums[i] < n && nums[i] != i && nums[i] != nums[nums[i]] {
			nums[i], nums[nums[i]] = nums[nums[i]], nums[i]
		}
	}
	for i := 0; i < n; i++ {
		if nums[i] != i {
			return i + 1
		}
	}
	return n + 1
}
