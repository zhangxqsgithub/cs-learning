package main

func generateMatrix(n int) [][]int {
	res := make([][]int, n)
	dx, dy := []int{0, 1, 0, -1}, []int{1, 0, -1, 0}
	c := 1
	// 标记是否访问过
	st := make([][]bool, n)
	for i := 0; i < n; i++ {
		st[i] = make([]bool, n)
	}
	for i, x, y, d := 0, 0, 0, 0; i < n*n; i++ {
		res[x][y] = c++
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
