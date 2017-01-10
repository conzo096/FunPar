Instructions for Building the UCaPE-J8-G2.4-buildNumber

This zip file contains all the files required to set up an
Eclipse project with associated libraries for the book
Using Concurrency and Parallelism Effectively
by Jon Kerridge of Edinburgh Napier University
published by bookboon.com

The software is also used on the Edinburgh Napier University module
SET09109 Fundamentals of Parallel Systems

copy the files to your C drive by using Extract all to C:\
This will create a folder called C:\UCaPE-J8-G2.4-buildNumber

You should now build a current version Eclipse system and install the Groovy2.4 plugin.

The version of Eclipse used is best installed using the Eclipse installer

https://eclipse.org/downloads/download.php?file=/oomph/epp/mars/R1a/eclipse-inst-win64.exe

and Groovy plugin version 2.4 obtained from

http://dist.springsource.org/snapshot/GRECLIPSE/e4.6/

Create a new Eclipse workspace on your system say (drive):\UCaPEWS

You can then import the project 

UCaPE-Eclipseproject-buildNumber.zip directly into Eclipse from the library folder.
Do NOT unzip this file just import as an existing project

This will create two projects ChapterExamples and ChapterExercises and 
provided you have created the library folder correctly should link all
the required library files immediately.
The sources should also link to the documentation folders for both
Groovy Parallel and JCSP

If you are not using Eclipse then you still need to create the library structure that is 
implicit within the extracted library and then use the zip file UCaPE-Source-buildNumber.zip 
to obtain the sources of the program examples and exercises referred to in the book.

The documentation for JCSP and Groovy Parallel are held in the folders
GPdocs-buildNumber and JCSPdocs-buildNumber.  
