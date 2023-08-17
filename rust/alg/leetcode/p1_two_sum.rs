use std::collections::HashMap;

struct Solution {}

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        // 创建一个HashMap，长度为nums的长度
        let mut map = HashMap::with_capacity(nums.len());

        // 遍历nums，如果target减去nums中的每一个元素等于target，则将其和为i的元素放入map中
        for i in 0..nums.len() {
            if let Some(k) = map.get(&(target - nums[i])) {
                // 如果k不等于i，则返回k和i的值
                if *k!= i {
                    return vec![*k as i32, i as i32];
                }
            }
            // 否则将nums[i]和i放入map中
            map.insert(nums[i], i);
        }

        // 如果map中没有找到，则抛出异常
        panic!("not found");
    }
}

fn main() {}
