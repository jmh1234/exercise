package com.github.hcsp.string;

import java.io.UnsupportedEncodingException;

public class MyStringBuilder {
    private StringBuilder sb;

    public MyStringBuilder() {
        sb = new StringBuilder();
    }

    // 在末尾添加一个字符
    public void append(char ch) {
        sb.append(ch);
    }

    // 在末尾添加一个字符串，其数据需要从bytes字节数组中按照charsetName字符集解码得到
    public void append(byte[] bytes, String charsetName) {
        try {
            sb.append(new String(bytes, charsetName));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // 在index指定位置添加一个字符ch
    public void insert(int index, char ch) {
        sb.insert(index, ch);
    }

    // 删除位于index处的字符
    public void deleteCharAt(int index) {
        sb.deleteCharAt(index);
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
