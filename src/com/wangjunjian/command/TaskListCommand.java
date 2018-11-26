package com.wangjunjian.command;

import com.wangjunjian.utils.CommandUtil;

import java.util.ArrayList;
import java.util.List;

public class TaskListCommand {
    private final String COMMAND = "tasklist /FO CSV /NH";
    private CommandUtil commandUtil = new CommandUtil();

    public int exec() {
        return commandUtil.exec(COMMAND);
    }

    public List<Process> parse() {
        List<Process> processes = new ArrayList<Process>();

        for (String str : commandUtil.getOutputLines()) {
            if (str.length() == 0)
                continue;

            String[] cols = str.split("\",\"");
            if (cols.length != 5)
                continue;

            String name = cols[0].replace("\"", "");
            int processId = Integer.parseInt(cols[1]);
            int memoryUsage = Integer.parseInt(cols[4].replace(",", "").replace(" K\"", ""));
            Process process = new Process(name, processId, memoryUsage);

            processes.add(process);
        }

        return processes;
    }

    public static void main(String[] args) {
        TaskListCommand command = new TaskListCommand();
        int exitValue = command.exec();
        System.out.println(String.format("exitValue: %d", exitValue));
        List<Process> processes = command.parse();
        System.out.println(processes);
    }
}
