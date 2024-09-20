# Travel Booking Microservice - SpringBoot Poject Task B

## Project Overview

The Travel Booking Microservice is designed to handle user management, flight bookings, and payment processing for a travel booking application. This system allows users to create and manage their profiles, book flights, and process payments efficiently. The application employs RESTful APIs to ensure seamless interactions between the client and server.

## API Endpoints

### 1. Create User

**Request:**

**Mac:**

```bash
curl -X POST http://localhost:8080/api/users \
-H 'Content-Type: application/json' \
-d '{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "12345",
  "phoneNumber": "1234567890"
}'
```

**Windows:**
```bash
curl -X POST http://localhost:8080/api/users ^
-H "Content-Type: application/json" ^
-d "{
  \"name\": \"John Doe\",
  \"email\": \"john@example.com\",
  \"password\": \"12345\",
  \"phoneNumber\": \"1234567890\"
}"
```

**Output:**
[
  {
    "id": 1,
    "name": "John Doe",
    "email": {
      "emailAddress": "john@example.com"
    },
    "password": "12345",
    "phoneNumber": "1234567890",
    "bookingList": []
  }
]

### 2. Get User

**Request:**

**Mac:**

```bash
curl -X GET http://localhost:8080/api/users/1
```

**Windows:**
```bash

```

**Output:**
{
  "id": 1,
  "name": "John Doe",
  "email": {
    "emailAddress": "john@example.com"
  },
  "password": "12345",
  "phoneNumber": "1234567890",
  "bookingList": []
}



### 3. Delete User

**Request:**

**Mac:**

```bash

```

**Windows:**
```bash

```

**Output:**


### 4. Create Flight

**Request:**

**Mac:**

```bash

```

**Windows:**
```bash

```

**Output:**

### 5. Get Flight

**Request:**

**Mac:**

```bash

```

**Windows:**
```bash

```

**Output:**

### 6. Get Flight by UserId

**Request:**

**Mac:**

```bash

```

**Windows:**
```bash

```

**Output:**

### 7. Delete Flight

**Request:**

**Mac:**

```bash

```

**Windows:**
```bash

```

**Output:**

### 8. Make Payment

**Request:**

**Mac:**

```bash

```

**Windows:**
```bash

```

**Output:**

### 9. Cancel Payment

**Request:**

**Mac:**

```bash

```

**Windows:**
```bash

```

**Output:**

