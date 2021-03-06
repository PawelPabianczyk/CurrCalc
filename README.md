# CurrCalc
CurrCalc - a desktop application made for the first stage of recruitment to [Remitly Poland](https://www.remitly.com/us/en/poland). The goal was to create a program that would download data from the NBP API (exchange rate value) and then convert PLN to GBP and vice versa.

<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
        <li><a href="#tools-used">Tools Used</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

## About The Project

![Main Page](/readme_img/home.png)

CurrCalc is a desktop application made in Java (logic part) and JavaFX (visual part) technology. In addition, unit tests were performed in the JUnit 5 technology.

### Built With
* [Java](https://www.java.com/pl/)
* [JavaFX](https://openjfx.io/)
* [JUnit 5](https://junit.org/junit5/)

### Tools Used
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)
* [Scene Builder](https://gluonhq.com/products/scene-builder/)

## Getting Started

The project is created in JavaFX and JDK 11, so after downloading the repository you should:
* Download [JavaFX SDK 11](https://gluonhq.com/products/javafx/)
* Unpack the zip file
* Open a command prompt in the src directory
* Compile the application by entering the command:
```powershell
javac --module-path "[path to your javafx sdk]" --add-modules javafx.controls,javafx.fxml Main.java
```
* Run the program with the command:
```powershell
java --module-path "path to your javafx sdk" --add-modules javafx.controls,javafx.fxml Main.java
```

**For full functionality, the application requires a permanent connection to the Internet.**


## Usage

![Main Page](/readme_img/home.png)

Application start page.<br/><br/>

![Main Page](/readme_img/error.png)

If there is no internet connection, the application will display an error message.<br/><br/>

![Main Page](/readme_img/tests1.png)

I added unit tests to the project (screenshot from Intellij IDEA)<br/><br/>

![Main Page](/readme_img/tests2.png)

Further unit tests (screenshot from Intellij IDEA)<br/><br/>

## Contact

Email - pawel.pabianczyk1999@gmail.com

LinkedIn - [Pawel Pabianczyk](https://www.linkedin.com/in/pawel-pabianczyk/)

Project Link: [https://github.com/PawelPabianczyk/CurrCalc](https://github.com/PawelPabianczyk/CurrCalc)
