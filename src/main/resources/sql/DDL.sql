CREATE LOGIN demouser WITH PASSWORD = '123456';
CREATE USER demouser for login demouser;
ALTER SERVER ROLE sysadmin ADD MEMBER demouser;  
 
CREATE DATABASE szemelyekdemo;


