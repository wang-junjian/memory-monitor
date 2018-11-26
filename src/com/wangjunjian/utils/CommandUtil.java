package com.wangjunjian.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CommandUtil {
    private List<String> lines = new ArrayList<String>();

    public int exec(String command) {
        lines.clear();

        try {
            String line;
            java.lang.Process process = Runtime.getRuntime().exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = input.readLine()) != null) {
                lines.add(line);
            }
            input.close();
            return process.exitValue();
        } catch (Exception err) {
            err.printStackTrace();
        }

        return -1;
    }

    public List<String> getOutputLines() {
        return lines;
    }

    public String getOutputString() {
        StringBuilder sb = new StringBuilder();

        for (String line : lines) {
            sb.append(line).append(System.lineSeparator());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        CommandUtil commandUtil = new CommandUtil();
        int exitValue = commandUtil.exec("tasklist /FO CSV /NH");
        System.out.println(String.format("exitValue: %d", exitValue));
        System.out.println(commandUtil.getOutputString());
    }

}
