import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        divide(5, 0);
    }

    public static int divide(int a, int b){
        if (b == 0) {
            LOG.error("Parameter b={}",b);
            System.out.printf("Parameter b=%d\n", b);
            throw new IllegalArgumentException();
        }
        return a/b;
    }
}
