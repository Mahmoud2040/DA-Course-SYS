# Java String Revision Notes

---

## 1. String Initialization

Java provides two ways to initialize a string:

```java
String s1 = "Ali";             // Uses string literal (recommended)
String s2 = new String("Ali"); // Uses new keyword (not recommended unless needed)
```

---

## 2. Difference Between `=` and `new` Keyword

| Feature     | `String s = "Ali";`  | `String s = new String("Ali");` |
| ----------- | -------------------- | ------------------------------- |
| Memory      | String Pool          | Heap (new object)               |
| Performance | More efficient       | Less efficient                  |
| Use Case    | Common and preferred | Rare use (e.g., testing)        |

**Example:**

```java
String a = "Ali";
String b = "Ali";
String c = new String("Ali");

System.out.println(a == b);      // true (same reference from pool)
System.out.println(a == c);      // false (different memory)
System.out.println(a.equals(c)); // true (same content)
```

---

## 3. How Strings Are Stored in Memory

* String literals are stored in a special memory area called the **String Pool**.
* When a string literal like `"Ali"` is used multiple times, Java reuses the same reference from the pool.
* Using `new String("Ali")` creates a new object in the heap, even if the same value exists in the pool.

---

## 4. String Immutability

A string is **immutable**, meaning once a `String` object is created, its value cannot be changed. Any operation that seems to modify a string actually creates a new string object.

**Example:**

```java
String name = "Ali";
name = name + " Ahmed"; // Creates a new string "Ali Ahmed"
```

**Advantages of Immutability:**

1. **Security** – Strings used in passwords, file paths, and configurations cannot be modified.
2. **Thread Safety** – Strings can be shared across threads without synchronization.
3. **Memory Optimization** – Enables safe and efficient reuse via the String Pool.
4. **Hashcode Caching** – Useful for efficient usage in hash-based collections like `HashMap` or `HashSet`.

---

## 5. Treating Strings Like Arrays

Although strings are not arrays, they can be accessed like arrays using `.charAt(index)` and converted to arrays using `.toCharArray()`.

**Examples:**

```java
String name = "Ali";

// Access character by index
System.out.println(name.charAt(0)); // Outputs: 'A'

// Convert to character array
char[] chars = name.toCharArray();
System.out.println(chars[1]); // Outputs: 'l'

// Loop through string characters
for (int i = 0; i < name.length(); i++) {
    System.out.print(name.charAt(i) + " "); // Outputs: A l i
}
```
---

## 6. String Comparison Methods

Java provides multiple ways to compare strings. Each method serves a different purpose.

---

### 6.1. `==` Operator (Reference Comparison)

**Purpose:**
Compares whether **two string references point to the same memory location**.

**Example:**

```java
String a = "Ali";
String b = "Ali";
String c = new String("Ali");

System.out.println(a == b); // true (same object in String pool)
System.out.println(a == c); // false (different object in heap)
```

**When to Use:**
Rarely — only when you explicitly want to check if two variables refer to the **same object in memory**.

---

### 6.2. `.equals()` Method (Content Comparison)

**Purpose:**
Compares the **actual content (characters)** of two strings.

**Example:**

```java
String a = "Ali";
String b = new String("Ali");

System.out.println(a.equals(b)); // true
```

**When to Use:**
Always use `.equals()` when checking **logical equality** between string values.

---

### 6.3. `.equalsIgnoreCase()` Method

**Purpose:**
Compares strings while **ignoring case sensitivity**.

**Example:**

```java
String a = "ALI";
String b = "ali";

System.out.println(a.equalsIgnoreCase(b)); // true
```

**When to Use:**
When case does not matter (e.g., comparing user inputs, usernames, etc.).

---

### 6.4. `.compareTo()` and `.compareToIgnoreCase()` (Lexicographical Comparison)

**Purpose:**
Compares strings based on **dictionary order** (Unicode values).

* Returns `0` if equal
* Returns negative if first string is smaller
* Returns positive if first string is larger

**Example:**

```java
String a = "Ali";
String b = "Ahmed";

System.out.println(a.compareTo(b)); // > 0 (since "Ali" > "Ahmed")
System.out.println("apple".compareTo("banana")); // Negative (because 'a' < 'b')
System.out.println("banana".compareTo("apple")); // Positive
System.out.println(a.compareToIgnoreCase(b)); // > 0, ignoring case
```

