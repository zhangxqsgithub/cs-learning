package main

func nextPermutation(nums []int) {
	if len(nums) <= 1 {
		return
	}

	i, j, k := len(nums)-2, len(nums)-1, len(nums)-1

	// find: A[i]<A[j]
	for i >= 0 && nums[i] >= nums[j] {
		i--
		j--
	}

	if i >= 0 { // 不是最后一个排列
		// find: A[i]<A[k]
		for nums[i] >= nums[k] {
			k--
		}
		// swap A[i], A[k]
		nums[i], nums[k] = nums[k], nums[i]
	}

	// reverse A[j:end]
	for i, j := j, len(nums)-1; i < j; i, j = i+1, j-1 {
		nums[i], nums[j] = nums[j], nums[i]
	}
}

func nextPermutation2(nums []int) {
	if len(nums) <= 1 {
		return
	}

	// 首先从尾部向前找到降序的起始位置
	k := len(nums) - 1
	for k > 0 && nums[k-1] >= nums[k] {
		k--
	}

	// 整个序列都是降序的（特殊情况）
	if k <= 0 {
		// reverse nums[]
		for i, j := 0, len(nums)-1; i < j; i, j = i+1, j-1 {
			nums[i], nums[j] = nums[j], nums[i]
		}
		return
	}

	// 找到后面降序序列中，比 nums[k] 大的最小数
	// （nums[t] 是第一个 <= 当前数的数， nums[t - 1] 是最后一个大于当前数的数）
	t := k
	for t < len(nums) && nums[t] > nums[k-1] {
		t++
	}
	nums[t-1], nums[k-1] = nums[k-1], nums[t-1]
	// reverse nums[k:]
	for i, j := k, len(nums)-1; i < j; i, j = i+1, j-1 {
		nums[i], nums[j] = nums[j], nums[i]
	}
}
