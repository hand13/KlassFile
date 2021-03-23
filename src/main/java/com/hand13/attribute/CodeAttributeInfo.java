package com.hand13.attribute;

import com.hand13.KlassFile;

import java.util.ArrayList;
import java.util.List;

public class CodeAttributeInfo extends AttributeInfo {

    private short maxStack;
    private short maxLocals;
    private byte[] code;
    private List<ExceptionTable> exceptionTables = new ArrayList<>();
    private List<AttributeInfo> attributeInfos = new ArrayList<>();


    public CodeAttributeInfo(KlassFile klassFile, short attributeNameIndex) {
        super(klassFile, attributeNameIndex);
    }

    public void setMaxStack(short maxStack) {
        this.maxStack = maxStack;
    }

    public void setMaxLocals(short maxLocals) {
        this.maxLocals = maxLocals;
    }

    public void setCode(byte[] code) {
        this.code = code;
    }

    public short getMaxStack() {
        return maxStack;
    }

    public short getMaxLocals() {
        return maxLocals;
    }

    public byte[] getCode() {
        return code;
    }

    public List<ExceptionTable> getExceptionTables() {
        return exceptionTables;
    }

    public List<AttributeInfo> getAttributeInfos() {
        return attributeInfos;
    }
}
