package nacharymntests;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/employee")
public class EmployeeController {

    @Get("/hello/{name}")
    public String hello(String name) {
        return "Hello " + name;
    }

    @Get("/goodbye/{name}")
    public String goodbye(String name) {
        return "Goodbye " + name;
    }
}