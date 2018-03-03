package id.web.frizky.runtime.programming;

import id.web.frizky.runtime.programming.domain.Animal;
import id.web.frizky.runtime.programming.domain.Mouse;
import javassist.*;

public class RunJavassist {
    public static void main(String[] args) {
        RunJavassist runJavassist = new RunJavassist();
        runJavassist.run(2);
    }

    private void run(int i) {
        switch (i) {
            case 1:
                preJavassist();
                break;
            case 2:
                try {
                    postJavassist();
                } catch (NotFoundException | IllegalAccessException | InstantiationException | CannotCompileException e) {
                    System.out.println("SOMETHING BAD HAPPENDS");
                }
                break;
        }
    }

    private void postJavassist() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {
        ClassPool cp = ClassPool.getDefault();
        CtClass aClass = cp.get("id.web.frizky.runtime.programming.domain.Mouse");
        aClass.setInterfaces(new CtClass[]{cp.get("id.web.frizky.runtime.programming.domain.Animal")});
        aClass.addMethod(CtNewMethod.make("public void functionGenericToAnimal() { System.out.println(\"Jerry doing functionGenericToAnimal\"); }",aClass));
        Object instance = aClass.toClass().newInstance();
        if (instance instanceof Animal) {
            ((Animal) instance).functionGenericToAnimal();
            System.out.println("Jerry is an animal");
        }
        if (instance instanceof Mouse) {
            ((Mouse) instance).functionSpecificToMouse();
            System.out.println("Jerry is a mouse");
        }
    }

    private void preJavassist() {
        Object instance = new Mouse();
        if (instance instanceof Animal) {
            ((Animal) instance).functionGenericToAnimal();
            System.out.println("Jerry is an animal");
        }
        ((Mouse) instance).functionSpecificToMouse();
        System.out.println("Jerry is not animal");
    }
}
