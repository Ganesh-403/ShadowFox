# 🛒 E-commerce Microservices Application

This is a **microservices-based e-commerce application** built with **Spring Boot (backend)** and **React.js (frontend)**. It supports **user authentication, product management, cart functionality, and order processing**.

---

## 🚀 Features
✅ **User Authentication** (Signup/Login)  
✅ **Product Management** (View, Search)  
✅ **Shopping Cart** (Add/Remove Items)  
✅ **Order Processing & Payments**  
✅ **Microservices Architecture**  
✅ **Dockerized Deployment**  
✅ **Spring Boot + React Integration**  

---

## 🏗️ Tech Stack

### 🔹 Backend:
- **Java (Spring Boot)**
- **Spring Data JPA**
- **Spring Security (for authentication)**
- **Eureka (Service Discovery)**
- **Spring Cloud Gateway** (API Gateway)
- **MySQL** (Database)
- **Docker & Docker-Compose** (Containerization)

### 🔹 Frontend:
- **React.js**
- **Redux (State Management)**
- **Axios (API Calls)**
- **Bootstrap** (UI)

---

## 📦 Microservices

| Service               | Port  | Description                        |
|-----------------------|------|------------------------------------|
| **Config Server**     | 8888 | Centralized Configuration         |
| **Discovery Server**  | 8761 | Service Discovery (Eureka)        |
| **API Gateway**       | 8080 | Routing & Load Balancing          |
| **Product Service**   | 8081 | Manages Products                  |
| **Order Service**     | 8082 | Handles Orders                    |
| **User Service**      | 8083 | Manages Users & Authentication    |
| **Payment Service**   | 8084 | Processes Payments                |
| **Notification Service** | 8085 | Sends Emails & Notifications |

---

## 🛠️ Installation & Setup

### 1️⃣ **Clone the Repository**
```sh
git clone https://github.com/your-repo/ecommerce-microservices.git
cd ecommerce-microservices
2️⃣ Run Docker Containers
sh
Copy
Edit
docker-compose up --build
This will start all microservices automatically.

3️⃣ Access the Services
Frontend: 👉 http://localhost:3000
API Gateway: 👉 http://localhost:8080
Eureka Dashboard: 👉 http://localhost:8761
🔥 API Endpoints
Method	Endpoint	Description
GET	/api/products	Get all products
GET	/api/products/{id}	Get product by ID
POST	/api/orders	Place an order
GET	/api/orders/{userId}	Get user orders
🚀 Deployment
📌 Build Docker Images
sh
Copy
Edit
docker-compose build
📌 Run Services
sh
Copy
Edit
docker-compose up -d
👨‍💻 Contributing
Fork the repo 🍴
Create a new branch git checkout -b feature-name
Commit changes git commit -m "Added new feature"
Push and create a Pull Request ✅
⚡ Troubleshooting
🔹 Backend Errors?
Check logs:
sh
Copy
Edit
docker logs container_name
Ensure MySQL is running.
🔹 Frontend Not Connecting?
Verify REACT_APP_API_URL in .env
Restart backend services
📜 License
This project is open-source and licensed under the MIT License.

🚀 Next Steps
✅ Add Authentication (Login/Signup)
✅ Deploy on AWS/DigitalOcean
✅ Improve UI Design
yaml
Copy
Edit

---

### ✅ **Summary**
- **`docker-compose.yml`**: Defines services, networks, and dependencies.
- **`README.md`**: Provides installation instructions, API details, and troubleshooting steps.

💡 **Now, you can run the entire microservices system with just one command:**  
```sh
docker-compose up --build