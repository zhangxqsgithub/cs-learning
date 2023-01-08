fn main() {
    // 不用类型推断
    // let integer: Point<i32> = Point { x: 5, y: 10 };
    // let float: Point<f32> = Point { x: 1.0, y: 4.0 };
    // 类型推断
    let integer = Point { x: 5, y: 10 };
    let float = Point { x: 1.0, y: 4.0 };
    println!("{integer:?} and {float:?}");
}

#[derive(Debug)]
struct Point<T> {
    x: T,
    y: T,
}


