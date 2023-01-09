use std::io;

fn main() {
    println!("Guess the number!");

    println!("Please input your guess.");

    let some: String = String::from("x");   // 不可被修改
    let mut guess: String = String::new();  // 可被修改

    // :: 是某个包下访问某个自定义的方法，例如 std::io::stdin() 就是调用 io 包下的 stdin 静态
    // 方法，该方法返回一个 Stdin 对象。
    // .  是某个对象的实体，访问其内部定义的方法或变量
    io::stdin()
        .read_line(&mut guess)
        .expect("Failed to read line");
    
    println!("You guessed: {guess}");
}
