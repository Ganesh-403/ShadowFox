# Student Information System

A simple JavaFX-based **Student Information System** that allows users to **add, update, and delete student records** using a graphical user interface (GUI).

## Features

- **Add Student**: Enter a name and add it to the list.
- **Update Student**: Select a student from the list, modify their name, and update the record.
- **Delete Student**: Remove a selected student from the list.
- **GUI Interaction**: Click on a student in the list to auto-fill the name field for easy editing.

## Prerequisites

- **Java Development Kit (JDK) 17+** (JavaFX requires a modern JDK version)
- **JavaFX Library** (Ensure JavaFX is installed and correctly configured)

## How to Run

1. **Compile the Program**:

   ```
   javac --module-path /path/to/javafx/lib --add-modules javafx.controls main.java
   ```

2. **Run the Program**:

   ```
   java --module-path /path/to/javafx/lib --add-modules javafx.controls main
   ```

   *Replace `/path/to/javafx/lib` with the actual path of your JavaFX library.*

## Code Overview

- `main.java`: The main application that initializes and manages the student list.
- `Student (record)`: A Java record used to store student names efficiently.

## Example Usage

```
Student Name: [John Doe]
[ Add ]  [ Update ]  [ Delete ]
---------------------------------
- John Doe
- Alice Smith
- Mark Wilson
```

## License

This project is open-source and free to use.

---

Enjoy managing student records with JavaFX! 🎓🚀
