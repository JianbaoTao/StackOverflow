package demo;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@Interceptor
@Profiled
public class Profiler {
    @Inject
    Logger logger;

    @AroundInvoke
    private Object profile( InvocationContext context ) throws Exception {
        long startTime = System.currentTimeMillis();
        try {
            return context.proceed();
        } finally {
            long time = System.currentTimeMillis() - startTime;
            logger.info( context.getMethod() + " took " + time + " milliseconds" );
        }
    }
}
