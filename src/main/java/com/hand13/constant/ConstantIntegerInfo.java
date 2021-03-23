package com.hand13.constant;

import com.hand13.enums.ConstantTag;

public class ConstantIntegerInfo extends ConstantInfo {
    private int values;

    public ConstantIntegerInfo() {
        super(ConstantTag.INTEGER);
    }

    public int getValues() {
        return values;
    }

    public void setValues(int values) {
        this.values = values;
    }
}
