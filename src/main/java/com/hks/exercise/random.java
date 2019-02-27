package com.hks.exercise;

import java.util.Random;

/**
 * 获取区间随机数公式
 * (数据类型)(最小值+Math.random()*(最大值-最小值+1))
 * 例：从1到10的int型随数
 * (int)(1+Math.random()*(10-1+1))
 */
public class random {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 1; i <= 10000; i++) {
            int value = (int)(100 + Math.random() * (500 - 100 + 1));
            System.out.println(value);
        }
    }
}
