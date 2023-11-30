By: Calvin Chaparro (Tutors Elvis F., Nicholas L., BROS_ETT)
Course: CEN-3024C
Professor: Mary Walauskis
Date: 09/10/2023

This is part(2) of the SDLC Assignment. The goal of this system is for users
to add or remove books to and from the collection as well
as listing all the books of the collection. 

To add a book to the collection, follow the prompts, and enter the (.txt) directory in this format:
 
C:\Users\YourUserName\IdeaProjects\Module 2 SDLC Assignment Part 2_T01\Books.txt

I included the Books.txt in the directory of the project, so all that should be needed to be entered is Books.txt.

In that file is 3 random books ordered in this format: Book ID#, Title of Book, Author of Book.

When entering a incorrect option, you will be met with an appropriate response. Entering a non numerical character will also 
give a the appropriate response.

10/08/2023 

For Module 6 - Software Implementation Phase 1 - Logic and Functionality, expanded functionality has been implemented allowing users to check in and out books with the barcode number. The name "id" has been completely replaced with a more fitting name "barcode" and when the user lists all books, it now shows whether the book has been checked in or out. Upon trying to check out a book that has already been checked out, the user will be met with the appropriate response. Same thing if the user enters a non numerical option or just a wrong number. This should prevent infinite loops and program crashes.  


10/15/2023

For Module 7 - Software Testing Assignment, we were instructed to use junit testing to run a variety of unit tests to verify that books can be added, removed and checked out or in. I attempted to set up JUnit in my project in IntelliJ, but met some difficulty. Working with the tutorial provided I was able to get my test set up but unfortunately not able to identify the classes in my project to successfully run the tests. I will need to continue working with this and find a solution.

11/22/2023

For the Module 9 submission, I updated all classes to now pull from a database instead of a .txt file. I attempted to get the LMS connected to the library.db file that is located in the root directory, but unfortunately was unsuccessful. I will need to continue to check my file directory for the database and see what may be causing the LMS to not load from the database file included.


11/29/2023 

Per Module 11 assignments requirements, I created and added the JavaDoc generated from IntelliJ. I added notes to each class explaining what each do and also updated all classes with the most up to date code. The program currently still does not pull from the library.db file, and I am still working on fixing that issue. 


This was compiled with the recommended IDE IntelliJ IDEA with Java 17


