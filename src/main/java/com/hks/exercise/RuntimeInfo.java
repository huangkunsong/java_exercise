package com.hks.exercise;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class RuntimeInfo {
    public static void main(String[] args) {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        Runtime runtime = Runtime.getRuntime();

        //空闲内存
        long freeMemory = runtime.freeMemory();
        //内存总量
        long totalMemory = runtime.totalMemory();
        //最大允许使用的内存
        long maxMemory = runtime.maxMemory();
        //操作系统
        String os = System.getProperty("os.name");

        //程序启动时间
        long startTime = runtimeMXBean.getStartTime();

        //类所在路径
        String classPath = runtimeMXBean.getBootClassPath();
        //程序运行时间
        long uptime = runtimeMXBean.getUptime();

        //线程总数
        int threadCount = ManagementFactory.getThreadMXBean().getThreadCount();

        //进程名
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String hostName = "";
        String ip = "";
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            ip = localHost.getHostAddress();
            hostName = localHost.getHostName();
        } catch (UnknownHostException e) {
        }

        System.out.println("freeMemory：" + freeMemory);
        System.out.println("totalMemory：" + totalMemory);
        System.out.println("maxMemory：" + maxMemory);
        System.out.println("os：" + os);
        System.out.println("startTime：" + startTime);
        System.out.println("classPath：" + classPath);
        System.out.println("uptime：" + uptime);
        System.out.println("threadCount：" + threadCount);
        System.out.println("name：" + name);
        System.out.println("hostName：" + hostName);
        System.out.println("ip：" + ip);
    }
}
