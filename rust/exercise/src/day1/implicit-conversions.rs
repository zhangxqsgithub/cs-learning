fn main() {
    let x: i8 = 15;
    let y: i16 = 1000;

    // implicit conversion 隐式转换
    // 这里会报错，rust 并不会隐式转换！
    // println!("{x} * {y} = {}", multiply(x, y));
    
    // 这两个方式都可以显示地转换
    // println!("{x} * {y} = {}", multiply(i16::from(x), y));
    println!("{x} * {y} = {}", multiply(x.into(), y));
}

fn multiply(x: i16, y: i16) -> i16 {
    x * y
}