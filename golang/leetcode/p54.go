package main

// 螺旋矩阵
// Link https://leetcode.cn/problems/spiral-matrix/
func spiralOrder(matrix [][]int) (res []int) {
	n := len(matrix)
	if n == 0 {
		return
	}
	m := len(matrix[0])
	dx, dy := []int{0, 1, 0, -1}, []int{1, 0, -1, 0}

	// 初始化一个二维数组
	st := make([][]bool, n)
	for i := 0; i < n; i++ {
		st[i] = make([]bool, m)
	}
	for i, x, y, d := 0, 0, 0, 0; i < n*m; i++ {
		res = append(res, matrix[x][y])
		st[x][y] = true

		a, b := x+dx[d], y+dy[d]
		if a < 0 || a >= n || b < 0 || b >= m || st[a][b] {
			d = (d + 1) % 4
			a, b = x+dx[d], y+dy[d]
		}

		x, y = a, b
	}
	return
}
