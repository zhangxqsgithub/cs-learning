fn main() {
    let a: i32 = 10;
    println!("before: {a}");

    {
        let a = "hello";
        println!("inner scope: {a}");
        
        let a = true;
        println!("shadowed in inner scope: {a}");
    }
    
    let a: i32 = 99;
    println!("after: {a}");
}