**When to Use:**
- Useful in sorting, ordering, and comparisons that require lexicographical evaluation.
- To sort or compare strings lexicographically (like dictionary order).
- To check if a string comes before or after another string alphabetically.
- In searches, sorting algorithms, and data structures (like TreeSet, TreeMap).
- When you want case-sensitive comparison.
- To implement custom sorting (for example, sorting a list of names, words, or even product codes).

---

## Best Practices (According to Modern Java)

| Task                                       | Recommended Method                 |
| ------------------------------------------ | ---------------------------------- |
| Check if two strings have the same content | `str1.equals(str2)`                |
| Check content ignoring case                | `str1.equalsIgnoreCase(str2)`      |
| Compare for sorting (case-sensitive)       | `str1.compareTo(str2)`             |
| Compare for sorting (case-insensitive)     | `str1.compareToIgnoreCase(str2)`   |
| Check if same object (memory reference)    | `str1 == str2` (only if necessary) |

**Avoid using `==`** for content comparison — it can lead to unpredictable results, especially when dealing with dynamic strings (e.g., user input, file input, etc.).

---

## **7. Commonly Used String Methods**

Java provides many built-in methods in the `String` class to help manipulate and process strings efficiently. Below are some of the most frequently used ones, grouped by usage:

---

### **7.1. Basic Information and Character Access**

#### `length()`

Returns the number of characters in the string.

```java
String name = "Ali Ahmed";
System.out.println(name.length()); // Outputs: 9
```

**Use Case:** Checking password length in a login form.

```java
String password = userInput.getPassword();
if (password.length() < 8) {
    System.out.println("Password must be at least 8 characters.");
}
```

#### `charAt(int index)`

Returns the character at the specified index (0-based).

```java
System.out.println(name.charAt(0)); // Outputs: 'A'
```
**Use Case:** Check if the first character of a username is a capital letter.

```java
String username = "Ali123";
if (Character.isUpperCase(username.charAt(0))) {
    System.out.println("Valid: Starts with capital letter.");
}
```
---

###  **7.2. Extracting Parts of a String**

#### `substring(int beginIndex)`

Returns the substring from the given start index to the end of the string.

```java
String name = "Ali Ahmed";
System.out.println(name.substring(4)); // Outputs: "Ahmed"
```

#### `substring(int beginIndex, int endIndex)`

Returns a substring between the given indexes (endIndex is exclusive).

```java
String name = "Ali Ahmed";
System.out.println(name.substring(0, 3)); // Outputs: "Ali"
```
**Use Case:** Extracting file extension from a filename.

```java
String fileName = "report.pdf";
String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
System.out.println("File extension: " + extension); // Outputs: pdf
```


---

### **7.3. Searching in Strings**

#### `indexOf(String str)`

Returns the index of the first occurrence of the specified substring. Returns `-1` if not found.

```java
String name = "Ali Ahmed";
System.out.println(name.indexOf("A")); // Outputs: 0
System.out.println(name.indexOf("Ahmed")); // Outputs: 4
```

#### `lastIndexOf(String str)`

Returns the index of the last occurrence of the specified substring.

```java
String text = "java and javascript";
System.out.println(text.lastIndexOf("java")); // Outputs: 10
```
**Use Case:** Validating if an email contains `@` symbol in the correct place.

```java
String email = "john.doe@example.com";
if (email.indexOf('@') > 0 && email.lastIndexOf('.') > email.indexOf('@')) {
    System.out.println("Valid email");
}
```

#### `contains(CharSequence s)`

Returns `true` if the string contains the specified sequence.

```java
String name = "Ali Ahmed";
System.out.println(name.contains("Ali")); // true
System.out.println(name.contains("Zain")); // false
```
**Use Case:** Check if a product description includes a keyword.

```java
String description = "This laptop has 16GB RAM and SSD storage.";
if (description.toLowerCase().contains("ssd")) {
    System.out.println("This product includes SSD.");
}
```
---

###  **7.4. Replacing and Modifying Strings**

#### `replace(CharSequence target, CharSequence replacement)`

Replaces all occurrences of a target sequence with another.

