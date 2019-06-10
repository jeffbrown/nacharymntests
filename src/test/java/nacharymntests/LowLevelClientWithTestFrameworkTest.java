package nacharymntests;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class LowLevelClientWithTestFrameworkTest {

    @Client("/")
    @Inject
    HttpClient client;

    @Test
    void testHello() {
        assertEquals("Hello Jeff", client.toBlocking().retrieve("/employee/hello/Jeff"));
    }

    @Test
    void testGoodbye() {
        assertEquals("Goodbye Jeff", client.toBlocking().retrieve("/employee/goodbye/Jeff"));
    }
}
