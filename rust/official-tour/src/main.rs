use std::io;

fn main() {
    println!("Guess the number!");

    println!("Please input your guess.");

    let some: String = String::from("x");   // 不可被修改
    let mut guess: String = String::new(); // 可被修改

    io::stdin()
        .read_line(&mut guess)
        .expect("Failed to read line");

    println!("You guessed: {guess}");
}
