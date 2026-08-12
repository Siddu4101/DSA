# 🪟 Sliding Window Pattern

# 🪟 Sliding Window Patterns

Three common patterns to recognize in array/string problems:

## 1️⃣ Fixed-Length Window

**Window size = `k`**

Use when the problem asks about **every contiguous subarray/substring of exactly `k` elements**.

**Examples:**

* Maximum sum of `k` elements
* Average of every `k` elements
* Maximum/minimum in a window

```text
[1 2 3] 4 5
  [2 3 4] 5
    [3 4 5]
```

⏱️ Usually **O(n)** instead of O(n × k).

---

## 2️⃣ Fixed-Length + Distinct Element Count

**Window size = `k` + track unique elements**

Use when the problem asks for **exactly `k` elements with a condition on distinct/unique elements**.

**Examples:**

* Count subarrays of size `k` having exactly `x` distinct elements
* Maximum sum among windows of size `k` containing distinct elements

Typical data structure:

```java
Map<Integer, Integer> freq = new HashMap<>();
```

💡 Add incoming element → remove outgoing element → maintain distinct count.

⏱️ **O(n)** average.

---

## 3️⃣ Dynamic-Length Sliding Window

**Window size changes dynamically**

Use when you need the **longest/shortest contiguous subarray/substring satisfying a condition**.

**Examples:**

* Longest substring without repeating characters
* Smallest subarray with sum ≥ `k`
* Longest subarray with at most `k` distinct elements

```text
left → [ valid window ........ ] ← right
         ↓ condition breaks
         move left →
```

💡 Expand `right` → if condition breaks, move `left` until valid again.

⏱️ Usually **O(n)** because both pointers move forward.

---

## 🧠 Quick Recognition

| Pattern                 | When to Use                                         |
|-------------------------|-----------------------------------------------------|
| 🔒 **Fixed Length**     | Window is explicitly `k`                            |
| 🔒 **Fixed + Distinct** | Window is `k` + unique/count condition              |
| 🔄 **Dynamic Length**   | Find longest/shortest window satisfying a condition |

### ⭐ Rule of Thumb

> **`k` given → Fixed Window**
> **`k` + distinct → Fixed Window + Frequency Map**
> **Longest/Shortest + condition → Dynamic Window**
