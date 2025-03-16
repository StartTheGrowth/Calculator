import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger log = LogManager.getLogger("");

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        log.info("info");
        log.error("finer");
    }
}