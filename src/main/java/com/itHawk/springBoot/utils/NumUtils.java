package com.itHawk.springBoot.utils;

/**
 * 用于转换进制的工具类
 *
 * @author IThawk
 */
public class NumUtils {
    /***
     * 16进制转2进制
     * @param  num 16进制数
     * @return 2进制数
     */
    public static String sixteen2Two(String num) {
        String newNum;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            char a = num.charAt(i);
            switch (a) {
                case '0': {
                    newNum = "0000";
                    break;
                }
                case '1': {
                    newNum = "0001";
                    break;
                }
                case '2': {
                    newNum = "0010";
                    break;
                }
                case '3': {
                    newNum = "0011";
                    break;
                }
                case '4': {
                    newNum = "0100";
                    break;
                }
                case '5': {
                    newNum = "0101";
                    break;
                }
                case '6': {
                    newNum = "0110";
                    break;
                }
                case '7': {
                    newNum = "0111";
                    break;
                }
                case '8': {
                    newNum = "1000";
                    break;
                }
                case '9': {
                    newNum = "1001";
                    break;
                }
                case 'A': {
                    newNum = "1010";
                    break;
                }
                case 'B': {
                    newNum = "1011";
                    break;
                }
                case 'C': {
                    newNum = "1100";
                    break;
                }
                case 'D': {
                    newNum = "1101";
                    break;
                }
                case 'E': {
                    newNum = "1110";
                    break;
                }
                default: {
                    newNum = "1111";
                    break;
                }

            }
            stringBuilder.append(newNum);
        }
        return stringBuilder.toString();
    }

    /***
     * 2进制转16进制
     * @param  num 2进制数
     * @return 16进制数
     */
    public static String two2Sixteen(String num) {
        int s = num.length() % 4;
        if (s == 1) {
            num = "000" + num;
        } else if (s == 2) {
            num = "00" + num;
        } else if (s == 3) {
            num = "0" + num;
        }
        int b = num.length() / 4;
        String newNum;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < b; i++) {
            String a = num.substring(i * 4, i * 4 + 4);
            switch (a) {
                case "0001": {
                    newNum = "1";
                    break;
                }
                case "0010": {
                    newNum = "2";
                    break;
                }
                case "0011": {
                    newNum = "3";
                    break;
                }
                case "0100": {
                    newNum = "4";
                    break;
                }
                case "0101": {
                    newNum = "5";
                    break;
                }
                case "0110": {
                    newNum = "6";
                    break;
                }
                case "0111": {
                    newNum = "7";
                    break;
                }
                case "1000": {
                    newNum = "8";
                    break;
                }
                case "1001": {
                    newNum = "9";
                    break;
                }
                case "1010": {
                    newNum = "A";
                    break;
                }
                case "1011": {
                    newNum = "B";
                    break;
                }
                case "1100": {
                    newNum = "C";
                    break;
                }
                case "1101": {
                    newNum = "D";
                    break;
                }
                case "1110": {
                    newNum = "E";
                    break;
                }
                default: {
                    newNum = "F";
                    break;
                }

            }
            stringBuilder.append(newNum);
        }
        return stringBuilder.toString();
    }

    /***
     * 2进制转10进制
     * @param  num 2进制数
     * @return 10进制数
     */
    public static String two2Ten(String num) {

        Long a = 0L;

        for (int i = num.length(); i > 0; i--) {
            a = a + numPower("2", i - 1);
        }
        return a.toString();
    }

    /***
     * 10进制转其他进制
     * @param  num 10进制数
     * @return 小于10的几进制数
     */
    public static String ten2Other(String num, Long systems) {
        Long oldNum = Long.parseLong(num);
        StringBuilder stringBuilder = new StringBuilder();

        while (oldNum >= systems) {
            stringBuilder.append(oldNum % systems);
            oldNum = oldNum / systems;

        }
        stringBuilder.append(oldNum);
        return stringBuilder.reverse().toString();
    }

    /***
     * 10进制转16进制
     * @param  oldNum 10进制数
     * @return 16进制数
     */
    public static String ten2Sixteen(String oldNum) {
        //转换位2进制
        String string = ten2Two(oldNum);
        //转换为16进制
        string = two2Sixteen(string);

        return string;
    }

    /***
     * 10进制转2进制
     * @param  oldNum 10进制数
     * @return 2进制数
     */
    public static String ten2Two(String oldNum) {
        Long systems = 2L;
        return ten2Other(oldNum, systems);
    }

    /***
     * 求一个数的阶乘
     * @param num 要做阶乘是数
     * @param places 阶乘数次数
     * @return
     */
    public static Long numPower(String num, int places) {
        Long oldNum = Long.parseLong(num);

        Long newNum = 1L;
        for (int i = 0; i < places; i++) {
            newNum = oldNum * newNum;
        }
        return newNum;
    }
}
