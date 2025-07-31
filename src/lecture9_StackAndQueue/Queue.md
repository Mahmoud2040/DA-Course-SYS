#  Queue in Java – Full Guide

##  1. What is a Queue? Why Do We Need It? What Are Its Operations?

###  Definition:

A **Queue** is a **linear data structure** that follows the **FIFO** (First In, First Out) principle.
This means the **first** element added is the **first** to be removed.

> Think of a **queue of people** waiting in line — the first person in line is served first.

###  Core Operations:

| Operation    | Description                             | Java method name (Queue Interface) |
| ------------ | --------------------------------------- | ---------------------------------- |
| `enqueue(x)` | Add an element at the rear              | `add()` / `offer()`                |
| `dequeue()`  | Remove the element from the front       | `remove()` / `poll()`              |
| `peek()`     | View the front element without removing | `peek()` / `element()`             |
| `isEmpty()`  | Check if queue is empty                 | `isEmpty()`                        |
| `size()`     | Get the current number of elements      | `size()`                           |

---

##  2. Queue Based on Array vs. LinkedList

###  Queue Using Array:

* Uses an array (fixed-size or circular buffer).
* Fast random access, but difficult to maintain `front` and `rear` properly.
* Risk of wasted space unless using **circular queue**.

```java
// Basic idea of circular queue using array
int[] queue = new int[5];
int front = 0, rear = 0;
```

### 🔗 Queue Using LinkedList:

* Dynamic size — no wasted space.
* Each node points to the next.
* Insertion at **tail**, deletion from **head** is O(1).

---

###  Comparison:

| Feature            | Array-Based Queue  | LinkedList-Based Queue |
| ------------------ | ------------------ | ---------------------- |
| Size Limitation    | Fixed or resizable | Dynamic                |
| Insertion/Deletion | May need shifting  | O(1) at both ends      |
| Memory Usage       | Less overhead      | More (pointers)        |
| Use Cases          | Lightweight, fast  | Flexible, dynamic      |

---

##  3. Singly vs. Doubly LinkedList for Queue

###  Recommendation:

Use **Singly Linked List with tail pointer**:

* Insert at `tail` (enqueue)
* Remove from `head` (dequeue)
* **No need for doubly linked list**, since traversal backward is not required.

### Summary:

| Criteria           | Singly Linked List | Doubly Linked List |
| ------------------ | ------------------ | ------------------ |
| Overhead           | ✅ Low              | ❌ Higher           |
| Bidirectional?     | ❌ No               | ✅ Yes (not needed) |
| Suitable for Queue | ✅ Yes              | ❌ Overkill         |

---

##  4. Real-World Use Cases of Queue

| Use Case                     | Description                       |
| ---------------------------- | --------------------------------- |
| Print queues                 | Documents waiting to print.       |
| OS scheduling                | Round-robin process queues.       |
| Customer service systems     | First-come-first-served support.  |
| Messaging systems (RabbitMQ) | Message delivery order.           |
| Level-order tree traversal   | BFS in trees and graphs.          |
| Streaming/buffering          | Smooth handling of incoming data. |

---

##  5. Best Java Implementation of a Queue (Singly Linked List)

```java
public class Queue<T> {
    private Node<T> head, tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    public void enqueue(T data) {
        Node<T> node = new Node<>(data);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        T data = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
}
```

### Example usage:

```java
public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        System.out.println(queue.dequeue()); // A
        System.out.println(queue.peek());    // B
        System.out.println(queue.size());    // 2
    }
}
```

---

## 💡 Extra Tips

* Java built-in interface: `java.util.Queue<T>` with implementations like:

    * `LinkedList<>`
    * `ArrayDeque<>` (recommended over `LinkedList` for performance)

```java
Queue<Integer> queue = new LinkedList<>();
queue.add(1);
queue.remove();
queue.peek();
```

* For thread-safe queues: use `ConcurrentLinkedQueue` or `BlockingQueue`.

---

## ⚖️ Stack vs. Queue Summary

| Feature      | Stack (LIFO)     | Queue (FIFO)          |
| ------------ | ---------------- | --------------------- |
| Insertion    | Top              | Rear                  |
| Removal      | Top              | Front                 |
| Use Cases    | Undo, recursion  | Scheduling, messaging |
| Java Support | `Stack`, `Deque` | `Queue`, `Deque`      |
                                                   