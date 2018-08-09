/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enums;

/**
 *
 * @author ryan
 */
public enum ExamType {
    exam(1),
    exercise(2);
    
    private int type;

    ExamType(int type) {
        this.type = type;
    }

    public int type() {
        return type;
    }
}
