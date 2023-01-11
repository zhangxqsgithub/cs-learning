use std::io;

fn main() {
    func_demo();
}

fn guess_game() {
    println!("Guess the number!");

    println!("Please input your guess.");

    let _some: String = String::from("x");   // 不可被修改
    // new 是一个 String 结构体那定义的常量方法 pub const fn new() {...}
    // 访问常量方法仍需使用 :: 运算符
    let mut guess: String = String::new();  // 可被修改

    // :: 是某个包下访问某个自定义的方法，例如 std::io::stdin() 就是调用 io 包下的 stdin 静态
    // 方法，该方法返回一个 Stdin 对象。
    // .  是某个对象的实体，访问其内部定义的方法或变量
    io::stdin()
        .read_line(&mut guess)
        .expect("Failed to read line");
    
    println!("You guessed: {guess}");
}

fn func_demo() {
    func1();

    /*
    带有参数的方法
    调用 func2 方法时，param 参数被复制到 func2 方法定义的参数 x 上。
    param 参数和 func2 的接收参数之间，所有权互不影响（因为是两个值）
     */ 
    let param: i32 = 100;
    func2(param);
    println!("param: {}", param);

    // 传递两个参数的方法
    func3(1, 'h');

    // 语句（没有返回值）
    let a = 100;
    // 表达式（有返回值）
    let b = {
        let x = 100;
        a + x + 1
    };
    println!("{a}, {b}");

    /*
    有返回值的方法
    调用 five 后方法内返回值会复制出来，方法内的返回值就丢弃了（内存空间释放了）
     */
    let five = five();
    println!("{five}");

    println!("{}", plus_one(100));
}

fn func1() {
    println!("func1");
}

fn func2(x: i32) {
    println!("param: {}", x);
}

fn func3(val: i32, unit_label: char) {
    println!("The measurement is: {val}{unit_label}");
}

fn five() -> i32 {
    5
}

fn plus_one(x: i32) -> i32 {
    return x + 1;
}
