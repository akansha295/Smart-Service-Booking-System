# 🚀 Smart Service Booking and Management System

## 📌 Project Overview

The **Smart Service Booking and Management System** is a web-based application developed using **Java, Servlets, JDBC, Hibernate, and MySQL**.
It allows customers to book services online and enables administrators to manage services, bookings, and users efficiently.

This system focuses on **session management, authentication, and database integration**, making it suitable for real-world service-based applications.

---

## 🎯 Key Features

### 👤 Customer Module

✔ User Registration
✔ Secure Login & Logout
✔ Session Management
✔ View Available Services
✔ Book Services
✔ View My Bookings

### 🛠 Admin Module

✔ Add and Manage Services
✔ View All Bookings
✔ Manage Customers

---

## 🧩 Main Modules

1. User Authentication
2. Service Management
3. Booking Management
4. Admin Dashboard

---

## 🏗️ Technology Stack

* Java
* Servlets
* JDBC
* Hibernate
* MySQL
* HTML, CSS
* Apache Tomcat

---

## 💾 Database Design

### Tables Used

* **Customer Table** → Stores user details
* **Services Table** → Stores service information
* **Booking Table** → Stores user bookings

Example Booking Table Fields:

* Booking ID
* Customer ID (cid)
* Service ID (sid)
* Status

---

## 🔐 Session Management

Session is used to:

* Store logged-in user information
* Maintain user authentication
* Control access to booking features
* Prevent unauthorized booking

After login, user details are stored in session and used throughout the application.

---

## 🔄 System Flow

User Registration → Login → Session Creation → View Services →
Select Service → Booking → Store in Database → View My Bookings → Logout

---

## ⚙️ Working Explanation

### 🔹 Login Process

* User enters email and password
* Server validates credentials
* Session is created to remember the logged-in user

### 🔹 Booking Process

* Services are displayed using Servlet and GET request
* Service ID (sid) is passed through URL
* Booking Servlet stores selected service and user ID (cid) in the database

Example:

```java
<a href="BookServiceServlet?sid=3">Book</a>
```

### 🔹 My Booking

* Displays only bookings of the logged-in user
* Uses session to fetch customer data

### 🔹 Logout

* Session is invalidated
* User is redirected to login page

---


## 🚀 Future Enhancements

* Spring Boot implementation
* REST API integration
* Payment gateway
* Email & SMS notifications
* Mobile responsive UI

---

## 💡 Learning Outcomes

✔ MVC architecture understanding
✔ Session handling
✔ Servlet lifecycle
✔ Database connectivity
✔ Hibernate ORM
✔ Authentication & Authorization

---

## 👩‍💻 Author

**Akansha Kumbhar**
