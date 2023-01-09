fn main() {
    let s1 = String::from("hello");

    // 将 s1 的引用传递进方法内
    let len = calculate_length(&s1);

    println!("The length of '{}' is {}.", s1, len);
}

/*
向该方法传递的 str 是一个引用类型，调用时并不会占用参数的所有权。
这个动作叫借用 borrowing。
 */
fn calculate_length(s: &String) -> usize { // s is a reference to a String
    s.len()
} // Here, s goes out of scope. But because it does not have ownership of what
  // it refers to, it is not dropped.