package com.hand13.constant;

import com.hand13.enums.ConstantTag;

public class ConstantInterfaceMethodRefInfo extends ConstantInfo {
    private short classIndex;
    private short nameAndTypeIndex;

    public ConstantInterfaceMethodRefInfo() {
        super(ConstantTag.INTERFACE_METHOD_REF);
    }

    public short getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(short classIndex) {
        this.classIndex = classIndex;
    }

    public short getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(short nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }
}
