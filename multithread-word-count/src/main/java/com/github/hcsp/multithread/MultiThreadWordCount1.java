package com.github.hcsp.multithread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadWordCount1 {
    // 使用threadNum个线程，并发统计文件中各单词的数量
    public static Map<String, Integer> count(int threadNum, List<File> files) {
        ExecutorService threadPool = Executors.newFixedThreadPool(threadNum);
        try {

            String path = "C:\\Users\\86158\\Desktop\\1571383015316\\test.txt";
            File file = new File(path);
            // 读取文件
            final BufferedReader reader = new BufferedReader(new FileReader(file));
            // 任务结束返回结果的集合
            List<Future<Map<String, Integer>>> totalResult = new ArrayList<>();
            // 最后返回的集合
            Map<String, Integer> finalResult = new LinkedHashMap<>();
            for (int i = 0; i < threadNum; i++) {
                final int id = i;
                // 一个线程读取一行文字
                Future<Map<String, Integer>> singleResult = threadPool.submit(new Callable<Map<String, Integer>>() {
                    @Override
                    public Map<String, Integer> call() throws Exception {
                        String line;
                        Map<String, Integer> result = new LinkedHashMap<>();
                        while ((line = reader.readLine()) != null) {
                            // 每一行以空格分隔
                            System.out.println(Thread.currentThread().getName() + " ：" + id + " ：" + line);
                            String[] words = line.split(" ");
                            // 把每个单词存到map里
                            for (String word : words) {
                                result.put(word, result.getOrDefault(word, 0) + 1);
                            }
                        }
                        return result;
                    }
                });
                totalResult.add(singleResult);
            }

            for (Future<Map<String, Integer>> future : totalResult) {
                // 把每一个future对象里的map集合合并到 finalResult
                Map<String, Integer> lineMapData = future.get();
                // 遍历finalResult
                for (Map.Entry<String, Integer> entry : lineMapData.entrySet()) {
                    finalResult.put(entry.getKey(), finalResult.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }
            }
            return finalResult;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            threadPool.shutdown();
        }
    }
}
