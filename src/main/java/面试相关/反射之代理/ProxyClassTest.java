package 面试相关.反射之代理;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyClassTest {

    public static void main(String[] args) throws Exception {

        RealSubject target = new RealSubject();

        Object sub = getProxy(target);
        System.out.println(sub instanceof Subject);
        System.out.println(sub.getClass().getName());
    }

    private static Object getProxy(final Object target) throws Exception{

        Class proxyClass =  Proxy.getProxyClass(target.getClass().getClassLoader(), target.getClass().getInterfaces());
        Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);
        Object proxy = constructor.newInstance((InvocationHandler) (proxy1, method, args) -> {
            System.out.println(method.getName() + "方法开始执行。。。。");

            Object result = method.invoke(target, args);
            System.out.println(result);
            System.out.println(method.getName() + "方法结束执行。。。。");
            return result;
        });
        return proxy;

    }


}
