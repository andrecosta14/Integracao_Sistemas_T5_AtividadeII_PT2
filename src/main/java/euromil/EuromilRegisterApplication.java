package euromil;

// Importing necessary Spring Boot classes for application initialization
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Euromil Register application.
 * The @SpringBootApplication annotation signifies that this class is the main
 * configuration and bootstrap point for the Spring Boot application.
 */
@SpringBootApplication
public class EuromilRegisterApplication {

  /**
   * Main method to launch the application.
   * This method uses SpringApplication.run() to start the embedded server and
   * initialize the Spring Boot context.
   *
   * @param args command-line arguments passed to the application.
   */
  public static void main(String[] args) {
    SpringApplication.run(EuromilRegisterApplication.class, args);
  }
}
