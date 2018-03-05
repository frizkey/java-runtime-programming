package id.web.frizky.runtime.programming.domain;

public class Dog implements Animal {

    private String bark = "WOFF";

    public void functionGenericToAnimal() {
        System.out.println("Dog doing functionGenericToAnimal");
    }

    public void setSound(String bark) {
        this.bark = bark;
    }

    @Override
    public String getSound() {
        return bark;
    }
}
