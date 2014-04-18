package demo;

import arquillian.ArquillianWarBase;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FoobarTest extends ArquillianWarBase {
    @Inject
    Foobar foobar;

    @Test
    public void shouldGetHello() {
        assertEquals( "hello", foobar.hello() );
    }

    @Test
    public void shouldHaveSlept() throws Exception {
        assertTrue( foobar.profiledCall() >= Foobar.SLEEP_TIME );
    }
}
