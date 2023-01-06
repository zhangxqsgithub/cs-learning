fn main() {
    let p1: Point = Point(10, 10);
    let p2: Point = Point(20, 20);  // Put into different scope
    let p3: &Point = left_most(&p1, &p2);
    println!("left-most point: {:?}", p3);
}

#[derive(Debug)]
struct Point(i32, i32);

// Lifetimes in Function Calls
// 可以在 fn 中定义生命周期
// In addition to borrowing its arguments, a function can return a borrowed value:
// 'a is a generic parameter, it is inferred by the compiler.
// 'a 是范型参数
// Lifetimes start with ' and 'a is a typical default name.
// 生命周期 开始的特殊字符是 ' 而 'a 是默认名称
// Read &'a Point as “a borrowed Point which is valid for at least the lifetime a”.
// The at least part is important when parameters are in different scopes.
fn left_most<'a>(p1: &'a Point, p2: &'a Point) -> &'a Point {
    if p1.0 < p2.0 { p1 } else { p2 }
}
