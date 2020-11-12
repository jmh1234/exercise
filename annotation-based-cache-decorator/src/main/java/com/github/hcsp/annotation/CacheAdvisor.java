package com.github.hcsp.annotation;

import net.bytebuddy.implementation.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

public class CacheAdvisor {
    private static ConcurrentHashMap<CacheKey, CacheValue> concurrentHashMap = new ConcurrentHashMap<>();

    @RuntimeType
    @SuppressWarnings("unused")
    public static Object cache(@SuperCall Callable<List<Object>> zuper,
                               @Origin Method method,
                               @This Object thisObject,
                               @AllArguments Object[] arguments) throws Exception {
        CacheKey cacheKey = new CacheKey(method.getName(), thisObject, arguments);
        CacheValue cacheValue = concurrentHashMap.get(cacheKey);
        if (cacheValue != null) {
            if (isMatchCacheTime(cacheValue, method)) {
                return getRealMethodResult(zuper, cacheKey);
            } else {
                return cacheValue.value;
            }
        } else {
            return getRealMethodResult(zuper, cacheKey);
        }
    }

    private static List<Object> getRealMethodResult(Callable<List<Object>> zuper, CacheKey cacheKey) throws Exception {
        List<Object> resultOfQueryList = zuper.call();
        concurrentHashMap.put(cacheKey, new CacheValue(resultOfQueryList, System.currentTimeMillis()));
        return resultOfQueryList;
    }

    private static boolean isMatchCacheTime(CacheValue cacheValue, Method method) {
        long time = cacheValue.time;
        int cacheSeconds = method.getAnnotation(Cache.class).cacheSeconds();
        return System.currentTimeMillis() - time > cacheSeconds * 1000;
    }
}
