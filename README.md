# FotoGallery-Backend
FOTO Gallery Backend with Spring Boot and POSTGRES

Backend has UserLogin table and Favorites table created in POSTGRES

Components
----------
Models : UserLogin and Favorites Repostiory: UserLogin and Favorites 

Exception: ResourceNotFound

Controllers :

  1) UserLogin : Create and Read User Sign up 
  - POSTs new user to USERLOGIN provided if USERNAME is unique User Login 
  - GETs user by USERNAME and validation of Password is done at frontend

  2) Favorites : 
  Creat,Read,Update,Delete
  - USERNAME is used to GET all favorites on logging in.
  - Selecting a FOTO on image gallery POSTs a record with generated ID,image URL, tag and Pixabay user information to FAVORITES table
  - On Frontend, edit option for each favorite FOTO tag will PUT new description for existing FOTO in FAVORITES table
  - As well remove a FOTO from favorite will DELETE a record from FAVORTIES using ID (primary key).
 


