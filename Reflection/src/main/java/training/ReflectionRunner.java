package training;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Christina on 08-Nov-16.
 */
public class ReflectionRunner {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("training.Notebook");
        Object instance = clazz.newInstance();
        // Output of class name
        System.out.println(clazz.getName());
        // Output of methods that uses MethodInfo annotation
        for (Method m : clazz.getMethods()) {
            if (m.isAnnotationPresent(MethodInfo.class)) {
                System.out.println(m.invoke(instance));
            }
        }
        //Output of method's constructors with their parameters
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.print(paramType.getName() + " ");
            }
            System.out.println(constructor);
        }
        // Output of class modifier
        int modifier = clazz.getModifiers();
        if (Modifier.isPublic(modifier)) {
            System.out.println("public");
        }
        if (Modifier.isAbstract(modifier)) {
            System.out.println("abstract");
        }
        if (Modifier.isFinal(modifier)) {
            System.out.println("final");
        }
    }
}

