fn main() {
    let a = Centimeter(10);
    let b = Centimeter(20);
    println!("{a:?} equals {b:?}: {}", a.eq(&b));
    println!("{a:?} not equals {b:?}: {}", a.ne(&b));
}

trait Equals {
    fn eq(&self, other: &Self) -> bool;
    fn ne(&self, other: &Self) -> bool {
        !self.eq(other)
    }
}

#[derive(Debug)]
struct Centimeter(i16);

impl Equals for Centimeter {
    fn eq(&self, other: &Self) -> bool {
        self.0 == other.0
    }
}
