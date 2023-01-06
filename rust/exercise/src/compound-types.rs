fn main() {
    // 声明数组
    let mut a: [i8; 10] = [0; 10];
    a[5] = 12;
    println!("a: {:?}", a);

    // 声明元组
    let t: (i8, bool, i32) = (7, true, 3232);
    println!("1st index: {}", t.0);
    println!("2st index: {}", t.1);
    println!("3st index: {}", t.2);
}