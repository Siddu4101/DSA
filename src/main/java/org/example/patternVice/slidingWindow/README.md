# 🪟 Sliding Window Pattern

## 📝 Overview

The sliding window technique is a two-pointer approach that efficiently processes contiguous subarrays or substrings by
maintaining a "window" of elements and sliding it across the data.

**Key Idea:** Instead of recalculating from scratch for each position, maintain a running calculation and update it
incrementally.

---

## 🎯 Problem: Maximum Sum of Subarray with K Elements

### 📌 Description

Given an array of integers and an integer `k`, find the maximum sum of any contiguous subarray of size `k`.

### 📊 Example

```
Input:  nums = [2, 1, 5, 1, 3, 2], k = 3
Output: 9  (subarray [5, 1, 3])

Input:  nums = [4, 2, 4, 5, 6], k = 4
Output: 19 (subarray [4, 5, 6, 4] or similar)
```

---

## 🔍 Approaches

### ❌ Approach 1: Brute Force

**Algorithm:**

1. Iterate through each possible starting position
2. For each position, calculate sum of k consecutive elements
3. Track maximum sum

**Complexity:**

- ⏱️ Time: **O(n × k)** - Recalculates sum for each window
- 💾 Space: **O(1)**

**Why it's slow:** Redundant recalculation of overlapping elements

---

### ✅ Approach 2: Optimized Sliding Window

**Algorithm:**

1. Calculate sum of first k elements
2. Slide the window by 1 position:
    - Subtract the leftmost element (leaving the window)
    - Add the new rightmost element (entering the window)
3. Update maximum sum as you slide

**Complexity:**

- ⏱️ Time: **O(n)** - Single pass with constant operations
- 💾 Space: **O(1)**

**Why it's better:** Only 2 operations per slide instead of recalculating k sums

---

## 📈 Visual Example

```
Array: [4, 2, 4, 5, 6], k = 4

Window 1: [4, 2, 4, 5] → sum = 15
          ^ Remove this

Window 2:    [2, 4, 5, 6] → sum = 15 - 4 + 6 = 17
             ^ Add this

Max Sum: 17
```

---

## 💡 When to Use

- Maximum/minimum sum of subarray of fixed size
- Longest substring with conditions
- Average of subarrays of size k
- Number of unique elements in window
- Any problem involving contiguous elements with fixed or variable window size

