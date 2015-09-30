set ProjectPath=C:\Workspace Backup\workspace\SeleniumFrameWork
echo %ProjectPath%
set classpath=%ProjectPath%\bin;%ProjectPath%\lib\*
echo %classpath%
java org.testng.TestNG testng.xml