```java
String sentence = "I love Java. Java is powerful.";
System.out.println(sentence.replace("Java", "Python"));
// Outputs: I love Python. Python is powerful.
```
**Use Case:** Censoring inappropriate words from user comments.

```java
String comment = "This is a bad product!";
String cleaned = comment.replace("bad", "***");
System.out.println(cleaned); // Outputs: This is a *** product!
```

---

### **7.5. Splitting Strings**

#### `split(String regex)`

Splits the string around matches of the given regular expression and returns a string array.

```java
String csv = "Ali,Ahmed,Karim";
String[] names = csv.split(",");
System.out.println(Arrays.toString(names)); // Outputs: [Ali, Ahmed, Karim]
```
**Use Case:** Parsing CSV data from a file.

```java
String line = "Ali,Ahmed,25,Pakistan";
String[] data = line.split(",");
System.out.println("Name: " + data[0] + " " + data[1]);
```

---

### **7.6. Checking String Start/End**

#### `startsWith(String prefix)`

Checks if the string starts with the specified prefix.

```java
String name = "Ali Ahmed";
System.out.println(name.startsWith("Ali")); // true
```
**Use Case (startsWith):** Check if a phone number starts with a specific country code.

```java
String phone = "+923331234567";
if (phone.startsWith("+92")) {
    System.out.println("Pakistani number");
}
```

#### `endsWith(String suffix)`

Checks if the string ends with the specified suffix.

```java
String name = "Ali Ahmed";
System.out.println(name.endsWith("Ahmed")); // true
```

**Use Case (endsWith):** Check if a file is a `.jpg` image.

```java
String file = "image.jpg";
if (file.endsWith(".jpg")) {
    System.out.println("This is a JPEG image.");
}
```
---

### **7.7. Case and Whitespace Handling**

#### `toLowerCase()` / `toUpperCase()`

Converts the entire string to lowercase or uppercase.

```java
System.out.println(name.toLowerCase()); // "ali ahmed"
System.out.println(name.toUpperCase()); // "ALI AHMED"
```
**Use Case:** Case-insensitive login comparison.

```java
String inputEmail = "USER@Example.COM";
String storedEmail = "user@example.com";

if (inputEmail.toLowerCase().equals(storedEmail.toLowerCase())) {
    System.out.println("Email match");
}
```
#### `trim()`

Removes leading and trailing whitespace.

```java
String messy = "   Hello   ";
System.out.println(messy.trim()); // "Hello"
```

**Use Case:** Cleaning up user input in a registration form.

```java
String name = "   Ali Ahmed   ";
System.out.println("Welcome, " + name.trim()); // Removes extra spaces
```

---

###  When to Use These Methods

| Task                             | Method                                     |
| -------------------------------- | ------------------------------------------ |
| Check length                     | `length()`                                 |
| Access character by index        | `charAt(index)`                            |
| Extract substring                | `substring()`                              |
| Search for a substring           | `indexOf()`, `lastIndexOf()`, `contains()` |
| Replace content                  | `replace()`                                |
| Split a string into parts        | `split()`                                  |
| Remove extra spaces              | `trim()`                                   |
| Check beginning or end of string | `startsWith()`, `endsWith()`               |
| Change letter case               | `toLowerCase()`, `toUpperCase()`           |

---


## **8. StringBuilder and StringBuffer in Java**

In Java, `String` is **immutable**, meaning once created, its value cannot be changed. If you need to modify a string frequently (e.g., in loops or concatenations), using `StringBuilder` or `StringBuffer` is much more efficient.

---

### **8.1. StringBuilder**

`StringBuilder` is a **mutable** sequence of characters, designed for better performance in **single-threaded** environments.

#### Syntax Example:

```java
StringBuilder sb = new StringBuilder("Ali");
sb.append(" Ahmed");
System.out.println(sb); // Outputs: Ali Ahmed
```

#### Real Use Case:

**Building a JSON string or HTML document dynamically in a loop**

```java
StringBuilder json = new StringBuilder();
json.append("{");
json.append("\"name\":\"Ali\",");
json.append("\"age\":25");
json.append("}");

System.out.println(json.toString()); 
// Outputs: {"name":"Ali","age":25}
```

This approach avoids creating many intermediate `String` objects.

---

### **8.2. StringBuffer**

