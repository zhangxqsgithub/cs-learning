fn main() {
    // rust 也是有指针的
    let mut x: i32 = 10;
    let ref_x: &mut i32 = &mut x;
    *ref_x = 200;
    println!("x = {}", x);
}