# Phone book

Small program that will let you add, edit, update, remove and view contacts by name and phone number and saves them in a database.
It can be run as a console-app or a graphical interface.

## Requirements

This project requires apache maven and a JDK for compilation.

Download the maven jar file on [the official apache maven website](https://maven.apache.org/download.cgi)
Extract the file in a fitting folder and then add your *maven-folder/bin* to your 'PATH'-environment variable.

Download java JDK on [oracles website](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). This
is JDK version 8, which is the JDK used for writing this program. 
When downloaded, add the *java-jdk-folder/bin* to your 'JAVA_HOME'-environment variable.

## Set up

Clone this project into your local machine. 

````
git clone https://github.com/blixtr/ProjectPhoneBook.git/
````
You can also download a zip-file with all the files and unzip the downloaded file in whatever folder you'd like.

This will create a folder named ProjectPhoneBook with all necessary files. Enter the folder, compile and package the program.

````
mvn package
````
This has now created a PhoneBook.jar in the newly made target-folder that will run the program.

## Running the program

Go to the target-folder.
Run the program via the .jar file:

````
java -jar PhoneBook.jar
````
Run only with maven:

````
mvn exec:java -Dexec.mainClass=main.Main
````
## How it works

You are sent to a menu where you get two options, run as Console or Interface. Press 1 for console and 2 for graphical interface.

## Console

When started, a database is created in the ProjectPhoneBook-folder.
You are sent to a simple console-menu with each option having a corresponding number.
Enter the number of the option you want to choose.

To add a contact press 1, enter a name and a phone number.

To view all contacts press 2 and select the contact you want to edit by inputting the contact id number.

Once you have selected the contact you want to edit you will be sent to the edit menu where you can update or remove the contact.

To search for a contact press 3.

Searching for a letter/s will return contacts beginning with the letter/s.
Searching for number/s will return contacts whose phone number contains the number/s.

To exit the program press 4.

When exiting the program, all your contacts are saved.

## GUI

To add contact, press the "Add contact"-button and two textfields will show up. Enter name and phone number and press confirm.
The new contact is now added to the table.

Click on added contact and you will be able to update and delete said contact. Pressing "Update Contact" opens up two textfields
with the contacts name and number, edit the entries and press confirm. Pressing "Delete" deletes the contact.

To search for contact, type something into the search-bar and contacts matching the entry will show up.

On exit all contacts will be automatically saved.

## Tests

To run the Junit5 test, you use maven.
````
mvn test
````
## Built with

IntelliJ




