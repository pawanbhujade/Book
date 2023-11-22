# Bookstore API

This is a simple RESTful API for a hypothetical online bookstore built with Java 11+, Spring Boot, and PostgreSQL.

## Prerequisites

- Java 11 or higher
- MySQL installed and running
- Your preferred IDE or text editor

## Getting Started

1. **Clone the repository:**

    ```bash
    git clone https://github.com/your-username/bookstore-api.git
    cd bookstore-api
    ```

2. **Set up the Database:**

    - Create a MySQL database for the project.
    - Update the database configuration in `src/main/resources/application.properties`:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    ```

3. **Run the Project:**

    - Open the project in your preferred IDE.
    - Run the `BookstoreApiApplication` class.

4. **Access the API:**

    The API will be accessible at `http://localhost:8080/api/v1/books`.

## API Endpoints

- **GET /api/v1/book:** Retrieve a list of all books.
- **GET /api/v1/book/{id}:** Retrieve a single book by ID.
- **POST /api/v1/book:** Add a new book.
- **PUT /api/v1/book/{id}:** Update an existing book by ID.
- **DELETE /api/v1/book/{id}:** Delete a book by ID.

### Example Request:

```http
GET /api/v1/book HTTP/1.1
Host: localhost:8080
