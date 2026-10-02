# 🖥️ Builder Design Pattern – Custom PC Configuration

A beginner-friendly Java project demonstrating the **Builder Design Pattern** through a real-world **Custom PC Configuration** scenario.

---

## 📌 1. Project Title
**Builder Pattern – Custom PC Configuration**

---

## 📝 2. Project Overview
This project illustrates how the **Builder Design Pattern** simplifies the creation of complex objects step by step in Java. By separating mandatory components (Processor, RAM, Storage) from optional components (Graphics Card, Cooling System), the pattern provides a clean, readable, and flexible way to construct customized PC objects without constructor pollution or complex method overloading.

---

## ❓ 3. Problem Statement
Creating complex objects with multiple parameters can quickly become difficult to maintain:
- Using a **telescoping constructor** (having multiple constructors with different argument combinations) leads to cluttered and unreadable code (`new PC("Intel i7", 16, 512, "NVIDIA RTX 4060", null)`).
- Using **JavaBeans pattern** (call default constructor, then call multiple setters) leaves objects mutable and open to invalid/partially initialized states.

---

## 💡 4. What is the Builder Design Pattern?
The **Builder Design Pattern** is a creational design pattern that lets you construct complex objects step by step. Unlike other creational patterns, the Builder pattern allows you to produce different types and representations of an object using the same construction code.

---

## 🎯 5. Why the Builder Pattern is Used in This Project
In our Custom PC Builder scenario:
1. **Mandatory vs. Optional Components**: Every PC requires a `Processor`, `RAM`, and `Storage`. However, components like `Graphics Card` and `Cooling System` are optional.
2. **Method Chaining**: Optional setters return `this`, enabling fluent method calls (`.graphicsCard("...").coolingSystem("...")`).
3. **Immutability & Safety**: The `PC` constructor is `private`, ensuring that `PC` instances can only be instantiated through the `Builder` in a valid, complete state.

---

## 🏗️ 6. Project Structure

```text
BuilderPattern/
├── src/
│   ├── PC.java          # Product class and nested static Builder class
│   └── Client.java      # Client application demonstrating PC creation
└── README.md            # Complete project documentation
```

---

## 🧱 7. Components of the Builder Pattern in This Project

- **Product (`PC`)**: The complex object being built, containing all fields and a method to display the configuration.
- **Builder (`PC.Builder`)**: A static nested class inside `PC` that collects required components via its constructor and optional components via chaining methods, before instantiating `PC` via `build()`.
- **Client (`Client`)**: The client application that uses `PC.Builder` to construct different PC representations (e.g., Gaming PC vs. Basic PC).

---

## 🔍 8. How the Code Works, Step by Step

1. **Private Constructor**: The `PC` constructor is marked `private PC(Builder builder)`. This prevents external code from instantiating `PC` directly using `new PC(...)`.
2. **Nested Builder Initialization**: The client calls `new PC.Builder("Intel i7", 16, 512)` to initialize mandatory fields (`processor`, `ram`, `storage`).
3. **Optional Configuration**: Optional setter methods (`graphicsCard(...)`, `coolingSystem(...)`) set optional values on the `Builder` instance and return `this` to allow chaining.
4. **Object Construction**: The client invokes `.build()`, which calls the private `PC` constructor, transferring configuration values to a new, fully initialized `PC` instance.
5. **Display Output**: Calling `displayConfiguration()` prints the detailed specification formatted cleanly.

---

## 🚀 9. Code Execution Instructions

### Prerequisites
- Java Development Kit (JDK 8 or higher) installed on your system.

### Steps to Run

1. Open your terminal or Command Prompt and navigate to the `BuilderPattern` directory:
   ```bash
   cd BuilderPattern
   ```

2. Compile all Java source files:
   ```bash
   javac src/*.java
   ```

3. Run the Client application:
   ```bash
   java -cp src Client
   ```

---

## 📊 10. Sample Output

```text
==================================================
   BUILDER DESIGN PATTERN DEMO - CUSTOM PC BUILD  
==================================================

Building Example 1: Gaming PC...
----------------------------------------------
             PC CONFIGURATION DETAIL          
----------------------------------------------
 Processor     : Intel i7
 RAM           : 16 GB
 Storage       : 512 GB SSD
 Graphics Card : NVIDIA RTX 4060
 Cooling System: Liquid Cooling
----------------------------------------------

Building Example 2: Basic PC...
----------------------------------------------
             PC CONFIGURATION DETAIL          
----------------------------------------------
 Processor     : Intel i5
 RAM           : 8 GB
 Storage       : 256 GB SSD
 Graphics Card : Not selected
 Cooling System: Not selected
----------------------------------------------

==================================================
   BUILD DEMONSTRATION COMPLETED SUCCESSFULLY     
==================================================
```

---

## 🧠 11. Key Concepts Demonstrated
- **Creational Design Patterns**: Encapsulating complex object creation.
- **Static Nested Class**: Encapsulating the `Builder` inside the target product class `PC`.
- **Fluent Interface / Method Chaining**: Returning `this` from setter methods for concise syntax.
- **Encapsulation & Immutability**: Keeping constructors private and fields final.

---

## 🎓 12. Learning Outcomes
- Understood when and why to apply the Builder Design Pattern.
- Learned how to enforce mandatory parameters while keeping optional parameters flexible.
- Gained hands-on practice in writing clean, readable Java code without external dependencies.

---

## 🛠️ 13. Technologies Used
- **Language**: Java (JDK 8+)
- **Design Pattern**: Builder Pattern (Creational)
- **Tools**: Command Line Compiler (`javac`), Standard Java Runtime (`java`)
