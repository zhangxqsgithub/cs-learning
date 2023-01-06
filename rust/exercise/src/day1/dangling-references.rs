fn main() {
    // 悬挂指针
    let ref_x: &i32;
    {
        let x: i32 = 10;
        ref_x = &x;
    }
    println!("ref_x = {ref_x}");
}