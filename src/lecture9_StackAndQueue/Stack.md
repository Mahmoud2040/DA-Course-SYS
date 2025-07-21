##  1. What is a Stack? Why Do We Need It? What Are Its Operations?

###  Definition:

A **Stack** is a **linear data structure** that follows the **LIFO** (Last In, First Out) principle.
This means the **last** element added to the stack is the **first** one to be removed.

###  Real-Life Analogy:

Think of a **stack of plates** — you always take the top plate first and add new ones on the top.

###  Core Operations:

| Operation   | Description                       | Java method name |
| ----------- | --------------------------------- | ---------------- |
| `push(x)`   | Add item `x` on the top           | `push()`         |
| `pop()`     | Remove and return the top element | `pop()`          |
| `peek()`    | Return the top without removing   | `peek()`         |
| `isEmpty()` | Check if the stack is empty       | `isEmpty()`      |
| `size()`    | Return number of elements         | `size()`         |

---

##  2. Stack Based on Array vs. LinkedList

###  Stack Using Array:

* Uses fixed-size or dynamic arrays (like `ArrayList`).
* **Fast index access**.
* May need **resizing** when the stack grows.

```java
// Stack with array
int[] stack = new int[100];
int top = -1;

void push(int val) {
    stack[++top] = val;
}

int pop() {
    return stack[top--];
}
```

###  Stack Using LinkedList:

* Grows dynamically (no need to resize).
* More **memory overhead** due to node pointers.
* Easy insertion/removal at head.

```java
class Node {
    int data;
    Node next;
}
```

| Feature         | Array-Based Stack | LinkedList-Based Stack |
| --------------- | ----------------- | ---------------------- |
| Size Limitation | Fixed / Resizable | Dynamic                |
| Speed           | Faster indexing   | Slower indexing        |
| Memory Usage    | Less              | More (extra node refs) |
| Insert/Delete   | O(1) at top       | O(1) at head           |

---

##  3. Singly vs Doubly LinkedList for Stack

###  Recommendation:

* Use **Singly Linked List**.
* Stack only needs **insertion/removal from one end (top)**.
* **Doubly Linked List** introduces unnecessary overhead (extra pointer to previous node).

### Summary:

| Criteria    | Singly Linked List | Doubly Linked List |
| ----------- | ----------------- | ---------------- |
| Simplicity  |  Simple           |  More complex    |
| Overhead    |  Less             |  More (extra ref) |
| Suitability |  Perfect for stack |  Overkill        |

---

##  4. Real-World Use Cases of Stack

| Use Case                           | Description                                                     |
| ---------------------------------- | --------------------------------------------------------------- |
| Undo/Redo functionality            | Text editors or drawing tools.                                  |
| Expression parsing                 | Evaluating mathematical expressions (infix → postfix → result). |
| Syntax checking                    | Matching parentheses `{ [ ( ] ) }`.                             |
| Function call management           | Function calls and recursion (call stack).                      |
| Browser history                    | Back/Forward navigation.                                        |
| Depth-First Search (DFS) traversal | Graph/tree algorithms.                                          |

---

##  5. Best Java Implementation of a Stack (Using LinkedList)

Here’s a clean and simple **generic stack implementation** using a singly linked list:

```java
public class Stack<T> {
    private Node<T> top;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    public void push(T data) {
        Node<T> node = new Node<>(data);
        node.next = top;
        top = node;
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
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
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());  // 30
        System.out.println(stack.peek()); // 20
        System.out.println(stack.size()); // 2
    }
}
```

---

##  Extra Tips

* Java provides a built-in `Stack` class via `java.util.Stack<T>` (which extends `Vector`, not preferred in modern Java).
* Better alternative: use `Deque<T>` as stack:

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(10);
stack.pop();
stack.peek();
```
