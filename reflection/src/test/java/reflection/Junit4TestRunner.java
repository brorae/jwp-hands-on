package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

class Junit4TestRunner {

    @Test
    void run() throws Exception {
        final Class<Junit4Test> clazz = Junit4Test.class;
        final Object object = clazz.getDeclaredConstructor().newInstance();
        for (final Method method : clazz.getDeclaredMethods()) {
            for (final Annotation annotation : method.getAnnotations()) {
                if (annotation.annotationType().equals(MyTest.class)) {
                    method.invoke(object);
                }
            }
        }
    }
}
