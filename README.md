# REST_Api
This is a Spring Boot application that provides a simple REST API for managing journal entries using MongoDB as the database.
The application allows users to:

✔ Create a new journal entry
✔ Retrieve all journal entries
✔ Fetch a journal entry by its ID
✔ Delete a journal entry by its ID

Tech Stack:
Spring Boot (REST API)
Spring Data MongoDB (Database)
Java 17+
Maven (Dependency Management)
API Endpoints:
POST /journal-application/save → Save a new entry
GET /journal-application → Get all entries
GET /journal-application/{id} → Get an entry by ID
DELETE /journal-application/delete/{id} → Delete an entry
How to Run 🚀
Clone the repository
Configure MongoDB connection in application.properties

