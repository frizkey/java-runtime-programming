package id.web.frizky.runtime.programming.domain;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Cat implements Animal, InvocationHandler {
    public String sound = "MEOW";

    public void functionGenericToAnimal() {
        System.out.println("Cat doing functionGenericToAnimal");
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("RUN INVOKE");
        return method.invoke(this, args);
    }
}
