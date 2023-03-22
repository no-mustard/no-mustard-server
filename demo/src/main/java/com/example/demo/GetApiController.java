package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController // 주소 부여
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello")
    public String getHello() { // http://localhost:8080/api/get/hello
        return "get Hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET) // get http://localhost:8080/api/get/hi
    public String hi() {
        return "hi";
    }

    // http://localhost:8080/api/get/path-variable/{name}
    // http://localhost:8080/api/get/path-variable/{g2} ...

    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name) {
        System.out.println("PathVariable : " + name);

        return name;
    }

    @GetMapping(path = "query-param")
    //http://localhost/api/get/query-param?user=g2&email=hon9g2@gmail.com&age=30
    public String queryParam(@RequestParam Map<String, String> queryParam) {
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }
}