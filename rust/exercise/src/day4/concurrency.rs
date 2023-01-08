use std::thread;
use std::time::Duration;

fn main() {
    // 生成一个新的线程
    thread::spawn(|| {
        for i in 1..10 {
            println!("Count in thread: {i}!");
            thread::sleep(Duration::from_millis(5));
        }
    });

    for i in 1..5 {
        println!("Main thread: {i}");
        thread::sleep(Duration::from_millis(5));
    }

    thread::sleep(Duration::from_millis(100));
}