package com.spring;

import javax.annotation.Resource;
import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;

/**
 * @Auther: gzq
 * @Date: 2021/4/22 - 04 - 22 - 18:16
 * @Description: com.spring
 */
public class GzqApplicationContext {
    private Class configClass;

    public GzqApplicationContext(Class configClass) {
        this.configClass = configClass;
        // 解析配置
        ComponentScan componentScanAnnotation = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
        String path = componentScanAnnotation.value();
        path = path.replace(".", "/");
//        System.out.println(path);
        // 扫描
        ClassLoader classLoader = GzqApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource(path);
        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                String fileName = f.getAbsolutePath();
                if (fileName.endsWith(".class")) {

                }
                String className = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class"));
                className = className.replace("\\", ".");
                System.out.println(className);

                Class<?> clazz = null;
                try {
                    clazz = classLoader.loadClass(className);
                    if (clazz.isAnnotationPresent(Component.class)) {
                          // 当前类是一个bean
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public Object getBean(String beanName) {
        return null;
    }
}
