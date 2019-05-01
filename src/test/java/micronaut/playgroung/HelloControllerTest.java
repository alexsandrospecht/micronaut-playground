package micronaut.playgroung;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class HelloControllerTest {

    @Inject
    @Client("/")
    private RxHttpClient client;

    @Test
    public void testHello() throws Exception {
        final HttpRequest request = HttpRequest.GET("/hello");
        final String body = client.toBlocking().retrieve(request);

        assertNotNull(body);
        assertEquals("Hello World!", body);
    }

    @Test
    public void testWithQueryParam() {
        final HttpRequest request = HttpRequest.GET("/hello?name=Alex");
        final String body = client.toBlocking().retrieve(request);

        assertNotNull(body);
        assertEquals("Hello Alex", body);
    }
}
