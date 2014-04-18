package demo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.logging.Logger;

@Path("/")
public class RestFoobar {
    public static final int SLEEP_TIME = 1000;
    @Inject
    private Logger logger;

    @Inject
    private Foobar foobar;


    @Context
    private UriInfo context;

    @Path("hello")
    @GET
    public String hello() {
        logger.info("Request from " + context.getRequestUri() );
        return "hello";
    }

    @Path("profile")
    @GET
    @Profiled
    public long profile() throws Exception {
        logger.info("Request from " + context.getRequestUri() );
        long startTime = System.currentTimeMillis();
        Thread.sleep( SLEEP_TIME );
        return System.currentTimeMillis() - startTime ;
    }
}
