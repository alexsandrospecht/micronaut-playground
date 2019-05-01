package micronaut.playgroung;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/hello")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Get
    public String hello(@QueryValue(defaultValue = "World!", value = "name") String name) {
        logger.info("Sending hello to: {}", name);

        return "Hello " + name;
    }
}