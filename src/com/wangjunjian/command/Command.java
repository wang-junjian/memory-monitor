package com.wangjunjian.command;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Command {
    private List<String> outputs = new ArrayList<String>();

    public int exec(String command) {
        outputs.clear();

        try {
            String line;
            java.lang.Process process = Runtime.getRuntime().exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = input.readLine()) != null) {
                outputs.add(line);
            }
            input.close();
            return process.exitValue();
        } catch (Exception err) {
            err.printStackTrace();
        }

        return -1;
    }

    public List<String> getOutputs() {
        return outputs;
    }

    public static void main(String[] args) {
        Command command = new Command();
        int exitValue = command.exec("tasklist /FO CSV /NH");
        System.out.println(String.format("exitValue: %d", exitValue));
        System.out.println(command.getOutputs());
    }
}