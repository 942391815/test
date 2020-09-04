package com.test.java.algorithm.stack;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.Stack;

public class TestSymbol {
    public static void main(String[] args) {
        TestSymbol testSymbol = new TestSymbol();
        System.out.println(testSymbol.isValid("}{"));
//        System.out.println(testSymbol.isValid("()[]{}"));
//        System.out.println(testSymbol.isValid("([)]"));
//        System.out.println(testSymbol.isValid("{[]}"));
    }

    public int isValid(String s) {
        if (s == null || s.length() == 0 || s.isEmpty()) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (stack.isEmpty()) {
                stack.push(charArray[i]);
            } else {
                Character peek = stack.peek();
                if (isEqual(peek, charArray[i])) {
                    stack.pop();
                } else {
                    stack.push(charArray[i]);
                }
            }
        }
        return charArray.length-stack.size();
    }

    public boolean isEqual(Character a, Character b) {
        switch (a) {
            case '{':
                return b.equals('}');
            case '}':
                return b.equals('{');
            case '(':
                return b.equals(')');
            case ')':
                return b.equals('(');
            case '[':
                return b.equals(']');
            case ']':
                return b.equals('[');
        }
        return false;
    }
}
