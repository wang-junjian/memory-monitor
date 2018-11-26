package com.wangjunjian.command;

public class TaskKillCommand extends Command {
    public static String formatCommand(int processId) {
        String format = "taskkill /PID %d /F";
        return String.format(format, processId);
    }

    public static void main(String[] args) {
        TaskKillCommand command = new TaskKillCommand();
        String commandText = command.formatCommand(3048);
        int exitValue = command.exec(commandText);
        System.out.println(String.format("exitValue: %d", exitValue));
    }
}
