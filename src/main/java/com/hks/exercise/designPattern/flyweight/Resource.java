package com.hks.exercise.designPattern.flyweight;

/**
 * 享元类,内部状态作为成员变量,外部状态通过参数传入使用
 */
public class Resource {

    private String code;

    private String content;

    public String getCode() {
        return code;
    }

    public String getContent() {
        return content;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void print(String fileName) {
        System.out.println("File name ：" + fileName);
        System.out.println("code：" + this.code);
        System.out.println("Content：" + this.content);
    }
}
