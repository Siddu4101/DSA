# Two-Pointer Approach

Use:

- one pointer at the start (`left`)
- one pointer at the end (`right`)

Then move one (or both) pointers inward depending on the problem condition.

## Algorithm

1. Initialize `left = 0` and `right = n - 1`.
2. While `left < right`:
    - evaluate the current condition
    - move `left` to the right, `right` to the left, or both
3. Stop when pointers meet or cross.

## When to Use

- Sorted array pair problems (sum/target checks)
- Reversing arrays or strings
- Removing duplicates in-place
- Palindrome checks

## Time & Space Complexity

- **Time:** `O(n)`
- **Space:** `O(1)` (in-place)

## Template

```text
left = 0
right = n - 1

while left < right:
    if condition:
        left += 1
    else:
        right -= 1
```
