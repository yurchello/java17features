package com.example.java17features.controller.seal;

public sealed interface Flyable permits Animal, Entity, SuperFlyable {
    void fly();
}
