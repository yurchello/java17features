package com.example.java17features.controller;

import com.example.java17features.controller.entity.User;
import com.example.java17features.controller.seal.Animal;
import com.example.java17features.controller.seal.Flyable;
import jakarta.websocket.server.PathParam;
import java.time.DayOfWeek;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/feature")
@RestController
public class ControllerWithFeatures {

    private static final String TEXT_BLOCK = """
            Hello, this is a
            multi-line
            text block.
            """;

    @GetMapping("/test")
    public String test() {
        return TEXT_BLOCK;
    }

    @GetMapping("/user-record")
    public User getUserRecord() {
        return new User(1L, "fff", "ggg");
    }

    @GetMapping("/switch-pattern")
    public Integer getSwitchPattern(@PathParam("dayName") String dayName) {
        DayOfWeek day = DayOfWeek.valueOf(dayName);
        return switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> {
                int i = 7;
                yield 6 + i;
            }
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
        };
    }

    @GetMapping("/match-pattern")
    public double getDoubleUsingSwitch() {
        Object o = new Object();
        return switch (o) {
            case Integer i -> i.doubleValue();
            case Float f -> f.doubleValue();
            case String s -> {
                double t = 3;
                yield Double.parseDouble(s) + t;
            }
            default -> 0d;
        };
    }

    @GetMapping("/animal")
    public Animal getUser() {
        // testFly(() -> {}); compilation error
        return new Animal();
    }

    private void testFly(Flyable p) {
    }

}
