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
PUT /api/project/:1?projectName=project1&researchMethod=anything&describe=something&dateCreate=2024-04-04  
```

## Task
### List of Tasks
GET `/api/task`   
Return a list of tasks.

### Get single task
GET `api/task/:taskId`  
Return details of task.

### Adding new task to porject
POST `/api/task/:projectid`  
Allow you to add new task to specific exits project.

The request body needs to be in JSON format and include the following properties:
- `idTask` - Long  
- `startTime` - LocalDate - FORMMAT: YYYY-MM-DD  
- `deadline` - LocalDate - FORMMAT: YYYY-MM-DD    
- `direction` - String

Example:
```
adding a task (id 7) to project (id 1).
POST /api/task/1
{  
"idTask": 7,
    "startTime": "2024-03-01",
    "deadline": "2024-01-02",
    "direction": "Pulish project"
}   
```

### Delete Task
DELETE `api/task/:taskId`  
Delete an existing task. 

The request body needs to be empty.  

Example:
```
DELETE api/task/2
```
### Update Task's Information
PUT `/api/task/:taskId?startTime=&deadline=&direction=`  
Change information of exist task.

- `idTask` - Long  
- `startTime` - LocalDate - FORMMAT: YYYY-MM-DD  
- `deadline` - LocalDate - FORMMAT: YYYY-MM-DD    
- `direction` - String

Example:
```
PUT /api/task/:taskId?startTime=&deadline=2024-12-14&direction=setting
```

### Sample
### List of Samples
GET `/api/sample`  
Return a list of samples.

### Get single sample
GET `api/sample/:sampleId`   
Return details of sample.

### Adding new sample to porject
POST `/api/sample/:projectid`  
Allow you to add new sample to specific exits project.

The request body needs to be in JSON format and include the following properties:
- `idSample` - Long
- - `nameSample` - String
- `createDate` - LocalDate - FORMMAT: YYYY-MM-DD

Example:
```
adding a sample (id 5) to project (id 1).
POST /api/sample/1
{  
    "idSample": 5,
    "nameSample": "Sample5",
    "createDate": "2024-04-26"
}   
```

### Delete sample
DELETE `api/sample/:sampleId`  
Delete an existing sample. Just delete after delete children (form, picture).

The request body needs to be empty.  

Example:
```
DELETE api/sample/2
```
### Update Sample's Information
PUT `/api/sample/:sampleId?nameSample=&createDate=`  
Change information of exist sample.

- `idSample` - Long
- - `nameSample` - String
- `createDate` - LocalDate - FORMMAT: YYYY-MM-DD

Example:
```
PUT api/sample/:sampleId?nameSample=sample1&createDate=
```

### Picture
### List of pictures
GET `/api/picture`   
Return a list of pictures.

### Get single picture
GET `api/picture/:pictureId`   
Return details of picture.

### Adding new picture to sample
POST `/api/picture/:sampleId`  
Allow you to add new picture to specific exits sample.

The request body needs to be in JSON format and include the following properties:
- `idPicture` - Long
- `namePicture` - String
- `describe` - String
- `url` - String  
Example:
```
adding a picture (id 5) to sample (id 1).
POST /api/picture/1
{  
    "idPicture": 5, 
    "namePicture": "Picture 5",
    "describe": "save to sample 1",
    "url": "https://pic5"
}   
```

### Delete picture
DELETE `api/picture/:pictureId`  
Delete an existing picture.

The request body needs to be empty.  

Example:
```
DELETE api/picture/2
```
### Update picture's Information
PUT `/api/picture/:pictureId?namePicture=&describe=&url=`  
Change information of exist sample.

- `idPicture` - Long
- `namePicture` - String
- `describe` - String
- `url` - String  

Example:
```
PUT /api/picture/:pictureId?namePicture=&describe=something else&url=urlkey
```

### Form
### List of forms
GET `/api/forms`  
Return a list of forms.

### Get single form
GET `api/form/:formId`  
Return details of form.

### Adding new form to sample
POST `/api/form/:form`  
Allow you to add new picture to specific exits sample.

The request body needs to be in JSON format and include the following properties:
- `idForm` - Long
- `nameForm` - String
- `createDate` - LocalDate - FORMMAT: YYYY-MM-DD
- `url` - String  
Example:
```
adding a picture (id 5) to sample (id 1).
POST /api/picture/1
{  
    "idForm": 5,
    "nameForm": "form5",
    "createDate": "2024-03-28",
    "url": "https://form/form5"
}   
```

### Delete form
DELETE `api/form/:formId`  
Delete an existing form.

The request body needs to be empty.  

Example:
```
DELETE api/form/2
```

### Update from's Information
PUT `api/form/:formId?nameForm=&createDate=&url=`  
Change information of exist sample.

- `idForm` - Long
- `nameForm` - String
- `createDate` - LocalDate - FORMMAT: YYYY-MM-DD
- `url` - String  

Example:
```
PUT //api/form/:formId?nameForm=Form 5&createDate=2024-04-12&url=
```
