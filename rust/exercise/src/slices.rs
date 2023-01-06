fn main() {
    let mut a: [i32; 10] = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    println!("a: {:?}", a);
    a[3] = 100;
    println!("a: {:?}", a);

    // 声明一个切片
    let s: &[i32] = &a[2..4];
    println!("s: {:?}", s);
}