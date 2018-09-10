1. Checkout project
2. Download Eclipse http://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/luna/SR2/eclipse-java-luna-SR2-win32-x86_64.zip
3. Extract the Lib.zip folder, run the jdk file (this folder should be copied outside the project)
4. Setup environment variable:
	- Open the Control Panel, as shown in Figure http://prntscr.com/kf8sqi
	- Select Enviroment Variables. In the System Variables section, add two variables: JAVA_HOME(link to the jdk directory) and M2_HOME(link to the apache-maven-3.5.4 directory in the Lib directory).
	- In the line path, add new% JAVA_HOME% \ bin and% M2_HOME% \ bin
	- To check if the installation is successful, press Window + R, type java -version and mvn -version if successful, it will display the installed version.
5. Download firefox <= version 47 (because selenium does not support latest firefox), and set firefox for no update
6. Go to Eclipse -> Help -> Eclipse Marketplace -> search under TestNG key, install testNG for Eclipse
7. Import maven project with Eclipse, right click on project name -> Maven -> Update project
8. Right-click the project name -> Build path -> configure build path -> Libraries tab, click add external JARs -> Delete all corrupted folders and open the link to the selenium-2.53.0 folder in the medium Lib. Extract all the files in the libs directory and the selenium-java-2.53.jar file.
9. Click Add Library, add the TestNG library
10. To run the testscript, select mysuilt.xml in the src / main / resources package. Click Run as with TestNG
