package demo;

import arquillian.ArquillianWarBase;
import org.junit.Test;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RestFoobarTest extends ArquillianWarBase {
    @Inject
    Client client;

    static final String BASE_URL = "http://localhost:1119/demo/";

    @Test
    public void getHello() {
        String url = BASE_URL + "hello";
        Response response = client.target( url ).request(MediaType.TEXT_PLAIN_TYPE ).get();
        String text = response.readEntity( String.class );
        assertEquals( "hello", text );
    }

    @Test
    public void getProfile() {
        String url = BASE_URL + "profile";
        Response response = client.target( url ).request(MediaType.TEXT_PLAIN_TYPE ).get();
        long time = response.readEntity( Long.class );
        assertTrue( time >= RestFoobar.SLEEP_TIME );
    }
}
