import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {

        String name = "John";
        int age = 25;
        double salary = 55000.75;

        logger.info("User Name: {}", name);
        logger.info("User Name: {}, Age: {}", name, age);
        logger.debug("User Name: {}, Age: {}, Salary: {}", name, age, salary);
        logger.warn("User {} has low disk space.", name);
        logger.error("Unable to process request for user {}.", name);
    }
}