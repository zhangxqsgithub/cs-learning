use crate::garden::vegetables::Asparagus;
use crate::a::b::add;

pub mod garden;
/*
    1. mod xxx {}
    2. 文件 garden.rs 就是一个 module
    3. garden/mod.rs 也是一个 module

    module 在 rust 中的应用：
        1. 在 main.rs 中声明一个 mod，语法：`pub mod xxx;`
        2. 创建文件夹 xxx，并且在文件夹内创建 mod.rs 文件
 */
pub mod a;

fn main() {
    println!("Hello, world!");

    let a: Asparagus = Asparagus {};
    println!("{a:?}");

    println!("{}", add(1, 2));
}
