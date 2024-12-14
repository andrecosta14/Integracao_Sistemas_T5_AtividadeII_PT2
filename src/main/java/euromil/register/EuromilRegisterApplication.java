package euromil.register;

// Imports Spring Boot classes to enable auto-configuration and application bootstrap
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Marks this class as the main entry point for a Spring Boot application
@SpringBootApplication
public class EuromilRegisterApplication {

  // The main method acts as the starting point for the application
  public static void main(String[] args) {

    // Launches the Spring Boot application
    SpringApplication.run(EuromilRegisterApplication.class, args);
  }
}
