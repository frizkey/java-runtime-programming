package id.web.frizky.runtime.programming;

import id.web.frizky.runtime.programming.domain.Mouse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunReflection {
    public static void main(String[] args) {
        RunReflection runReflection = new RunReflection();
        runReflection.run(1);
    }

    private void run(int i) {
        switch (i){
            case 1:
                preReflection();
                break;
            case 2:
                try {
                    postReflection();
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void preReflection() {
        Mouse mouse = new Mouse();
        mouse.functionSpecificToMouse();
    }

    private void postReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method functionSpecificToMouse = Mouse.class.getMethod("functionSpecificToMouse");

        Mouse mouse = new Mouse();
        functionSpecificToMouse.invoke(mouse);
    }
}
