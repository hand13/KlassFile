package com.hand13.constant;

import com.hand13.enums.ConstantTag;

public class ConstantFloatInfo extends ConstantInfo {
    private int value;

    public ConstantFloatInfo() {
        super(ConstantTag.FLOAT);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
