package nacharymntests;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LowLevelClientTest {

    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer.class);

    HttpClient client = HttpClient.create(embeddedServer.getURL());

    @Test
    void testHello() {
        assertEquals("Hello Jeff", client.toBlocking().retrieve("/employee/hello/Jeff"));
    }

    @Test
    void testGoodbye() {
        assertEquals("Goodbye Jeff", client.toBlocking().retrieve("/employee/goodbye/Jeff"));
    }
}
