fn main() {
    let a = Droppable { name: "a" };
    {
        let b = Droppable { name: "b" };
        {
            let c = Droppable { name: "c" };
            let d = Droppable { name: "d" };
            println!("Exiting block B");
        }
        println!("Exiting block A");
    }
    // 主动丢弃 a
    drop(a);
    println!("Exiting main");
}

struct Droppable {
    name: &'static str,
}

// 当 c 和 d 被丢弃的时候，这个方法会触发
impl Drop for Droppable {
    fn drop(&mut self) {
        println!("Dropping {}", self.name);
    }
}

