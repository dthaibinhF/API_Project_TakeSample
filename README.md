# API_Project_TakeSample

## USER


# List of Users
GET `/api/user`  
Return a list of user

# Get one user
GET `api/user/:userid`  
Return details of user

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
