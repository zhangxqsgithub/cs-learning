#[test]
fn test_iter() {
    let mut vec: Vec<i32> = Vec::new();
    vec.push(1);
    vec.push(2);
    // 这个 min_by_key 返回 Option 类型的值
    let min = vec.iter().min_by_key(|v| v.abs());
    println!("{min:?}");
}