fn main() {
    let mut v1: Vec<i32> = Vec::new();
    v1.push(100);
    println!("v1: len = {}, capacity = {}", v1.len(), v1.capacity());

    let mut v2 = Vec::new();
    v2.push(42);
    println!("v2: len = {}, capacity = {}", v2.len(), v2.capacity());

    let mut v3: Vec<i32> = Vec::with_capacity(v1.len() + 1);
    v3.extend(v1.iter());
    v3.push(9999);
    println!("v3: len = {}, capacity = {}", v3.len(), v3.capacity());
}