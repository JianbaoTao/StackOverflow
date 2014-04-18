package demo;

import javax.inject.Inject;
import java.util.logging.Logger;

public class Foobar {

    public static final int SLEEP_TIME = 1000; // in milliseconds

    @Inject
    Logger logger;

    public String hello() {
        return "hello";
    }

    @Profiled
    public long profiledCall() throws Exception {
        long startTime = System.currentTimeMillis();
        Thread.sleep( SLEEP_TIME );
        return System.currentTimeMillis() - startTime;
    }

}
