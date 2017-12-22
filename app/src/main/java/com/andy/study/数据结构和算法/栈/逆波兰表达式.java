package com.andy.study.数据结构和算法.栈;

import java.util.Stack;

/**
 * Created by 坎坎 on 2017/12/22.
 */

public class 逆波兰表达式 {
   /**
   * 转换方法不通用，只是用来练习 栈
   * */

    /**
     * 举例 中缀表达式  9 +（3-1）* 3 + 10 / 2
     *      后缀  9 3 1 - 3 * + 10 2 / +
    * 规则 数字输出，运算符进栈，括号匹配出栈，入栈时栈顶元素优先级比入栈元素优先级高出栈
    * */
    private static String ss[] ={"9","+","(","3","-","1",")","*","3","+","10","/","2"};
    private static Stack<String> stack=new Stack<>();
    public static void main(String args[]){
        convert();
    }


    public static void convert(){
        for (String s : ss) {
            if(isNumeric(s)){
                //数字输出
                System.out.print(s);
            }else {
                // 运算符进栈
                if(stack.empty()){
                    stack.add(s);
                }else {
                    // 不是空栈
                    // 入栈")"时
                    if(s.equals(")")){
                        // 找出元素"("
                        while (!stack.peek().equals("(")){
                            // 栈顶元素不是"("，出栈并打印
                            System.out.print(stack.pop());
                        }
                        //找到栈顶"(",直接出栈，不打印
                        stack.pop();
                    }else {
                        // 比较优先级 ，判断是出栈还是入栈
                        while (!stack.isEmpty()&&compare(stack.peek(),s)){
                            // 栈顶优先级高 出栈
                            System.out.print(stack.pop());
                        }
                        //出栈完成后  再入栈当前元素
                        stack.add(s);

                    }
                }
            }
        }
        // 最后出栈所有元素
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }


    }
    // 比较运算符优先级  ture代表栈顶优先级高
    public static boolean compare(String top, String s){
        if(s.equals("(") || top.equals("(")){
            //入栈
            return false;
        }
        if(s.equals("+")||s.equals("-")){
            return true;
        }else {
            if(top.equals("+")||top.equals("-")){
                return false;
            }else {
                return true;
            }
        }
    }

    // 判断是否是数字
    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
