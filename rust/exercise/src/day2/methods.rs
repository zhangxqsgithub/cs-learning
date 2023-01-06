fn main() {
    let peter = Person {
        name: String::from("Peter"),
        age: 27,
    };
    peter.say_hello();

    peter.bazooka();
}

struct Person {
    name: String,
    age: u8,
}

impl Person {
    fn say_hello(&self) {
        println!("Hello, my name is {}", self.name);
    }

    fn bazooka(&self) {
        println!("Say hello to my little friend! {} {}", self.name, self.age);
    }
}