`StringBuffer` is almost the same as `StringBuilder` but it is **thread-safe**. It synchronizes its methods, making it safe to use in **multi-threaded** environments.

#### Syntax Example:

```java
StringBuffer sb = new StringBuffer("Hello");
sb.append(" World");
System.out.println(sb); // Outputs: Hello World
```

#### Real Use Case:

**Creating a log string from multiple threads**

```java
public class LogBuilder {
    private static StringBuffer logBuffer = new StringBuffer();

    public static void log(String message) {
        logBuffer.append(Thread.currentThread().getName())
                 .append(": ")
                 .append(message)
                 .append("\n");
    }
}
```

In this case, multiple threads can safely write to `logBuffer`.

---

### **8.3. Differences Between String, StringBuilder, and StringBuffer**

| Feature        | String          | StringBuilder | StringBuffer        |
| -------------- | --------------- | ------------- | ------------------- |
| Mutability     | Immutable       | Mutable       | Mutable             |
| Thread Safe    | Yes (immutable) | No            | Yes (synchronized)  |
| Performance    | Slow (in loops) | Fast          | Slower than Builder |
| Use in Threads | Safe by nature  | Not safe      | Safe                |

#### Real Use Case Comparison:

* Use `String` for **constant or rarely modified data** like configuration keys or labels.
* Use `StringBuilder` for **building strings in loops** such as file parsing, reports, or SQL query generation.
* Use `StringBuffer` when **multiple threads** update a common string (e.g., live chat log, multi-threaded report generator).

---

### **8.4. Useful Methods in StringBuilder and StringBuffer**

#### `append()`: Adds text to the end.

```java
sb.append(" Ahmed");
```

#### Real Use Case:

Concatenating multiple lines from a file:

```java
BufferedReader reader = new BufferedReader(new FileReader("notes.txt"));
String line;
StringBuilder text = new StringBuilder();

while ((line = reader.readLine()) != null) {
    text.append(line).append("\n");
}
```

---

#### `insert(index, value)`: Inserts text at specified position.

```java
sb.insert(3, "XYZ");
```

#### Real Use Case:

Inserting user input into a template:

```java
StringBuilder template = new StringBuilder("Dear , welcome!");
template.insert(5, "Ali");
System.out.println(template); // Dear Ali, welcome!
```

---

#### `delete(start, end)`: Removes characters from start to end (exclusive).

```java
sb.delete(0, 3);
```

#### Real Use Case:

Removing area code from a phone number string:

```java
StringBuilder phone = new StringBuilder("+92-333-1234567");
phone.delete(0, 4);
System.out.println(phone); // 333-1234567
```

---

#### `reverse()`: Reverses the character sequence.

```java
sb.reverse();
```

#### Real Use Case:

Checking for palindrome strings:

```java
String original = "madam";
StringBuilder sb = new StringBuilder(original);

if (original.equals(sb.reverse().toString())) {
    System.out.println("It's a palindrome");
}
```

## **9. String Interning in Java**

**String interning** is a method of storing only one copy of each distinct string value in the **String Pool**. The `intern()` method ensures that all strings with the same content share the same memory reference if they’re interned.

---

### **9.1. The `intern()` Method**

The `intern()` method returns a canonical representation (a reference from the string pool) of a string.

#### Example:

```java
String a = new String("Ali");
String b = a.intern();
String c = "Ali";

System.out.println(b == c); // true
```

Here, `b` refers to the string from the pool, and `c` is a string literal from the same pool — so their references match.

---

### Real Use Case:

**Optimizing memory for large datasets containing repeated strings**

Suppose you're processing a CSV file with thousands of rows and many repeated values (like city names or product categories):

```java
Map<String, Integer> cityCount = new HashMap<>();

for (String city : citiesFromFile) {
    String key = city.intern(); // Avoid creating duplicate string objects
    cityCount.put(key, cityCount.getOrDefault(key, 0) + 1);
}
```

This avoids creating multiple copies of the same city name, reducing memory usage.

---

### **9.2. When to Use String Interning**

* When you expect many duplicate strings (e.g., keys, tags, categories)
* When using strings in **maps or sets** to improve memory and performance
* When working with large XML/JSON data where many string values repeat

---

### **9.3. When to Avoid Interning**

