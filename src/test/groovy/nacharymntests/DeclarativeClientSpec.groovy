package nacharymntests

import io.micronaut.context.ApplicationContext
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class DeclarativeClientSpec extends Specification {

    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

    @Shared
    AnotherEmployeeClient client = embeddedServer.applicationContext.getBean(AnotherEmployeeClient)

    void "test hello"() {
        expect:
        client.hello('Jeff') == 'Hello Jeff'
    }

    void "test goodbye"() {
        expect:
        client.goodbye('Jeff') == 'Goodbye Jeff'
    }
}

@Client(value = '/', path = '/employee')
interface AnotherEmployeeClient {

    @Get('/hello/{name}')
    String hello(String name)

    @Get('/goodbye/{name}')
    String goodbye(String name)
}