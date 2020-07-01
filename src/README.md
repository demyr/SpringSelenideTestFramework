## Prepare environment

- To launch the project you should have maven and java installed on your computer
     - Install [JDK 11 for Windows](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-microsoft-windows-platforms.html#GUID-371F38CC-248F-49EC-BB9C-C37FC89E52A0)
     - Install [Maven](https://maven.apache.org/install.html)

## Prepare Selenium server to run UI tests

- Install [npm](https://nodejs.org/en/)
- Install [Webdriver-manager](https://www.npmjs.com/package/webdriver-manager) from npm:
    - npm install -g webdriver-manager
    - webdriver-manager update
    - webdriver-manager start
- By default, the selenium server will run on http://localhost:4444/wd/hub

## Run tests

- To run tests locally download this project to your computer. With terminal go to the project directory and simply run command: 
     - mvn test
- By default, the project uses chrome as a browser, to specify which browser to use for running tests use command:
     - mvn test -Dbrowser=firefox