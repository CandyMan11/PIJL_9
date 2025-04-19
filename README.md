# PIJL_9
# 📚 Student Data Entry System (Java + MySQL)

A console-based Java application that allows users to perform CRUD (Create, Read, Update, Delete) operations on student data using a MySQL database.

## 🧠 Features

- ✅ Add new student records
- 📃 Display all students
- 🔍 Search student by PRN
- ✏️ Update student details
- ❌ Delete student records
- 💥 Handles invalid inputs with custom exceptions

## 🛠️ Technologies Used

- Java (JDK 20)
- JDBC (MySQL Connector/J)
- MySQL Database
- Custom Exception Handling

## 📂 Project Structure

```
Assignment_9/
├── DBConnection.java              # Handles database connection
├── InvalidDataException.java     # Custom exception for invalid data
├── Main.java                     # Main class with menu and user interaction
├── Student.java                  # POJO class representing a student
├── StudentManager.java           # CRUD operations for student records
└── StudentNotFoundException.java # Custom exception for missing students
```

## 🗃️ Database Setup

Make sure MySQL is installed and running. Then, use the following SQL commands to set up your database:

```sql
CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE students (
    prn VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    dob DATE,
    marks FLOAT
);
```

## 🔧 Setup Instructions

1. **Clone or Download** the repository.
2. **Download the MySQL Connector/J (.jar)** from:
   [https://dev.mysql.com/downloads/connector/j/](https://dev.mysql.com/downloads/connector/j/)
3. **Add the `.jar` to your classpath** when compiling and running.
4. **Edit your DB credentials** in `DBConnection.java`:
   ```java
   String username = "your_username";
   String password = "your_password";
   ```
5. **Compile & Run:**

   **On Windows:**
   ```bash
   javac -cp ".;lib/mysql-connector-j-8.x.x.jar" Assignment_9/*.java
   java -cp ".;lib/mysql-connector-j-8.x.x.jar" Assignment_9.Main
   ```

   **On Linux/macOS:**
   ```bash
   javac -cp ".:lib/mysql-connector-j-8.x.x.jar" Assignment_9/*.java
   java -cp ".:lib/mysql-connector-j-8.x.x.jar" Assignment_9.Main
   ```

## 🧪 Sample Run

```
===== Student Data Entry Menu =====
1. Add Student
2. Display All Students
3. Search by PRN
4. Update Student
5. Delete Student
6. Exit
Enter your choice: 1
Enter PRN: 113
Enter Name: Saksham
Enter DoB(YYYY-MM-DD): 2005-04-11
Enter Marks: 89
Student added successfully.
```

## ⚠️ Exception Handling

- **`InvalidDataException`** — thrown for empty names or invalid marks.
- **`StudentNotFoundException`** — thrown when PRN doesn't exist in the database.
- **Other Exceptions** — caught and logged in the main menu for stability.

## 👨‍💻 Author

**Saksham Sharma**  
PRN: 23070126113  
Batch: AIML B2

---

📌 *This project is designed for academic and learning purposes.*  
