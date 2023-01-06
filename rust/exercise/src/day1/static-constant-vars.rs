const DIGEST_SIZE: usize = 5;
const ZERO: Option<u8> = Some(42);

fn main() {
    let digest = compute_digest("Hello");
    println!("Digest: {:?}", digest);
}

fn compute_digest(text: &str) -> [u8; DIGEST_SIZE] {
    let mut digest: [u8; DIGEST_SIZE] = [ZERO.unwrap_or(0); DIGEST_SIZE];
    for (idx, &b) in text.as_bytes().iter().enumerate() {
        digest[idx % DIGEST_SIZE] = digest[idx % DIGEST_SIZE].wrapping_add(b);
    }
    return digest;
}