# JDBC CRUD Demo

[🇮🇷 فارسی](./README.fa.md)


 This is a simple CRUD project using plain JDBC (without Hibernate or any ORM framework).
---
It demonstrates how to connect to an Oracle database, create a DAO layer, and implement basic CRUD operations for a Person entity.

## 🔹 Project Structure
- org.j2os.common.JDBC → Database connection management (using Apache DBCP connection pool)
- org.j2os.entity.Person → Entity class mapped to the person table
- org.j2os.repository.PersonDA → Data Access Object (DAO) with raw SQL queries
- org.j2os.service.PersonService → Service layer for business logic
- org.j2os.Main → Application entry point (for testing CRUD)

---

## 🔹 Features

- Insert new person

- Update person information

- Delete person by ID

- Select all persons


## 🔹 Technologies
- Java 8+

- Oracle Database XE

- Apache Commons DBCP2 (for connection pooling)


## 🔹 Example
// Insert a new person
PersonService.getInstance().save(new Person().setName("Mona").setFamily("Jamshidi"));

// Get all persons
List<Person> list = PersonService.getInstance().findAll();
list.forEach(p -> System.out.println(p.getId() + " -- " + p.getName() + " -- " + p.getFamily()));

## 🔹 Notes
This project is intentionally written without Hibernate/JPA to demonstrate DAO pattern with plain JDBC.
A comparison project with Hibernate can be found in hibernate-crud-demo.