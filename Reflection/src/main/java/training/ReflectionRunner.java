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
        showClassName(clazz);
        showMethodsThatUseMethodInfoAnnotation(clazz);
        showConstructorsAndParameters(clazz);
        showModifier(clazz);
    }

    /**
     * Method outputs the class name.
     * @param clazz
     */
    public static void showClassName(Class clazz){
        System.out.println(clazz.getName());
    }

    /**
     * Method outputs the methods that uses MethodInfo annotation.
     * @param clazz
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    public static void showMethodsThatUseMethodInfoAnnotation(Class clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object instance = clazz.newInstance();
        for (Method m : clazz.getMethods()) {
            if (m.isAnnotationPresent(MethodInfo.class)) {
                System.out.println(m.getName() + ' ' + m.invoke(instance));
            }
        }
    }

    /**
     * Method outputs constructors of the class with their parameters.
     * @param clazz
     */
    public static void showConstructorsAndParameters(Class clazz){
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.print(paramType.getName() + " ");
            }
            System.out.println(constructor);
        }
    }

    /**
     * Method outputs the modifier of the class.
     * @param clazz
     */
    public static void showModifier(Class clazz){
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

