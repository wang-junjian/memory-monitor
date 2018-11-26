# Memory Monitor

## Config
* monitor_program.txt 监控的程序，一行一个。
``` txt
java.exe
```

* monitor.log 监控日志
``` txt
2018-11-26 21:22:20
--------------------------------------------------------------------------------

Name: java.exe  Process ID: 2692  Memory Usage: 33564 KB

Operating System used memory: 715 MB
Operating System free memory: 3379 MB
```

## Run
``` bash
c:\>java -jar memory-monitor.jar [时间间隔]
Monitoring interval time: 2 Minute

Load monitor program:
java.exe

2018-11-26 21:22:20
--------------------------------------------------------------------------------

Name: java.exe  Process ID: 2692  Memory Usage: 33564 KB

Operating System used memory: 715 MB
Operating System free memory: 3379 MB
```
[时间间隔] 单位：分钟，默认为1分钟。

## 参考资料
* [When Runtime.exec() won't Navigate yourself around pitfalls related to the Runtime.exec() method](https://www.javaworld.com/article/2071275/core-java/when-runtime-exec---won-t.html)
* [从 Java 代码到 Java 堆](https://www.ibm.com/developerworks/cn/java/j-codetoheap/)
* [深入分析 Java 中的中文编码问题](https://www.ibm.com/developerworks/cn/java/j-lo-chinesecoding/index.html)
* [How to View All Running Apps & Processes in Mac OS X](http://osxdaily.com/2013/05/17/see-all-running-apps-mac-os-x/)
* [The right way to kill a process in Java](https://stackoverflow.com/questions/35230507/the-right-way-to-kill-a-process-in-java)
* [How to Get a List of Current Open Processes with Java?](https://crunchify.com/how-to-get-a-list-of-current-open-processes-with-java/)
* [jProcesses](https://github.com/profesorfalken/jProcesses/blob/master/src/main/java/org/jutils/jprocesses/util/ProcessesUtils.java)
* [How to get a list of current open windows/process with Java?](https://stackoverflow.com/questions/54686/how-to-get-a-list-of-current-open-windows-process-with-java)
* []()
* [How to do I check CPU and Memory Usage in Java?](https://stackoverflow.com/questions/74674/how-to-do-i-check-cpu-and-memory-usage-in-java)
* [get OS-level system information](https://stackoverflow.com/questions/25552/get-os-level-system-information)
* [java 获取进程ID 物理内存 cpu使用百分比（linux环境）](https://blog.csdn.net/qiezikuaichuan/article/details/49027417)
* [Linux Command: Show Linux Version](https://www.cyberciti.biz/faq/command-to-show-linux-version/)
* [Killing a process using Java](https://stackoverflow.com/questions/6356340/killing-a-process-using-java)
* [Linux kill -9 和 kill -15 的区别](https://www.cnblogs.com/liuhouhou/p/5400540.html)
* [Apache Thrift](http://thrift.apache.org)
* [Runtime getRuntime() exec(String command) - How does this work?](https://coderanch.com/t/419192/java/Runtime-getRuntime-exec-String-command)
* [How to get java getRuntime().exec() to run a command-line program with arguments?](https://stackoverflow.com/questions/13467307/how-to-get-java-getruntime-exec-to-run-a-command-line-program-with-arguments)
* [JAVA获取JVM内存空间和物理内存空间](https://blog.csdn.net/u013570100/article/details/80839055)
* [java代码获取在不同系统下的换行符](https://blog.csdn.net/ABCDabcdefghijklmn/article/details/53507315)
* [Java 按行读取文件](https://blog.csdn.net/u010889616/article/details/51477037)
* [Creating, Running and Packaging Your First Java Application](https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html?keymap=secondary_mac_os_x_10.5_)
* [LOG4J Architecture](https://logging.apache.org/log4j/2.x/manual/architecture.html)
* [ps 进程查看器](https://linuxtools-rst.readthedocs.io/zh_CN/latest/tool/ps.html)
* [Command-line Tool to find Java Heap Size and Memory Used (Linux)?](https://stackoverflow.com/questions/12797560/command-line-tool-to-find-java-heap-size-and-memory-used-linux)
* [Simple way to repeat a String in java](https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string-in-java)
* [Converting 'ArrayList<String> to 'String[]' in Java](https://stackoverflow.com/questions/4042434/converting-arrayliststring-to-string-in-java)
