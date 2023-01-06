// 类型推断
fn main() {
    // 把 x 类型推断为 u32
    let x = 10;
    // 把 y 类型推断为 i8
    let y = 20;

    takes_u32(x);
    takes_i8(y);
    // takes_u32(y);
}

fn takes_u32(x: u32) {
    println!("u32: {x}");
}

fn takes_i8(y: i8) {
    println!("i8: {y}");
}

