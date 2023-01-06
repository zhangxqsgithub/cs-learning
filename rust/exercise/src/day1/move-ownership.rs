fn main() {

    let a = String::from("Hello!");
    println!("{a}");

    // a 把所有权交给 b 了
    let b = a;
    println!("{b}");
    // a 这里失去了所有权，所以这里会报错！
    // println!("{}", a);
}