# Swing Java System

This system was built for the final project of OPP class, contains several
functionalities such as a Library Management System, MP3 system, Calculator and
other CRUD subsystems. The GUI library used to construct this project was Swing.

The architerture used in this project was: Coad and Yourdon's method for object-oriented design http://pages.cpsc.ucalgary.ca/~eberly/Courses/CPSC333/Lectures/Design/cy_design.html


## How to run
It is suggested to create a binary folder at the same level of src/ and execute the following commands
(Be sure to place inside Project directoy):

> Windows
`javac -d .\bin *.java`
`java -cp .\bin ProyectoGUI`

> Linux
`javac -d ./bin *.java`
`java -cp ./bin ProyectoGUI`
  
## Add new songs to the Database
The name of the file that is responsible of the persistence of songs is 'Cancion01.txt' this file is inside the database dir.
The structure of this file is the following:

`album name_song name`

To add a new song write it after the underscore separator, it doesn't matter if the song has blank spaces the system will read it without any problem. Also write the name of the album before the underscore separator, the album name must match with the album name located inside the file 'Album01.txt', it doesn't matter the blank spaces.




