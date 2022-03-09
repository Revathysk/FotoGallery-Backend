# FotoGallery-Backend
FOTO Gallery Backend with Spring Boot and POSTGRES

Backend has UserLogin table and Favorites table created in POSTGRES

Components
----------
Models : UserLogin and Favorites Repostiory: UserLogin and Favorites 

Exception: ResourceNotFound

Controllers :

  1) UserLogin : Create and Read User Sign up 
     
     Routes - http://localhost:8080/api/v1/
     
    Creat - adduser
    
    Read   - user/{username}          
         
      - POSTs new user to USERLOGIN provided if USERNAME is unique User Login    
      
      - GETs user by USERNAME and validation of Password is done at frontend

  2) Favorites : 
    Routes :http://localhost:8080/api/v1/
    
    Creat - user/favorites/add
    
    Read  - user/favorites/{username}
    
    Update - user/favorites/edit/{id}
    
    Delete - user/favorites/delete/{id}
        
  - USERNAME is used to GET all favorites on logging in.
  - Selecting a FOTO on image gallery POSTs a record with generated ID,image URL, tag and Pixabay user information to FAVORITES table
  - On Frontend, edit option for each favorite FOTO tag will PUT new description for existing FOTO in FAVORITES table
  - As well remove a FOTO from favorite will DELETE a record from FAVORTIES using ID (primary key).
 
![image](https://user-images.githubusercontent.com/93933279/157371613-6e980ec4-89b4-4448-b196-c7c7157dbc3c.png)





  
