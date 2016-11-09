package training;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Christina on 10-Nov-16.
 */
public class InvHandler implements InvocationHandler{
    private Object obj;

    public InvHandler(Object object) {
        this.obj = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("get")) {
            return method.invoke(obj, args);
        } else {
            throw new IllegalAccessException("Setters are not available!");
        }
    }
}
