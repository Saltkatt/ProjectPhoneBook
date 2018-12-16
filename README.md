# Phone book

Small program that will let you add, edit, update, remove and view contacts by name and phone number and saves them in a database.

## Requirements

This project requires apache maven and a JDK for compilation.

Download the maven jar file on [the official apache maven website](https://maven.apache.org/download.cgi)
Extract the file in a fitting folder and then add your *maven-folder/bin* to your 'PATH'-environment variable.

Download java JDK on [oracles website](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). This
is JDK version 8, which is the JDK used for writing this program. 
When downloaded, add the *java-jdk-folder/bin* to your 'JAVA_HOME'-enivornment variable.

## Set up

Clone this project into your local machine. 

````
git clone https://github.com/blixtr/ProjectPhoneBook.git/
````

This will create a folder named ProjectPhoneBook with all necessary files. Enter the folder, compile and package the program.

````
mvn package
````
This has now created a .jar in the newly made target-folder that will run the program.

## Running the program

Run the program via the .jar file:

````
java -jar ProjectPhoneBook-1.0-jar-with-dependencies.jar
````
Run only with maven:

````
mvn exec:java -Dexec.mainClass=main.Main
````
## How it works

When started, a database has been created in the ProjectPhoneBook-folder. You are sent to a simple console-menu with each option having a corresponding number. Enter the number of the option you want to choose. 

You can add a contact, here you will enter a name and a phonenumber.
You can view all your contacts and also update/remove them. When viewing contacts, enter the number corresponding to the contact
and you will be sent to the edit-menu.
Search for contacts in the search-menu. Searching for a letter/s will return contacts beginning with the letter/s. Searching for number/s will return contacts whose phonenumber contains the number/s. 

When exiting the program, all your contacts are saved.

## Tests

To run the Junit5 test, you use maven.
````
mvn test
````
## Built with

IntelliJ




