# API_Project_TakeSample

## Account

### List of accounts
GET `/api/acount`  
Return a list of accounts.

### Get single account  
GET `/api/account/:accountId` 
Return details of account.

### Register account
POST `/api/account`
Allow you to add new account.

The request body needs to be in JSON format and include the following properties:

- `username` -  String -use phonenumber to engage  
- `password` - String

Example:
```
POST /api/account  
{  
        "username": "0123456789",
        "password": "1232456"
}  
```

### Change password
PUT `/api/account/:accountId?password=`

Allow you change the password of the account.

Example:
```
POST api/account/1?password=0123456783
```

### Delete account
you just can only delete it if the user owner deleted.

## USER  

### List of Users
GET `/api/user`  
Return a list of user

### Get one user
GET `api/user/:userid`  
Return details of user

### Register user
POST `/api/user`
Allow you to add new user.

The request body needs to be in JSON format and include the following properties:
- `idUser` - Long  
- `name` - String  
- `address` - String  
- `email` - String  
- `phoneNumber` - String  
   
Example:
```
POST /api/user
{  
        "name": "Tuyet Ngan",
        "address": "Thu Duc",
        "email": "ngan@gmail.com",
        "phoneNumber": "0123456789"
}   
```
CAUTION: the accoount with the username (phone number) must be add first to the database. Them add new user with exactly phone number. It wil match automaticly.  
Look 2 example above to more clear.

### Delete User
DELETE `api/user/:userId`
Delete an existing user. Causing the account followed deleted.  
The request body needs to be empty.  

Example:
```
DELETE api/user/3
```

### Update information
Update an existing user.

The request body needs to be in JSON format and allows you to update the following properties:
-  `name`
-  `address`
-  `email`

Example:
```
PUT /api/user/:1?name=Hoang PhiU&address=America&email=phi@gmail.com
```
## Project
### List of accounts
GET `/api/project`  
Return a list of [rojects.

### Get single project  
GET `/api/project/:projectId` 
Return details of project.

### Register project
POST `/api/project`
Allow you to add new user.

The request body needs to be in JSON format and include the following properties:
- `idProject` - Long  
- `projectName` - String  
- `researchMethod` - String  
- `describe` - String  
- `dateCreate` - LocalDate  
   
Example:
```
POST /api/project
{
        "idProject": 3,
        "projectName": "AI for work",
        "researchMethod": "Code and documentation",
        "describe": "talking why AI important",
        "dateCreate": "2024-03-01"
}
```

### Assign user
PUT `/api/project/:projectId/add/:userId`
Assign exist user to project.

The request body needs to be in JSON format and allows you to update the following properties:
-  `projectId`
-  `userId`
-  `email`

Example:
```
PUT /api/project/1/add/1
```

### Update Project's Information
PUT `/api/project/:projectId?projectName=&researchMethod=&describe&dateCreate`
Change information of exist project.

- `idProject` - Long  
- `projectName` - String  
- `researchMethod` - String  
- `describe` - String  
- `dateCreate` - LocalDate-FORMMAT: YYYY-MM-DD

Example:
```
/api/project/:1?projectName=project1&researchMethod=anything&describe=something&dateCreate=2024-04-04
```

## Task















## account, user, project, sample, picture, form, task

### List of data
GET `/api/acount`  
GET `/api/user`  
GET `/api/project`  
GET `/api/task`  
GET `/api/sample`  
GET `/api/picture`  
GET `/api/form`  
Returns list of data


### Create a new data
POST `/api/account`  
POST `api/user`  
POST `api/project`  
POST `api/task`  
POST `api/sample`  
POST `api/picture`  
POST `api/form`  
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

**Sample**  
- idSample - Long  
- nameSample -  String   
- createDate - LocalDate


**POST /api/sample**  

{  
        "idSample": 1,
        "nameSample": "Mau cay trong",
        "createDate": "2024-01-01"
}   

**Picture**  
- idPicture - Long  
- namePicture -  String   
- describe - String
- url - String  


**POST /api/picture**  

{  
        "idPicture": 1,
        "namePicture": "anh 1",
        "describe": "cay a",
        "url": "https//:ascascsc"
}   


**Form**  
- idForm - Long  
- nameForm -  String   
- LocalDate - LocalDate
- url - String  


**POST /api/form**  

{  
        "idForm": 1,
        "nameForm": "thu thap yeu cau",
        "createDate": "2024-04-01",
        "url": "https//:asasd"
}   


### Update Data
PUT `/api/account/{accountID}?attribute1=value&attribute2=value`  
PUT `/api/user{userID}?attribute1=value&attribute2=value`  
PUT `/api/user{projectId}?attribute1=value&attribute2=value`  
PUT `/api/user{taskId}?attribute1=value&attribute2=value`  
PUT `/api/user{sampleId}?attribute1=value&attribute2=value`  
PUT `/api/user{pictureId}?attribute1=value&attribute2=value`  
PUT `/api/user{formId}?attribute1=value&attribute2=value`  
**Example**  
PUT `http://localhost:8080/api/user/1?name=john`  
PUT `http://localhost:8080/api/account/1?password=12345678`  
PUT `http://localhost:8080/api/project/1?projectName=test`  
PUT `http://localhost:8080/api/task/3?startTime=2024-04-10&deadline=2024-04-13`  
PUT `http://localhost:8080/api/picture/3?namePicture=thai Son&describe=test`  
PUT `http://localhost:8080/api/sample/3?nameSample=hoa muoi gio`  
PUT `http://localhost:8080/api/form/2?url=https//:somthing`  

### Delete Data
DELETE `/api/account/{accountID}`  
DELETE `/api/user/{userId}`  
DELETE `/api/user/{projectId}`  
DELETE `/api/user/{taskId}   
DELETE `/api/user/{sampleId}   
DELETE `/api/user/{pictureId}   
DELETE `/api/user/{form}   
**Example**  
DELETE `http://localhost:8080/api/user/1`  
