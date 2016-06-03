package com.company;

import java.io.IOException;

/**
 * Created by iRobot on 08/May/2016.
 */
public class StringManipulator {

    private String m_strTarget;

    /**
     * @author Thach Tran
     * @param inputString The input string
     */
    public StringManipulator(String inputString){
        m_strTarget = inputString;
    }

    /**
     * @author Thach Tran
     * @return A reversed string
     */
    public String reverseString() throws MyBusinessException{
        if (m_strTarget == null){
            throw new MyBusinessException("Input string is null", 100);
            //throw new NullPointerException("String is null");
            //throw new IOException();
        }

        StringBuilder strBuilder = new StringBuilder();

        for(int i = m_strTarget.length()-1; i>=0; i--){
            strBuilder.append(m_strTarget.charAt(i));
        }

        return strBuilder.toString();
    }
}
