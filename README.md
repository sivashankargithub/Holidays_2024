<h1 align="center">Procedure for building JAVA REST API Projects</h1>
<p align="center">SangamOne Connected Services</p>
Background:  This document is to assist entry-level programmers to build simple REST API projects using Java, Spring Tool Suite, Postman, Talend API Tester.

Tools: Download JDK, Spring Tool Suite,MySQL and Postman from

https://www.oracle.com/in/java/technologies/downloads/

https://spring.io/tools/

https://www.postman.com/downloads/

https://chromewebstore.google.com/detail/talend-api-tester-free-ed/aejoelaoggembcahagimdiliamlcdmfm

<h2>Project 1:</h2>

Load “holidays1.csv file and display List of Holidays in Mar 2024 without using Database

1. Create Project Project1 - Spring Starter Project - add dependencies ‘Spring Web’ , with ‘rest1’ as package.  Package Type: “Maven”.  Java: 17
2. Create Package ‘pkg1’ under project1
3. Create HolidayController1.java class file

@RestController

4. Within the class

   @GetMapping(“/holidays/2024”)

   Define a method using File, Scanner, read each line, concatenate into a list separated by “\n” and return it in the method.
5. Test using Browser, Postman or Talend by pointing to URL http://localhost:8080/holidays/2024

Project Link : https://github.com/sivashankargithub/holidays1/tree/main/Project1

<h2>Project 2:</h2>

Load “holidays1.csv file and display List of Holidays in Mar 2024 using MySQL Database

1. Create Project Project2 - Spring Starter Project - add dependencies ‘Spring Web’ , ‘Spring Data JPA’, ‘MySQL Driver’ with ‘rest1’ as package.  Package Type: “Maven”.  Java: 17
2. Create Package ‘pkg1’ under project2
3. Create a HolidayEntity2.java class file.

   @Entity

   Table(name=”holidays”)
4. Within the class

   @Id

   @GeneratedType(strategy=GenerationType.IDENTITY)
5. Outline the attributes of the table -id, holidayname, date1, day1
6. Right Click, Source - Generate Getters and Setters
7. Right Click Source - Generate Constructor with Fields
8. Create HolidayRepo2.java interface file extends JpaRepository<HolidayEntity2, Integer>
9. Create HolidayController2.java class file

   @RestController
10. Within the class

    @.Autowired

    HolidayRepo2 hr2;    (reference of repository)

    @PostMapping(“/holidays/loadData/{fname}”)

    Define a method to load data from file (“holidays1.csv”) and save it to the database using
11. hr.save(new HolidayEntity2(param1, param2, param3)). Use @PathVariable to pick up the file name from the URL

    @GetMapping(“/holidays/2024”)
12. Define a method to pull data from the MySQL database and display it as a list one below the other using hr.findAll()

    @GetMapping(“holidays/2024/{month1}”)

    Define a method to pull data only for a specific month of a specific year and display it as a list one below the other using hr2.findByMonth().
13. The following query may be written in the Repo interface.

@Query(value=”select * from holidays where month(date1)=3”,nativeQuery=true)

14. In resources,in application.properties, add the following lines

    spring.application.name=REST2

    spring.datasource.url:jdbc:mysql://localhost:3306/db1

    spring.datasource.username:root

    spring.datasource.password:root

spring.jpa.hibernate.ddl-auto=create

15. Open MySQL, create database db1,  use db1.
16. In POSTMAN, create a collection called holidays. Create following requests

    POST - http://localhost:8080/holidays/loadfile/holiday1.csv

    GET - http://localhost:8080/holidays/2024

    GET - http://localhost:8080/holidays/2024/3
