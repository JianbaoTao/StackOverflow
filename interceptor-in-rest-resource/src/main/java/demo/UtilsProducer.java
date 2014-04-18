package demo;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.logging.Logger;

public class UtilsProducer {
    @Produces
    private Logger createLogger( InjectionPoint point ) {
        return Logger.getLogger( point.getMember().getDeclaringClass().getName() );
    }

    @Produces
    private Client createClient() {
        return ClientBuilder.newClient();
    }
}
