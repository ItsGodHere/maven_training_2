package fr.lernejo.tester.api.internal;

import fr.lernejo.tester.SomeLernejoTests;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TestClassDescriptionTests {

    @Test
    void listTestMethods() throws NoSuchMethodException {
        Class<SomeLernejoTests> testClass = SomeLernejoTests.class;
        TestClassDescription tcd = new TestClassDescription(testClass);
        List<Method> result = tcd.listTestMethods();
        List<Method> result_expected = new ArrayList<>();
        result_expected.add(testClass.getDeclaredMethod("ok"));
        result_expected.add(testClass.getDeclaredMethod("ko"));

        Assertions.assertThat(result).as("test listTestMethods").isEqualTo(result_expected);

    }
}
