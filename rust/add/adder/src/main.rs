use add_one::add_one;

// 定义一个 module 名字为 garden1
mod garden1;
mod garden2;
mod garden3;

mod garden1 {

}

fn main() {
    println!("Hello, world!");

    let num = 10;
    println!("{}", add_one(num));
}
