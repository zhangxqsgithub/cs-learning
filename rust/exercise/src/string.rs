fn main() {
    // &str an immutable reference to a string slice.
    let s1: &str = "Hello";
    println!("s1: {}", s1);

    // String a mutable string buffer.
    let mut s2: String = String::from("Hello ");
    println!("s2: {}", s2);
    s2.push_str(s1);
    println!("s2: {}", s2);
}