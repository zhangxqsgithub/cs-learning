package main

// 缺失的第一个正数
// Link https://leetcode.cn/problems/first-missing-positive/
func firstMissingPositive(nums []int) int {

	// 把所有的数放到 map 中
	mp := make(map[int]bool)
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
