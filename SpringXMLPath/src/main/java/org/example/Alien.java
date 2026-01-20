package org.example;

public class Alien {

    private Computer computer; // dependency

    // ✅ Setter Injection
//    public void setComputer(Computer computer) {
//        this.computer = computer;
//    }

    // ✅ Constructor Injection
    public Alien(Computer computer) {
        this.computer = computer;
    }

    public void code() {
        computer.compile();
    }
}
