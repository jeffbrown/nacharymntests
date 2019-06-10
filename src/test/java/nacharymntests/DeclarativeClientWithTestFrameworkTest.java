package nacharymntests;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Client(value = "/", path = "/employee")
interface EmployeeClient {

    @Get("/hello/{name}")
    String hello(String name);

    @Get("/goodbye/{name}")
    String goodbye(String name);
}

@MicronautTest
class DeclarativeClientWithTestFrameworkTest {

    @Inject
    EmployeeClient client;

    void testHello() {
        assertEquals("Hello Jeff", client.hello("Jeff"));
    }

    void testGoodbye() {
        assertEquals("Goodbye Jeff", client.goodbye("Jeff"));
    }
}