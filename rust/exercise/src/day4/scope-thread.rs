use std::thread;

fn main() {
    let s = String::from("Hello");

    // 创建的新线程 借用当前的上下文
    thread::scope(|scope| {
        scope.spawn(|| {
            println!("Length: {}", s.len());
        });
    });
}