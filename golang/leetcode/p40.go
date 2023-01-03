package main

import "sort"

// 组合总和 II
// Link https://leetcode.cn/problems/combination-sum-ii/
func combinationSum2(c []int, target int) [][]int {
	res, path := [][]int{}, make([]int, 0, len(c))
	// 标记使用元素的下标
	used := make([]bool, len(c))
	// 先排序
	sort.Ints(c)
	var dfs func(c []int, start int, target int)
	dfs = func(c []int, start int, target int) {
		if target == 0 { // target 不断减小，如果为0说明达到了目标值
			tmp := make([]int, len(path))
			copy(tmp, path)
			res = append(res, tmp)
			return
		}
		for i := start; i < len(c); i++ {
			if c[i] > target { // 剪枝，提前返回
				break
			}
			// used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
			// used[i - 1] == false，说明同一树层candidates[i - 1]使用过
			if i > 0 && c[i] == c[i-1] && used[i-1] == false {
				continue
			}
			path = append(path, c[i])
			used[i] = true
			dfs(c, i+1, target-c[i])
			used[i] = false
			path = path[:len(path)-1]
		}
	}
	dfs(c, 0, target)
	return res
}
