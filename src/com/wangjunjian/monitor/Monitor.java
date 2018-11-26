package com.wangjunjian.monitor;

import com.wangjunjian.command.Process;
import com.wangjunjian.command.TaskListCommand;
import com.sun.management.OperatingSystemMXBean;
import com.wangjunjian.utils.DatetimeUtil;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.util.*;

public class Monitor {
    public static final String MONITOR_LOG = "monitor.log";
    public static final String MONITOR_PROGRAM = "monitor_program.txt";
    public static final String SEPARATION_LINE = "-".repeat(80);

    public Set<String> pragramNames = new HashSet<>();
    private long monitorSleepTime = 0;

    public Monitor(long monitorSleepTime) {
        this.monitorSleepTime = monitorSleepTime;
    }

    public void loadTasks() throws IOException {
        System.out.println("Load monitor program:");

        FileInputStream inputStream = new FileInputStream(MONITOR_PROGRAM);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line = null;
        while((line = bufferedReader.readLine()) != null)  {
            pragramNames.add(line);

            System.out.println(line);
        }
        System.out.println();

        inputStream.close();
        bufferedReader.close();
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(MONITOR_LOG);

        while (true) {
            StringBuilder sb = new StringBuilder();

            TaskListCommand command = new TaskListCommand();
            int exitValue = command.exec();

            if (exitValue == 0) {
                List<Process> processes = command.parse();

                sb.append(DatetimeUtil.now()).append(System.lineSeparator());
                sb.append(SEPARATION_LINE).append(System.lineSeparator());

                for (Process process : processes) {
                    if (pragramNames.contains(process.getName())) {
                        sb.append(process.toString()).append(System.lineSeparator());
                    }
                }

                sb.append(System.lineSeparator());
            } else {
                System.out.println(String.format("exit value: %d", exitValue));
            }

            final int BYTE_2_MB = 1024 * 1024;

            OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
            long totalMemory = operatingSystemMXBean.getTotalPhysicalMemorySize();
            long freeMemory = operatingSystemMXBean.getFreePhysicalMemorySize();
            long usedMemory = totalMemory - freeMemory;
            sb.append(String.format("Operating System used memory: %d MB", usedMemory / BYTE_2_MB)).append(System.lineSeparator());
            sb.append(String.format("Operating System free memory: %d MB", freeMemory / BYTE_2_MB)).append(System.lineSeparator());
            sb.append(System.lineSeparator());

            printWriter.write(sb.toString());
            printWriter.flush();

            System.out.println(sb.toString());

            sleep(monitorSleepTime);
        }
    }

    public static long getMonitorSleepTime(long monitorSleepTimeMinute) {
        final long MINUTE = 60 * 1000;
        final long defaultMonitorSleepTime = 1;

        long monitorSleepTime = defaultMonitorSleepTime;

        if (monitorSleepTimeMinute > 0) {
            monitorSleepTime = monitorSleepTimeMinute;
        }

        return monitorSleepTime * MINUTE;
    }

}
