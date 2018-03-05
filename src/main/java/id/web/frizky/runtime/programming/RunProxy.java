package id.web.frizky.runtime.programming;

import id.web.frizky.runtime.programming.domain.Animal;
import id.web.frizky.runtime.programming.domain.Cat;

import java.lang.reflect.Proxy;

public class RunProxy {
    public static void main(String[] args) {
        RunProxy runProxy = new RunProxy();
        runProxy.run(2);
    }

    private void run(int i) {
        switch (i) {
            case 1:
                preProxy();
                break;
            case 2:
                postProxy();
                break;
        }
    }

    private void postProxy() {
        Animal newProxyInstance = (Animal) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Animal.class}, new Cat());
        System.out.println(newProxyInstance.getSound());
    }

    private void preProxy() {

    }

}
