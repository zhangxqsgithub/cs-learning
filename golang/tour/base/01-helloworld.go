// 运行的文件必须是 package main
package main

// 导入其他的包
import "fmt"

// main 函数
func main() {
	// 打印 Hello World!
	fmt.Println("Hello World!")

	s := fmt.Sprint(11, 10)
	fmt.Println(s)

	s += "aaa"
	fmt.Println(s)

	rs := []rune(s)
	fmt.Println(rs[1])
}
