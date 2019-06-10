package nacharymntests

import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class LowLevelClientWithTestFrameworkSpec extends Specification {

    @AutoCleanup
    @Shared
    @Inject
    @Client("/")
    HttpClient client

    void "test hello"() {
        expect:
        client.toBlocking().retrieve("/employee/hello/Jeff") == 'Hello Jeff'
    }

    void "test goodbye"() {
        expect:
        client.toBlocking().retrieve("/employee/goodbye/Jeff") == 'Goodbye Jeff'
    }
}
