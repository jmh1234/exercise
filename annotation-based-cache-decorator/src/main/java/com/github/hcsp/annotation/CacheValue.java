package com.github.hcsp.annotation;

class CacheValue {
    Object value;
    long time;

    CacheValue(Object value, long time) {
        this.value = value;
        this.time = time;
    }
}
