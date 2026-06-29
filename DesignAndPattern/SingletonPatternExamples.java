class Logger {

    // Private static instance
    private static Logger instance;

    // Private constructor
    private Logger() {
        System.out.println("Logger Instance Created");
    }

    // Public method to get the single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method for logging messages
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class SingletonPatternExamples {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        logger1.log("Application Started");

        Logger logger2 = Logger.getInstance();
        logger2.log("Processing Data");

        if (logger1 == logger2) {
            System.out.println("Both logger references point to the same instance.");
        } else {
            System.out.println("Different instances created.");
        }
    }
}
