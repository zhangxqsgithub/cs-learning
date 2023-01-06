fn main() {
    let arr1 = [1, 2, 3];
    println!("arr1: {:?}", arr1);

    // N 个元素
    const N: usize = 10;
    // 初始化时 x 作为默认值
    let x: i32 = 99;
    let arr2: [i32; N] = [x; N];
    println!("arr2: {:?}", arr2);

    // 直接用值的方式初始化
    let arr3: [i32; 10] = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    println!("arr3: {:?}", arr3);


    let matrix = [
        [101, 102, 103], // <-- the comment makes rustfmt add a newline
        [201, 202, 203],
        [301, 302, 303],
    ];

    println!("matrix:");
    pretty_print(&matrix);

    let transposed = transpose(matrix);
    println!("transposed:");
    pretty_print(&transposed);
}

fn transpose(matrix: [[i32; 3]; 3]) -> [[i32; 3]; 3] {
    let res = [
        [101, 201, 301],
        [102, 202, 302],
        [103, 203, 303],
    ];
    return res;
}

fn pretty_print(matrix: &[[i32; 3]; 3]) {
    for i in 0..3 {
        for j in 0..3 {
            print!("{} ", matrix[i][j]);
        }
        println!();
    }
}
