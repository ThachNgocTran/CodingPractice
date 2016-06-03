package com.company;

/**
 * Created by iRobot on 08/May/2016.
 */
public class MyBusinessException extends Exception {
    private int m_code = 0;
    private String m_message = "";

    public MyBusinessException(String message, int code){
        m_message = message;
        m_code = code;
    }

    @Override
    public String toString(){
        return String.format("%s (code: %d)", m_message, m_code);
    }
}
