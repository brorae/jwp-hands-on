package reflection;

import annotation.Controller;
import annotation.Repository;
import annotation.Service;
import java.lang.annotation.Annotation;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ReflectionsTest {

    private static final Logger log = LoggerFactory.getLogger(ReflectionsTest.class);

    @Test
    void showAnnotationClass() throws Exception {
        Reflections reflections = new Reflections("examples");

        logClassAnnotatedWith(reflections, Controller.class);
        logClassAnnotatedWith(reflections, Service.class);
        logClassAnnotatedWith(reflections, Repository.class);
    }

    private void logClassAnnotatedWith(Reflections reflections, Class<? extends Annotation> annotation) {
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(annotation);
        for (Class<?> aClass : classes) {
            log.info("class: {}", aClass);
        }
    }
}
