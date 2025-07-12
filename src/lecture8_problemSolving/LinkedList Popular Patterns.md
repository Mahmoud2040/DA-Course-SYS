## 🧱 1. **Dummy Node Pattern** → (Most common for insertions and merging)

### ✅ Purpose:

* Avoids writing special logic for head initialization.
* Makes appending nodes clean and consistent.

### 🔧 Code Example:

```java
ListNode dummy = new ListNode(-1);
ListNode current = dummy;

while (list1 != null && list2 != null) {
    if (list1.val < list2.val) {
        current.next = list1;
        list1 = list1.next;
    } else {
        current.next = list2;
        list2 = list2.next;
    }
    current = current.next;
}

current.next = (list1 != null) ? list1 : list2;
return dummy.next;  // Head of merged list
```

### ✅ Used In:

* Merging two lists
* Removing duplicates
* Reversing a list
* Insertion

---

## 🐢 2. **Fast & Slow Pointers (Tortoise and Hare)**

### ✅ Purpose:

* Detect cycles
* Find middle node
* Remove Nth node from end
* Palindrome check

### 🔧 Code Example (Finding middle):

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
// `slow` is now the middle
```

---

## 🔁 3. **In-Place Reversal Pattern**

### ✅ Purpose:

* Reverse entire list or part of it (in-place, no extra memory)

### 🔧 Code Example:

```java
ListNode prev = null;
ListNode curr = head;

while (curr != null) {
    ListNode next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
}
// `prev` is new head
return prev;
```

---

## ♻️ 4. **Two-Pointer Merge Pattern**

### ✅ Purpose:

* Merge two sorted lists
* Interleave two lists
* Remove duplicates

### 🔧 Code Snippet (simplified):

```java
while (list1 != null && list2 != null) {
    if (list1.val < list2.val) {
        // add list1 node
    } else {
        // add list2 node
    }
}
```

---

## 🔁 5. **Recursion for Clean Solutions**

### ✅ Purpose:

* Clean and elegant solutions (for small inputs)
* Works well for problems like reversing a list or merging

### 🔧 Code Example (Merge two lists recursively):

```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    if (l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    } else {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}
```

> ⚠️ Note: Recursion can cause **stack overflow** if input is too large.

---

## 🧠 6. **Sentinel + Tail Pointer (for building new lists)**

### ✅ Purpose:

* When you're **building** a new list node-by-node

```java
ListNode dummy = new ListNode(-1);
ListNode tail = dummy;

for (int val : someArray) {
    tail.next = new ListNode(val);
    tail = tail.next;
}

return dummy.next;
```

---

## ✅ Summary Table

| Pattern                  | When to Use                                       |
| ------------------------ | ------------------------------------------------- |
| **Dummy Node**           | Merging, inserting, removing from head/middle     |
| **Fast & Slow Pointers** | Cycle detection, find middle, remove Nth from end |
| **In-Place Reversal**    | Reverse entire or part of the list                |
| **Two-Pointer Merge**    | Combine sorted lists                              |
| **Recursion**            | Elegant base-case logic (limited-size inputs)     |
| **Sentinel + Tail**      | Build new lists cleanly                           |
