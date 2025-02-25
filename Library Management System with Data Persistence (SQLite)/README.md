
# Library Management System

A simple Java-based Library Management System using SQLite as the database.

## Features
- Add, Display, Update & Delete Books
- User Registration & Login
- Data Persistence using SQLite
- Secure User Authentication

## Installation & Setup

### 1. Clone the Repository
```
git clone https://github.com/yourusername/Library-Management-System.git
cd Library-Management-System
```

### 2. Compile the Java Files
```
javac -encoding UTF-8 -cp "lib/*" -d bin src/*.java
```

### 3. Run the Program
```
java -cp "bin;lib/*" Main
```

## Project Structure
```
Library Management System
│── lib/                  # External JAR libraries
│── src/                  # Source code
│   ├── Main.java         # Main entry point
│   ├── DatabaseHelper.java # Database handling
│   ├── UserAuth.java     # User authentication
│   ├── BookAPI.java      # Book handling
│   ├── LibraryApp.java   # Application logic
│── library.db            # SQLite database (Sample)
│── README.md             # Project documentation
```

## Future Enhancements
- Add a Graphical User Interface (GUI)
- Track Book Borrowing & Returns
- Email Notifications for Overdue Books

## Contributing
Contributions are welcome. Feel free to fork this repository and submit a pull request.

## License
This project is open-source and available under the MIT License.
