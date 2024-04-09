# API_Project_TakeSample

## account, user, project

### List of data
GET `/api/acount`  
GET `/api/user`  
GET `/api/project`  
GET `/api/task`  
Returns list of data


### Create a new data
POST `/api/account`  
POST `api/user`  
POST `api/project`  
POST `api/task`  
Allow you to submit a new data.  
  
The request body needs to be in JSON format and include the following properties:  
**Account**  
- idAccount - Long  
- username -  String -use phonenumber to engage  
- password - String

**Example**  
POST /api/account  
{  
        "idAccount": 1,  
        "username": "0939464077",  
        "password": "1232"  
}  

**User**  
- idUser - Long  
- name - String  
- address - String  
- email - String  
- phoneNumber - String  
  
**POST /api/user**  

{  
        "idUser": 1,  
        "name": "Dang Thai Binh",  
        "address": "Can Tho",  
        "email": "dthaibinh03@gmail.com",  
        "phoneNumber": "0939464077"  
}   

**Project**  
- idProject - Long  
- projectName -  String   
- researchMethod - String
- describe - String
- dateCreate - LocalDate

**POST /api/project**  

{  
        "idProject": 1,
        "projectName": "tui",
        "researchMethod": "thu nghiem lam san",
        "describe": "chat tay",
        "dateCreate": "2024-04-06"  
}   

**Task**  
- idTask - Long  
- startTime -  LocalDate   
- deadline - LocalDate
- directiom - String

**POST /api/task**  

{  
        "idTask": 1,
        "startTime": "2024-04-07",
        "deadline": "2024-04-10",
        "direction": "Complete the API" 
}   

### Update Data
PUT `/api/account/{accountID}?attribute1=value&attribute2=value`  
PUT `/api/user{userID}?attribute1=value&attribute2=value`  
PUT `/api/user{projectId}?attribute1=value&attribute2=value`  
PUT `/api/user{taskId}?attribute1=value&attribute2=value`  
**Example**  
PUT `http://localhost:8080/api/user/1?name=john`  
PUT `http://localhost:8080/api/account/1?password=12345678`  
PUT `http://localhost:8080/api/project/1?projectName=test`  
PUT `[http://localhost:8080/api/project/1?projectName=test](http://localhost:8080/api/task/3?startTime=2024-04-10&deadline=2024-04-13)`  

### Delete Data
DELETE `/api/account/{accountID}`  
DELETE `/api/user/{userId}`  
DELETE `/api/user/{projectId}`  
DELETE `/api/user/{taskId}   
**Example**  
DELETE `http://localhost:8080/api/user/1`  
