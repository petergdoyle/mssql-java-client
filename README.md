# mssql-java-client
A simple java utility to test connections to a mssql database


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

**Required** 
- Java JRE 7 or later 

**Recommended** (for Windows users) but not required 
- GitBash https://git-for-windows.github.io 

A pre-built bundling of all the executables and dependencies is available for download at the follow location http://streamworksnode0.westus.cloudapp.azure.com/downloads/mssql-java-client-binaries.zip
**Note:** this still requires that a minimum of Java JRE 7 is installed 
If you need to install java then follow directions here: http://www.oracle.com/technetwork/java/javase/downloads/index.html 

If you are builing from source then the following are required to be installed on your build machine
- Java JDK 7+ (not just a JRE) **Note:** follow the links from the java download site specifically for installing the Java JDK for your operating system 
- Maven 3+ follow the instructions provided at the Maven website https://maven.apache.org/install.html 



#####Test Java 
If you are on Windows then open a Command Prompt or better yet install GitBash and open up a GitBash session.
```
c:\Users\winuser> java -version
java version "1.8.0_141"
Java(TM) SE Runtime Environment (build 1.8.0_141-b16)
Java Hotspot(TM) 64-Bit Server VM (build 25.141-b16, mixed mode) 
```
**Note: **If you are on Windows and this command fails but you believe that Java is installed then follow the directions [here](http://www.wikihow.com/Compile-%26-Run-Java-Program-Using-Command-Prompt) about adding the ```java``` executable to your %PATH%

If you are on Linux (or GitBash), you know what to do.
```
[vagrant@mssql-client ~]$ java -version
openjdk version "1.8.0_141"
OpenJDK Runtime Environment (build 1.8.0_141-b16)
OpenJDK 64-Bit Server VM (build 25.141-b16, mixed mode)
```

### Installing

A step by step series of examples that tell you have to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo
