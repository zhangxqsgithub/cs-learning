use std::fmt::Display;

fn main() {
    // 不用类型推断
    // let integer: Point<i32> = Point { x: 5, y: 10 };
    // let float: Point<f32> = Point { x: 1.0, y: 4.0 };
    // 类型推断
    let integer = Point { x: 5, y: 10 };
    let float = Point { x: 1.0, y: 4.0 };
    println!("{integer:?} and {float:?}");

    let p = Point{x: 5, y: 10};
    println!("p.x = {}, p.y = {}", p.x(), p.y());

    let foo = String::from("foo");
    let pair = duplicate(foo);
    println!("{pair:?}");
    
    // 声明 Vector 数组，范型为 Box 的并实现了 Display
    let xs: Vec<Box<dyn Display>> = vec![Box::new(123), Box::new("Hello")];
    for x in xs {
        println!("x: {x}");
    }
}

#[derive(Debug)]
struct Point<T> {
    x: T,
    y: T,
}

// 定义范型的方法实现
impl<T> Point<T> {
    fn x(&self) -> &T {
        &self.x
    }
    fn y(&self) -> &T {
        &self.y
    }
}

// 限制范型 T 必须实现 Clone
fn duplicate<T: Clone>(a: T) -> (T, T) {
    (a.clone(), a.clone())
}
