package com.hand13.constant;

import com.hand13.enums.ConstantTag;

public class ConstantMethodTypeInfo extends ConstantInfo {
    private short descriptorIndex;

    public ConstantMethodTypeInfo() {
        super(ConstantTag.METHOD_TYPE);
    }

    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(short descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }
}
