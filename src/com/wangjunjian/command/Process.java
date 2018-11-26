package com.wangjunjian.command;

public class Process {
    private String name;
    private int id;
    private int memoryUsage;

    public Process(String name, int id, int memoryUsage) {
        this.name = name;
        this.id = id;
        this.memoryUsage = memoryUsage;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getMemoryUsageKB() {
        return memoryUsage;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("  ")
                .append("Process ID: ").append(id).append("  ")
                .append("Memory Usage: ").append(memoryUsage).append(" KB");

        return sb.toString();
    }
}
