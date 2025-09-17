##  **The Problem: Why Do We Need Hashing?**

### **Performance Review: What We Already Know**

| Data Structure | Search Time | Insert Time | Delete Time | Best Use Case |
|----------------|-------------|-------------|-------------|---------------|
| **Array** | O(n) | O(1) at end, O(n) at beginning/middle | O(n) | Fixed-size, index-based access |
| **ArrayList** | O(n) | O(1) at end*, O(n) at beginning/middle | O(n) | Dynamic size, index-based access |
| **LinkedList** | O(n) | O(1) with reference | O(1) with reference | Frequent insertions/deletions |
| **Stack** | N/A for search | O(1) | O(1) | LIFO operations only |
| **Queue** | N/A for search | O(1) | O(1) | FIFO operations only |

### **The Search Problem**
Consider this scenario: You have a database with 10,000 students, and you need to look up a student's information by their ID.

```java
// Using ArrayList - Linear Search
public Student findStudent(ArrayList<Student> students, String studentID) {
    for (int i = 0; i < students.size(); i++) {
        if (students.get(i).getID().equals(studentID)) {
            return students.get(i);  // Found!
        }
    }
    return null;  // Not found
}
// Time Complexity: O(n) - might check all 10,000 students!
```

**What if we could search in O(1) time instead?** This is where hashing comes in!

---

## 🏗 **What is Hashing?**

### **Basic Concept**
- Hashing is a technique that uses a **hash function** to map data directly to a storage location, allowing for near-instant access.


- Hashing is a fundamental computer science technique where we take some input data (of any size) and transform it into a fixed-size value (called a hash). This process is done by a hash function.
```
Data → Hash Function → Hash Code → Array Index → Direct Access
```

### **Real-World Analogy: Library System**

**Traditional Method (Linear Search):**
- Look for "To Kill a Mockingbird"
- Start with first book, check each one until found
- Worst case: Check all 100,000 books

**Hashing Method:**
- Book title → Hash function → Specific shelf number
- Go directly to that shelf
- Time: O(1) - constant time!

### **Another Analogy: School Lockers**
Instead of checking every locker to find yours:
- Student ID 123456 → Hash function → 123456 % 500 = 456
- Your locker is always #456
- Same calculation every time = same locker

---

## ⚙️ **How Hash Functions Work**

### **Basic Hash Function Example**
```java
// Simple hash function for strings
public static int simpleHash(String key) {
    int sum = 0;
    for (int i = 0; i < key.length(); i++) {
        sum += key.charAt(i);  // Add ASCII values
    }
    return sum;
}

// Example:
// "Bob" → B(66) + o(111) + b(98) = 275
// 275 % 10 = 5 → Store at index 5
```

### **Visual Example: Hash Table**
```
Hash Table (Array of size 10):
[0] [  ] [  ] [  ] [  ] [Bob] [  ] [  ] [  ] [  ]
 0   1    2    3    4     5     6    7    8    9

To find "Bob":
1. Calculate: hash("Bob") = 275
2. Get index: 275 % 10 = 5  
3. Look at index 5 → Found Bob!
```

### **Key Properties of Good Hash Functions**

#### **1. Deterministic**
- Same input always produces same output
- Essential for finding data again!

```java
String name = "Alice";
System.out.println(name.hashCode()); // Always same number
System.out.println(name.hashCode()); // Same number again
```

#### **2. Uniform Distribution**
- Spreads data evenly across the hash table
- Prevents clustering in one area

```
Bad Distribution:        Good Distribution:
[All data here][ ][ ]    [Data][Data][ ][Data][ ][Data]
```

#### **3. Fast Computation**
- Hash function itself must be O(1)
- Otherwise we lose the speed advantage

#### **4. Avalanche Effect**
- Small input change causes big output change
- Prevents similar keys from clustering

```java
System.out.println("Alice".hashCode());  // e.g., 63171864
System.out.println("Blice".hashCode()); // Very different number
```

---

## 🔧 **Java Implementation**

### **Using Built-in Hash Functions**
```java
public class HashExample {
    public static void main(String[] args) {
        // String hashing
        String str1 = "Hello";
        String str2 = "World";
        
        System.out.println("Hash of 'Hello': " + str1.hashCode());
        System.out.println("Hash of 'World': " + str2.hashCode());
        
        // Convert to array index
        int tableSize = 10;
        int index1 = Math.abs(str1.hashCode()) % tableSize;
        int index2 = Math.abs(str2.hashCode()) % tableSize;
        
        System.out.println("'Hello' goes to index: " + index1);
        System.out.println("'World' goes to index: " + index2);
    }
}
```

**Important Notes:**
- `Math.abs()` handles negative hash codes
- `% tableSize` fits any hash code into our array size
- Different data types have different hash functions

---

##  **Collision Handling**

### **What is a Collision?**
When two different keys hash to the same index:

```java
"John".hashCode() % 10 = 7
"Jane".hashCode() % 10 = 7  // Same index - Collision!
```

**Collisions are normal and expected!** Good hash tables handle them efficiently.

### **Solution 1: Chaining**
Each array slot holds a LinkedList of items:

```
Hash Table with Chaining:
[0] [ ]
[1] [ ]
...
[7] → [John] → [Jane] → null
[8] [ ]
[9] [ ]
```

