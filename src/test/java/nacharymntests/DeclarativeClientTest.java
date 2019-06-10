package nacharymntests;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Client(value = "/", path = "/employee")
interface AnotherEmployeeClient {

    @Get("/hello/{name}")
    String hello(String name);

    @Get("/goodbye/{name}")
    String goodbye(String name);
}

class DeclarativeClientTest {

    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer.class);

    AnotherEmployeeClient client = embeddedServer.getApplicationContext().getBean(AnotherEmployeeClient.class);

    @Test
    void testHello() {
        assertEquals("Hello Jeff", client.hello("Jeff"));
    }

    @Test
    void testGoodbye() {
        assertEquals("Goodbye Jeff", client.goodbye("Jeff"));
    }
}