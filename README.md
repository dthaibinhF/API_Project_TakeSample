# API_Project_TakeSample

## account, user

### List of data
GET `/api/acount` or GET `/api/user` 
Returns list of data


### Create a new data
POST `/api/account` or POST `api/user` 
Allow you to submit a new data. 

The request body needs to be in JSON format and include the following properties:
Account
- idAccount - Long
- username -  String
- password - String

Example
POST /api/account
{
        "idAccount": 1,
        "username": "0939464077",
        "password": "1232"
}

User:
- idUser - Long
- name - String
- address - String
- email - String
- phoneNumber - String

POST /api/user
{
        "idUser": 1,
        "name": "Dang Thai Binh",
        "address": "Can Tho",
        "email": "dthaibinh03@gmail.com",
        "phoneNumber": "0939464077"
}
