fn main() {
    let f = Foo(1, 2, 3, 4);
    println!("{} {} {} {}", f.0, f.1, f.2, f.3);

    let force = compute_thruster_force();
    // expected struct `Newtons`, found struct `PoundOfForce`
    set_thruster_force(force);
}

struct Foo(i32, i32, usize, usize);

struct PoundOfForce(f64);
struct Newtons(f64);

fn compute_thruster_force() -> PoundOfForce {
    todo!("Ask a rocket scientist at NASA")
}

fn set_thruster_force(force: Newtons) {

}
