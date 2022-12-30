package main

func combinationSum(c []int, target int) [][]int {
	ans := [][]int{}
	path := []int{}
	var dfs func(c []int, u int, target int)
	dfs = func(c []int, u int, target int) {
		if target == 0 {
			ans = append(ans, path)
			return
		}
		// 如果已经枚举完最后一个数，仍然没有凑够 target 的话，则当前分支无解
		if u == len(c) {
			return
		}
		for i := 0; c[u]*i <= target; i++ {
			dfs(c, u+1, target-c[u]*i)
			path = append(path, c[u])
		}
		// 恢复现场
		for i := 0; c[u]*i <= target; i++ {
			path = path[0 : len(path)-1]
		}
	}
	dfs(c, 0, target)
	return ans
}

func combinationSum2(c []int, target int) (ans [][]int) {
	comb := []int{}
	var dfs func(target, idx int)
	dfs = func(target, idx int) {
		if idx == len(c) {
			return
		}
		if target == 0 {
			ans = append(ans, append([]int(nil), comb...))
			return
		}
		// 直接跳过
		dfs(target, idx+1)
		// 选择当前数
		if target-c[idx] >= 0 {
			comb = append(comb, c[idx])
			dfs(target-c[idx], idx)
			comb = comb[:len(comb)-1]
		}
	}
	dfs(target, 0)
	return
}
