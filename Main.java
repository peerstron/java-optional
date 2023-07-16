// Reference material
// https://tomgregory.com/java-optional/

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello to Optionals...");

        Footballer footballer = new Footballer();

        // Optional is simply a container for an Object and so it can hold one of two states:
        // either the container contains an Object or the container is empty

        // 1. Optional with an Object in the container
        Optional<Footballer> footballerOptional = Optional.of(footballer);

        // 2. Optional with an empty container
        Optional<Footballer> emptyFootballerOptional = Optional.empty();


//        *************************
//        Why Optionals?
//        *************************
//        Before Java 8, when we have say a REST endpoint that findsFootballerByName,
//        it's either our code will return the found Footballer or return NULL if not found.
//        Null, when not handled properly could throw a NullPointerException which could break our code.
//        So the burden was on both the backend developer and the frontend developer to always remember to handle it.
//        This is one of the many other reasons why Optional was introduced in Java 8 in 2014.

        List<String> myPlayers = Arrays.asList("Pele", "Ayew", "Mboma", "Lampard");

        Optional<Footballer> playMaker = footballer.findFootballerByName(myPlayers, "Pele");

        System.out.println(playMaker);
    }

    static class Footballer {
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Footballer{" +
                    "name='" + name + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        private String name;

        Footballer() {

        }
        Footballer(String name) {
            this.name = name;
        }

        public Optional<Footballer> findFootballerByName(List players, String na) {
            if(players.contains(na)){
                return Optional.of(new Footballer(na));
            }
            return Optional.empty();
        }
    }
}
