package fr.lernejo.tester.api.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestClassDescription {
    Class<?> tcd;

    public TestClassDescription(Class<?> param) {
        this.tcd = param;
    }

    public List<Method> listTestMethods () {
        List<Method> methods = List.of(this.tcd.getDeclaredMethods());
        List<Method> final_method = new ArrayList<>();
        for (Method method : methods)
            if (method.isAnnotationPresent(TestMethod.class) &&
                Modifier.isPublic(method.getModifiers()) &&
                method.getReturnType().equals(Void.TYPE) &&
                method.getParameterCount()==0) {
                final_method.add(method);
            }
        return final_method;
    }
}
