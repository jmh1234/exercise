# Docker run 练习

这个题目旨在帮助你理解和巩固Docker最重要的命令`docker run`。请按照以下步骤完成挑战：

- `docker pull blindpirate/hcsp-quiz`
- 尝试自己编写一个`docker run`命令，完成以下要求：
  - 使用交互式命令行模式(`-it`)启动Docker容器。
  - 向启动的Docker容器内挂载一个文件（卷），使得容器内能够读取到`/app/config.txt`文件，其内容为字符串"ABC"。
  - 向启动的Docker容器内传递一个环境变量`HCSP_ENV=DEF`。
  - 为启动的Docker容器设置要执行的命令：`java Main`。
- 如果一切正确，命令行会输出：

```
答案是: XXXXX
The answer is: XXXXXXX
```

其中的答案就是我们的题目的答案。
