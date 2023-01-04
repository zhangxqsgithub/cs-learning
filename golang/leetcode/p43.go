package main

import (
	"fmt"
	"strconv"
)

func main() {
	res := multiply("123", "456")
	fmt.Println(res)
}

// 字符串相乘
// Link https://leetcode.cn/problems/multiply-strings/
func multiply(num1 string, num2 string) string {
	if num1 == "0" || num2 == "0" {
		return "0"
	}
	m, n := len(num1), len(num2)
	a := make([]int, m+n)
	for i := m - 1; i >= 0; i-- {
		for j := n - 1; j >= 0; j-- {
			a[i+j+1] += int(num1[i]-'0') * int(num2[j]-'0')
		}
	}
	// fmt.Println(a)
	for i := len(a) - 1; i > 0; i-- {
		if a[i] >= 10 {
			carry := a[i] / 10
			a[i] = a[i] % 10
			a[i-1] += carry
		}
	}
	// fmt.Println(a)
	res := ""
	idx := 0
	if a[0] == 0 {
		idx = 1
	}
	for ; idx < len(a); idx++ {
		res += strconv.Itoa(a[idx])
	}
	return res
}
