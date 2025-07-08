# 📚 Quantum Bookstore

A **professional, extensible Java bookstore system** for managing inventory, purchasing physical & digital books, handling customers, and robust error handling. Built with clean architecture, design patterns (Factory, Interface Segregation), and solid principles to support scalability and maintainability.

---

## ✨ Features

✅ **Inventory Management**  
✓ Add, remove, and manage various book types (Paper, E-book, Showcase)

✅ **Smart Purchasing System**  
✓ Paper books → shipped to customer  
✓ E-books → sent via email  
✓ Showcase books → not for sale

✅ **Customer Support**  
✓ Central customer class with email and shipping details

✅ **Exception Handling**  
✓ Robust custom exceptions (book not found, out of stock, invalid email...)

✅ **Easily Extensible**  
✓ Add new book types without modifying existing logic

---

## 📦 Project Structure

```
Bookstore/
│
├── src/
│   ├── Main.java
│   ├── README.md
│   ├── application/
│   │   └── service/
│   │       ├── InventoryService.java
│   │       ├── MailService.java
│   │       └── ShippingService.java
│   ├── domain/
│   │   ├── book/
│   │   │   ├── entity/
│   │   │   │   ├── Book.java
│   │   │   │   ├── EBookImpl.java
│   │   │   │   ├── PaperBookImpl.java
│   │   │   │   └── ShowcaseBookImpl.java
│   │   │   ├── factory/
│   │   │   │   ├── EBookFactory.java
│   │   │   │   ├── ShowcaseBookFactory.java
│   │   │   │   └── PaperBookFactory.java
│   │   │   └── interfaces/
│   │   │       ├── EBook.java
│   │   │       ├── PaperBook.java
│   │   │       ├── ShippableBook.java
│   │   │       └── ShowcaseBook.java
│   │   └── customer/
│   │       └── entity/
│   │           └── Customer.java
│   ├── exception/
│   │   ├── AddressEmptyException.java
│   │   ├── BookNotForSaleException.java
│   │   ├── BookNotFoundException.java
│   │   ├── EmptyBookException.java
│   │   ├── InvalidEmailException.java
│   │   ├── OutOfStockException.java
│   │   └── ShippedFailedException.java
│   └── bootstrap/
│       └── QuantumBookstoreFullTest.java
│
├── Readme.md
└── out/
```

---

## 🚀 How to Run

### ▶️ Main Entry (Wiring Only)

```bash
javac -d . src/Main.java
java Main
```

### 🧪 Test Full System

```bash
javac -d . src/bootstrap/QuantumBookstoreFullTest.java
java bootstrap.QuantumBookstoreFullTest
```

---

## 💡 Example Usage

```java
InventoryService inventory = new InventoryService();

// Create books
PaperBookImpl paper = PaperBookFactory.createPaperBook(...);
EBookImpl ebook = EBookFactory.createEBook(...);

// Add books
inventory.addBook(paper);
inventory.addBook(ebook);

// Buy book
Customer customer = new Customer("John", "john@mail.com", "Cairo");
inventory.buyBook(paper.getIsbn(), 2, customer.getEmail(), customer.getAddress(), true);
```
## 💡 Example Output

```
Starting shipment to: Cairo
The Cost of Shipping is: 5.0
Clean Code shipped successfully.
```
---

## 🧱 Architecture Overview

| Layer             | Responsibility |
|------------------|----------------|
| **Domain Layer**  | Core entities, interfaces, factories |
| **Service Layer** | Business logic (inventory, shipping, email) |
| **Exception Layer** | Domain-specific errors |
| **Bootstrap Layer** | System demo/test |

---

## 📖 Book Types

| Type           | Class              | Description                    |
|----------------|--------------------|--------------------------------|
| Paper Book     | `PaperBookImpl`    | Shippable, has stock           |
| E-Book         | `EBookImpl`        | Emailed, no shipping required  |
| Showcase Book  | `ShowcaseBookImpl` | Not for sale, just for display |

---

## 🛠️ Adding New Book Type

To extend the system:

1. Add a new **interface** to `domain/book/interfaces/`
2. Create a new **entity** in `domain/book/entity/`
3. (Optional) Add a **factory** in `domain/book/factory/`
4. Register it in `InventoryService`

✅ No need to touch the existing classes!

---

## ❗ Exception Handling

- `BookNotFoundException`
- `OutOfStockException`
- `BookNotForSaleException`
- `EmptyBookException`
- `InvalidEmailException`
- `AddressEmptyException`
- `ShippedFailedException`

---

## 🖼️ UML Class Diagram

```
⛰️ UML Overview:
```

![UML Diagram](E:\Fawry Project\Bookstore\assets\Class-Diagram.svg)


---

## ⚙️ Requirements

- Java 17 or later

---

## 👨‍💻 Author

**Abdelrahman Mabrouk**  
[LinkedIn](https://www.linkedin.com/in/abdelrahman-mabrouk-2b579026b)  
_Empowering clean code and architecture_

---