### **Solution 2: Open Addressing (Linear Probing , Quadratic Probing , Double Hashing)**
for example Linear Probing If slot is occupied, try the next slot:

```
1. Add John: hash = 7, slot 7 is empty → put John at index 7
2. Add Jane: hash = 7, slot 7 occupied → try slot 8 → put Jane at index 8

[0] [ ]
...
[7] [John]
[8] [Jane] 
[9] [ ]
```
---

##  **Advantages and Disadvantages**

### ** Advantages**

#### **1. Speed**
- **Average case**: O(1) for search, insert, delete
- **Real impact**: Difference between instant and waiting

#### **2. Scalability**
- Performance doesn't degrade much as size increases
- 1,000 items vs 1,000,000 items - still O(1)

#### **3. Flexibility**
- Dynamic sizing (like ArrayList)
- Can store any type of data

#### **4. Practical**
- Built into most programming languages
- Widely used in industry

### ** Disadvantages**

#### **1. Memory Overhead**
- Typically only 70% - 75% full (load factor) 100 = 75 item  76 item = 200
- Wasted space to avoid collisions

#### **2. No Ordering**
- Data isn't stored in any particular sequence
- Can't easily get "next" or "previous" item

#### **3. Worst Case Performance**
- Can degrade to O(n) if hash function is poor
- All items hash to same location

#### **4. Implementation Complexity**
- More complex than arrays
- Need to handle collisions properly

---

##  **Real-World Applications**

### **1. Database Indexing**


### **2. Password Storage (cryptographic hash functions )**

### **3. Caching Systems**
```
Browser cache: 
URL "https://example.com" → hash → cache location
If page exists in cache → load instantly
If not → download and cache
```

### **4. Compiler Symbol Tables**
```java
int x = 5;        // Compiler: variable "x" → hash → memory location
String name;      // Compiler: variable "name" → hash → memory location

// Later when you use 'x':
x = x + 1;        // Compiler uses hash to find x's location instantly
```

---
## **Scenario Analysis:**

**Scenario 1**: "You need to display student grades in alphabetical order"
- **Hash Table**: ❌ No inherent ordering, would need to sort after retrieval
- **ArrayList**: ✅ Can sort easily, maintains order
- **Best choice**: ArrayList or TreeMap (later topic)

**Scenario 2**: "You need the 5 highest scores in a game"
- **Hash Table**: ❌ Would need to check all entries
- **ArrayList**: ✅ Can sort and take top 5
- **Best choice**: Priority Queue or sorted structure

**Scenario 3**: "Memory is very limited"
- **Hash Table**: ❌ Needs extra space (load factor)
- **Array**: ✅ No waste, exact fit
- **Best choice**: Array if size known

**Scenario 4**: "Lookups by name in contact list"
- **Hash Table**: ✅ Instant lookup
- **ArrayList**: ❌ Slow search through thousands
- **Best choice**: HashMap

##  **Coming Next: HashMap and HashSet**

Now that you understand hashing, you're ready for Java's implementations!

### **HashSet Preview**
```java
// Uses hashing internally for O(1) operations
HashSet<String> students = new HashSet<>();
students.add("Alice");           // O(1) - uses hashing!
students.add("Bob");             // O(1) - uses hashing!
boolean hasAlice = students.contains("Alice"); // O(1) - uses hashing!

// Compare to ArrayList:
ArrayList<String> studentList = new ArrayList<>();
studentList.add("Alice");       // O(1)
studentList.add("Bob");         // O(1) 
boolean hasAlice = studentList.contains("Alice"); // O(n) - linear search!
```

### **HashMap Preview**
```java
// Store key-value pairs with O(1) access
HashMap<String, Integer> grades = new HashMap<>();
grades.put("Alice", 95);        // O(1) - uses hashing on "Alice"!
grades.put("Bob", 87);          // O(1) - uses hashing on "Bob"!
int aliceGrade = grades.get("Alice"); // O(1) - uses hashing on "Alice"!
```

---

##  **Practice Questions**

### **Conceptual Questions**
1. Why is O(1) search time so valuable in real applications?
2. What's the main trade-off when using hash-based data structures?
3. Give an example where you'd prefer ArrayList over HashSet.
4. What happens if a hash function always returns the same number?

### **Code Analysis**
```java
// What's the time complexity of this operation?
HashSet<String> names = new HashSet<>();
for (int i = 0; i < 1000; i++) {
    names.add("Student" + i);
}
boolean found = names.contains("Student500");
```




### **Design Questions**
1. You're building a phone contacts app. Which data structure would you use for storing contacts if users frequently search by name?

2. You need to store student grades where you frequently need to:
    - Look up a student's grade by ID
    - Display all students in alphabetical order
      Which data structure would you choose and why?

---

##  **Key Takeaways**

1. **Hashing enables O(1) average-case performance** for search, insert, and delete operations

2. **Hash functions map data to array indices** using mathematical calculations

3. **Collisions are normal** and can be handled through chaining or open addressing

4. **Trade-offs exist**: Speed vs Memory, Speed vs Ordering

5. **Hash tables are everywhere** - databases, caches, password systems, compilers

6. **Understanding hashing prepares you** for HashMap, HashSet, and other advanced data structures

---