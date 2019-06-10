package nacharymntests;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class DeclarativeClientWithTestFrameworkTest {

    @Inject
    EmployeeClient client;

    @Test
    void testHello() {
        assertEquals("Hello Jeff", client.hello("Jeff"));
    }

    @Test
    void testGoodbye() {
        assertEquals("Goodbye Jeff", client.goodbye("Jeff"));
    }
}

@Client(value = "/", path = "/employee")
interface EmployeeClient {

    @Get("/hello/{name}")
    String hello(String name);

    @Get("/goodbye/{name}")
    String goodbye(String name);
}
