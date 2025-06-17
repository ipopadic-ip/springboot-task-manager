# Spring Boot Project Task Manager

This application is a backend system for managing people, their assignments (engagements), and tasks within a project environment. It was developed using **Java Spring Boot**, with **MySQL** as the database and **DBeaver** as the database management client.

## ✨ Features

### CRUD Operations
The application supports standard create, read, update, and delete (CRUD) operations for the following entities:
- **Person**
- **EngagedPerson**
- **Task**
- **Project** (implicitly through engagements)

### Validation Rules
- It is not allowed to add a project with a deadline in the past.
- Engagements:
  - Cannot have a start date after the end date.
  - Cannot have an end date before the start date.
- Date input is strictly validated at the service level.

### Filtering & Business Logic
- Retrieve engagements within a specific date range.
- Retrieve all **realized** engagements:
  - An engagement is considered **realized** if its end date is before the current system date.

### Nested Tasks (Subtasks)
- Tasks can consist of subtasks.
- The overall status of a parent task is calculated as the **average status** of all its subtasks.

## 🧰 Technologies Used

- **Spring Boot (Java)**
- **MySQL** (relational database)
- **DBeaver** (used for database connection and visualization)
- **Maven** (project build and dependency management)
- **Spring Data JPA** (repository layer)
- **Spring Web** (RESTful API)

## Author

**Ilija Popadic**  
[GitHub: ipopadic-ip](https://github.com/ipopadic-ip)

## License

This project is licensed under the **Attribution License**.

You are free to use, modify, and share this code for personal purposes, **as long as proper credit is given**.  
That includes:

- Mentioning my full name **Ilija Popadic** visibly in your project or documentation.
- Providing a working link to my GitHub profile: [https://github.com/ipopadic-ip](https://github.com/ipopadic-ip)

Failure to provide visible credit is a violation of this license.

---

## 📦 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/springboot-project-task-manager.git
   cd springboot-project-task-manager