* On small datasets (unnecessary overhead)
* When you need every string to be a unique object (e.g., tracking creation time)

---

## **10. Regular Expressions (Regex) in Java**

### **10.1. What is a Regular Expression?**

A **Regular Expression (regex)** is a sequence of characters that forms a **search pattern**. It is used for matching, finding, replacing, or splitting text in strings.

Java provides this functionality through:

* The `Pattern` class
* The `Matcher` class
* Some built-in methods in the `String` class (like `matches()`, `replaceAll()`, etc.)

---

### **10.2. Basic Syntax Reference**

| Pattern  | Description                   | Example Match     |      |      |
| -------- | ----------------------------- | ----------------- | ---- | ---- |
| `.`      | Any single character          | "a", "b", etc.    |      |      |
| `*`      | 0 or more of the previous     | "a", "aa", ""     |      |      |
| `+`      | 1 or more of the previous     | "a", "aa"         |      |      |
| `?`      | 0 or 1 of the previous        | "a", ""           |      |      |
| `\\d`    | Any digit (0–9)               | "5"               |      |      |
| `\\w`    | Word character \[a-zA-Z0-9\_] | "a", "Z", "0"     |      |      |
| `\\s`    | Whitespace                    | space, tab        |      |      |
| `^`      | Start of line                 | `^abc` → "abc"    |      |      |
| `$`      | End of line                   | `abc$`            |      |      |
| `[abc]`  | One of a, b, or c             | "a", "b", "c"     |      |      |
| `[^abc]` | Not a, b, or c                | "d", "x"          |      |      |
| `{n}`    | Exactly n times               | `\\d{4}` → "2024" |      |      |
| \`       | \`                            | OR                | "cat | dog" |
| `()`     | Grouping                      | `(abc)+`          |      |      |

---

### **10.3. Using Regex with `String.matches()`**

#### Syntax:

```java
string.matches("regex")
```

#### Real Use Case: **Validating an email address**

```java
String email = "user@example.com";
boolean isValid = email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
System.out.println(isValid); // true
```

---

### **10.4. Using `Pattern` and `Matcher` Classes**

#### Syntax:

```java
Pattern pattern = Pattern.compile("regex");
Matcher matcher = pattern.matcher(input);
boolean match = matcher.matches();
```

#### Real Use Case: **Extracting numbers from a string**

```java
String input = "Order #1234, Ref #5678";
Pattern pattern = Pattern.compile("\\d+");
Matcher matcher = pattern.matcher(input);

while (matcher.find()) {
    System.out.println(matcher.group()); // Outputs: 1234 and 5678
}
```

---

### **10.5. Using `replaceAll()` with Regex**

#### Real Use Case: **Removing all non-digit characters from a string**

```java
String messy = "Phone: +92-333-123-4567";
String clean = messy.replaceAll("\\D", ""); // Remove non-digit characters
System.out.println(clean); // 923331234567
```

---

### **10.6. Using `split()` with Regex**

#### Real Use Case: **Splitting a string on commas or semicolons**

```java
String input = "Ali,Ahmed;Sara,Omar";
String[] names = input.split("[,;]");
for (String name : names) {
    System.out.println(name.trim());
}
```

---

### **10.7. Common Real-World Regex Examples**

| Task                            | Regex                           | Example Input        | Match? |
| ------------------------------- | ------------------------------- | -------------------- | ------ |
| Valid Email                     | `^[\\w.-]+@[\\w.-]+\\.\\w{2,}$` | `john.doe@gmail.com` | ✅      |
| Mobile Number (11 digits)       | `^\\d{11}$`                     | `03001234567`        | ✅      |
| Postal Code (5 digits)          | `^\\d{5}$`                      | `75500`              | ✅      |
| Contains Only Letters           | `^[a-zA-Z]+$`                   | `Ali`                | ✅      |
| Starts with "A", 3 letters      | `^A\\w{2}$`                     | `Ali`                | ✅      |
| Password (min 8 chars, 1 digit) | `^(?=.*\\d).{8,}$`              | `passw0rd`           | ✅      |

---

### **10.8. When to Use Regex in Java**

* Form validation (emails, phone numbers, passwords)
* Parsing logs and files
* Searching patterns in strings
* Replacing or cleaning data
* Data extraction from unstructured text


---


