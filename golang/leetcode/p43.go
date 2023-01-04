package main

import (
	"fmt"
)

func main() {
	multiply("123", "456")
}

// 字符串相乘
// Link https://leetcode.cn/problems/multiply-strings/
func multiply(num1 string, num2 string) string {
	m, n := len(num1), len(num2)
	a := make([]int, m+n)
	for i := m - 1; i >= 0; i-- {
		for j := n - 1; j >= 0; j-- {
			a[i+j+1] += int(num1[i]-'0') * int(num2[j]-'0')
		}
	}
	fmt.Println(a)
	for i := n - 1; i > 0; i-- {
		numi := a[i]
		if numi >= 10 {
			carry := numi / 10
			a[i] = numi % 10
			a[i-1] += carry
		}
	}
	fmt.Println(a)
	return ""
}
