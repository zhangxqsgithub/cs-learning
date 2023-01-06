fn main() {

    let a = String::from("Hello!");
    println!("{a}");

    // a 把所有权交给 b 了
    let b = a;
    println!("{b}");
    // a 这里失去了所有权，所以这里会报错！
    // println!("{}", a);

    // 始终只有一个变量绑定了拥有的值！

    let name: String = String::from("Zail");
    say_hello(name);
    // 这里会编译出错，因为 name 的所有权已经交给上一个调用方法里了！
    // say_hello(name);

    // 这个例子是 Copy，特定的类型是通过拷贝来赋值的，并不是交出所有权
    // These types implement the Copy trait.
    let x = 42;
    let y = x;
    println!("x: {x}");
    println!("y: {y}");
    let i1: f32 = 10.1;
    let i2 = i1;
    println!("{i1}");
    println!("{i2}");

    // 拷贝的例子： 注意 p2 的值没有改变
    let mut p1 = Point(3, 4);
    let mut p2 = p1;
    println!("p1: {:?}", p1);
    println!("p2: {:?}", p2);
    p1.0 = 100;
    p1.1 = 100;
    println!("p1: {:?}", p1);
    println!("p2: {:?}", p2);

    let p3: P2D = P2D{x: 1, y: 23};
    println!("{p3:?}");
}

// You can opt-in your own types to use copy semantics:
// 你可以选择性地加入到你自己定义的类型中（始终拷贝语义的值）
#[derive(Copy, Clone, Debug)]
struct Point(i32, i32);

#[derive(Copy, Clone, Debug)]
struct P2D{
    x: i32,
    y: i32,
}

fn say_hello(name: String) {
    println!("Hello {name}!");
}
