package nacharymntests

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Shared
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class DeclarativeClientWithTestFrameworkSpec extends Specification {

    @Shared
    @Inject
    EmployeeClient client

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
interface EmployeeClient {

    @Get('/hello/{name}')
    String hello(String name)

    @Get('/goodbye/{name}')
    String goodbye(String name)
}