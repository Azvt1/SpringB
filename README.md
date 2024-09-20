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
curl -X GET http://localhost:8080/api/users
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
curl -X DELETE http://localhost:8080/api/users/1
```

**Windows:**
```bash
curl -X DELETE http://localhost:8080/api/users/1
```

**Output:**
User succesffuly deleted!

### 4. Create Flight

**Request:**

**Mac:**

```bash
curl -X POST http://localhost:8081/api/bookings \
-H 'Content-Type: application/json' \
-d '{
  "userId": 1,
  "bookingType": "FLIGHT",
  "flightNumber": "TEST555",
  "bookingDate": "2024-09-19T12:30:00",
  "departureDate": "2024-10-19T12:30:00",
  "arrivalDate": "2024-10-20T12:30:00"
}'
```

**Windows:**
```bash
curl -X POST http://localhost:8081/api/bookings ^
-H "Content-Type: application/json" ^
-d "{
  \"userId\": 1,
  \"bookingType\": \"FLIGHT\",
  \"flightNumber\": \"TEST555\",
  \"bookingDate\": \"2024-09-19T12:30:00\",
  \"departureDate\": \"2024-10-19T12:30:00\",
  \"arrivalDate\": \"2024-10-20T12:30:00\"
}"
```

**Output:**
{
  "id": 1,
  "userId": 1,
  "bookingDate": "2024-09-19T12:30:00",
  "status": "PENDING",
  "bookingType": "FLIGHT"
}

### 5. Get Bookings by User ID

**Request:**

**Mac:**

```bash
curl -X GET http://localhost:8081/api/bookings/1
```

**Windows:**
```bash
curl -X GET http://localhost:8081/api/bookings/1
```

**Output:**
{
  "id": 1,
  "userId": 1,
  "bookingDate": "2024-09-19T12:30:00",
  "status": "PENDING",
  "bookingType": "FLIGHT"
}

### 6. Delete Booking by ID

**Request:**
**Mac:**

```bash
curl -X DELETE http://localhost:8081/api/bookings/1
```

**Windows:**
```bash
curl -X DELETE http://localhost:8081/api/bookings/1
```

**Output:**
Booking successfully deleted!

### 7. Get All Flight Bookings

**Request:**

**Mac:**

```bash
curl -X GET http://localhost:8082/api/flightbookings
```

**Windows:**
```bash
curl -X GET http://localhost:8082/api/flightbookings
```

**Output:**
{
  "id": 1,
  "userId": 1,
  "bookingDate": "2024-09-20T21:26:48.714973",
  "status": "PENDING",
  "bookingType": "FLIGHT",
  "flightNumber": "TEST555",
  "departureDate": "2024-10-19T12:30:00",
  "arrivalDate": "2024-10-20T12:30:00",
  "validBooking": true
}

### 8. Make Payment

**Request:**

**Mac:**

```bash
curl -X POST http://localhost:8085/payments/pay \
-H 'Content-Type: application/json' \
-d '{
  "bookingId": 1,
  "amount": 1000,
  "paymentMethod": "MasterCard"
}'
```

**Windows:**
```bash
curl -X POST http://localhost:8085/payments/pay ^
-H "Content-Type: application/json" ^
-d "{
  \"bookingId\": 1,
  \"amount\": 1000,
  \"paymentMethod\": \"MasterCard\"
}"
```
**Output:**
{
  "id": 1,
  "bookingId": 1,
  "amount": 1000.0,
  "paymentDate": "2024-09-20T21:16:18.971064",
  "paymentMethod": "MasterCard",
  "paymentStatus": "PAID"
}

### 9. Cancel Payment

**Request:**

**Mac:**

```bash
curl -X POST http://localhost:8085/payments/cancel/2
```

**Windows:**
```bash
curl -X POST http://localhost:8085/payments/cancel/2
```

**Output:**
{
  "id": 2,
  "status": "Canceled"
}


