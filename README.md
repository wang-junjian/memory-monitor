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
svchost.exe

2018-11-26 21:22:20
--------------------------------------------------------------------------------

Name: java.exe  Process ID: 2692  Memory Usage: 33564 KB

Operating System used memory: 715 MB
Operating System free memory: 3379 MB
```
[时间间隔] 单位：分钟，默认为1分钟。
