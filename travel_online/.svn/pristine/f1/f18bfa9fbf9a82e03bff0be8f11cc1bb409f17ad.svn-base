package com.regino.travel.factory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class JdkProxyFactory {

    // 提供一个生产日志记录的代理对象方法
    // target是目标对象，proxy是代理对象
    public static Object createLogProxy(Object target) {
        Object proxy = null;

        // 根据工具类创建代理对象
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        proxy = Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            // 实现对方法的增强
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 实现日志记录
                StringBuffer stringBuffer = new StringBuffer();
                // 记录日志时间
                stringBuffer.append(" [执行时间]：" + LocalDateTime.now()); // jdk1.8提供的新特性：获取当前时间
                // 执行哪个类
                stringBuffer.append(" [执行目标类]：" + target.getClass().getName());
                // 执行哪个方法
                stringBuffer.append(" [执行目标方法]：" + method.getName());
                // 执行方法传递的参数
                stringBuffer.append(" [方法实际参数]：" + Arrays.toString(args));
                // 先调用目标对象原有的功能
                Object invoke = null;
                try {
                    invoke = method.invoke(target, args);
                } catch (Exception e) {
                    e.printStackTrace();
                    // 记录异常信息
                    stringBuffer.append(" [异常信息]：" + e.getMessage());
                }
                // 将本次日志信息保存到日志文件
                LocalDate localDate = LocalDate.now();
                String formatted = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                File file = new File("D:/logs/travel" + formatted + ".log"); // 需要创建logs文件夹

                // 使用高效字符缓冲流，或hutool工具包
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
                bufferedWriter.write(stringBuffer.toString()); // 追加
                bufferedWriter.newLine(); // 换行
                bufferedWriter.close();

                return invoke;
            }
        });
        return proxy;
    }
}
