package com.zh.study.refect;

import com.zh.model.User;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by zhangheng on 2017/12/28.
 */
public class TestRefect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //通过ClassLoader创建
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz = classLoader.loadClass("com.zh.model.User");
        User user = (User) clazz.newInstance();

        //通过构造器构建
        Constructor constructor = clazz.getConstructor();
        User user1 = (User) constructor.newInstance();

        Field field = clazz.getDeclaredField("id");
        field.setAccessible(true);
        field.set(user,1234L);

        Method method = clazz.getMethod("setName", String.class);
        method.invoke(user1, "user1");
        method.invoke(user, "user");

        System.out.println(user.getName());
        System.out.println(user.getId());
        System.out.println(user1.getName());

    }
    @Test
    public void sss() throws IOException {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

        Resource[] resources = resourcePatternResolver.getResources("classpath*:application.yml");
        assertNotNull(resources);
        Arrays.stream(resources).forEach(resource -> System.out.print(resource.getDescription()));
    }
}
