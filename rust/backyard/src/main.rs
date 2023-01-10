use crate::garden::vegetables::Asparagus;

pub mod garden;
/*
    1. mod xxx {}
    2. 文件 garden.rs 就是一个 module
    3. garden/mod.rs 也是一个 module
 */

fn main() {
    println!("Hello, world!");

    let a: Asparagus = Asparagus {};
    println!("{a:?}");
}
