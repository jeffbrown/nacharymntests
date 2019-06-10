package nacharymntests

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class LowLevelClientSpec extends Specification {

    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

    @Shared
    @AutoCleanup
    HttpClient client = HttpClient.create(embeddedServer.URL)

    void "test hello"() {
        expect:
        client.toBlocking().retrieve("/employee/hello/Jeff") == 'Hello Jeff'
    }

    void "test goodbye"() {
        expect:
        client.toBlocking().retrieve("/employee/goodbye/Jeff") == 'Goodbye Jeff'
    }
}
