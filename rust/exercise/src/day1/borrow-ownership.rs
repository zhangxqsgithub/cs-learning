fn main() {
    let p1 = Point(3, 4);
    let p2 = Point(10, 20);
    // The add function borrows two points and returns a new point.
    // 穿两个指针进入 add 方法，p1 和 p2 仍拥有变量的所有权
    let p3 = add(&p1, &p2);
    // The caller retains ownership of the inputs.
    println!("{p1:?} + {p2:?} = {p3:?}");
}

#[derive(Debug)]
struct Point(i32, i32);

fn add(p1: &Point, p2: &Point) -> Point {
    Point(p1.0 + p2.0, p1.1 + p2.1)
}