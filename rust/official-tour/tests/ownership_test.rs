#[test]
fn scope_demo1() {
    // x 参数的范围仅且仅在声明这个参数外面第一个大括号（参数范围定义）到结束的大括号之内。
    // 不会在外部大括号内！
    let x = "Hello";

    {
        let y = "Rust";
        // 这里即可以访问到 x 又可以访问到 y
        println!("{x}, {y}!");
        // y 执行到这里就丢弃了
        // It remains valid until it goes out of scope.
        // 只有将值返回回去（跳出这个参数范围），值才会继续存活
    }

    println!("{x}");
}

#[test]
fn scope_demo2() {
    /*
    这里 num2 会完全复制 num1 的数据。
    num1 和 num2 两个参数都在这个参数范围内存在！（因为是基本数据类型，支持复制）
     */
    let num1 = 100;
    let num2 = num1;
    println!("{num1}, {num2}");

    /*
    这里 str2 并不会完全复制 str1 在堆中的数据，而是 str2 参数在栈中的指针指向在堆中存放字符串数据的地址。
    也就是说 str1 和 str2 都指向同一块内存地址。
    但是，Rust 会在当前这个空间范围结束后，释放掉内存，在释放 str1 和 str2 时会释放掉同一块内存空间，这会导致错误！
    所以，当参数类型不是基本数据类型时（即不支持直接复制），则仅保留最后最新的那个参数，即 str2。
    str1 在其后就不存在了。
     */
    let str1: String = String::from("xxx");
    let str2 = str1;
    // println!("{str1}"); // error!
    println!("{str2}");
}
