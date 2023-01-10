fn main() {
    let string1 = String::from("abcd");
    let string2 = "xyz";

    let result = longest(string1.as_str(), string2);
    println!("The longest string is {}", result);
}

// 生命周期的声明方式和范型一样 <'a>
// 范型 <T>
// 结合 <'a T>
fn longest<'a>(str1: &'a str, str2: &'a str) -> &'a str {
    if str1.len() >= str2.len() { str1 } else { str2 }
}
