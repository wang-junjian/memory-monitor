package com.wangjunjian;

import com.wangjunjian.monitor.Monitor;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        long monitorSleepTimeMinute = 1;
        long monitorSleepTime = Monitor.getMonitorSleepTime(monitorSleepTimeMinute);
        if (args.length >= 1) {
            try {
                monitorSleepTimeMinute = Long.parseLong(args[0]);
                monitorSleepTime = Monitor.getMonitorSleepTime(monitorSleepTimeMinute);
            } catch (NumberFormatException e) {

            }
        }

        System.out.println(String.format("Monitoring interval time: %d Minute\n", monitorSleepTimeMinute));
        Monitor monitor = new Monitor(monitorSleepTime);
        monitor.loadTasks();
        monitor.run();
    }

}
