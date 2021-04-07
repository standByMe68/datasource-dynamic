package com.standbyme.datasourcedynamic.util;

import com.standbyme.datasourcedynamic.domain.NoticeDetail;

import java.lang.reflect.Field;

/**
 * 暂时只能做一层
 * @param <T>
 */
public class NullUtil<T> {

    public static<T> T stringForNull(T t) throws IllegalAccessException {
        Class<?> clazz = t.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Class<?> type = declaredField.getType();
            if (type == String.class) {
                Object o = declaredField.get(t);
                if (o == null) {
                    declaredField.set(t, "");
                } else {
                    //判断当前对象不是自定义对象
                }
            }
        }
        return t;
    }

}
