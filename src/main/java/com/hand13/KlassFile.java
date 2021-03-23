package com.hand13;

import com.hand13.attribute.AttributeInfo;
import com.hand13.enums.ClassAccFlag;

import java.util.ArrayList;
import java.util.List;

public class KlassFile {

    private short minorVersion;
    private short majorVersion;
    private short constantPoolCount;
    private ConstantPool constantPool;
    private short accessFlag;
    private short thisClassIndex;
    private short superClassIndex;
    private List<Short> interfaceIndices = new ArrayList<>();
    private List<MethodInfo> methods = new ArrayList<>();
    private List<FieldInfo> fields = new ArrayList<>();
    private List<AttributeInfo> attributes = new ArrayList<>();

    public List<ClassAccFlag> calcAccFlag() {
        List<ClassAccFlag> flags = new ArrayList<>();
        for (ClassAccFlag accFlag : ClassAccFlag.values()) {
            if ((accFlag.value() & accessFlag) != 0) {
                flags.add(accFlag);
            }
        }
        return flags;
    }

    public List<MethodInfo> getMethods() {
        return methods;
    }

    public void setMethods(List<MethodInfo> methods) {
        this.methods = methods;
    }

    public List<FieldInfo> getFields() {
        return fields;
    }

    public void setFields(List<FieldInfo> fields) {
        this.fields = fields;
    }

    public ConstantPool getConstantPool() {
        return constantPool;
    }

    public void setConstantPool(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    public short getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(short minorVersion) {
        this.minorVersion = minorVersion;
    }

    public short getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(short majorVersion) {
        this.majorVersion = majorVersion;
    }

    public short getAccessFlag() {
        return accessFlag;
    }

    public void setAccessFlag(short accessFlag) {
        this.accessFlag = accessFlag;
    }

    public short getConstantPoolCount() {
        return constantPoolCount;
    }

    public void setConstantPoolCount(short constantPoolCount) {
        this.constantPoolCount = constantPoolCount;
    }

    public short getThisClassIndex() {
        return thisClassIndex;
    }

    public void setThisClassIndex(short thisClassIndex) {
        this.thisClassIndex = thisClassIndex;
    }

    public short getSuperClassIndex() {
        return superClassIndex;
    }

    public void setSuperClassIndex(short superClassIndex) {
        this.superClassIndex = superClassIndex;
    }


    public List<Short> getInterfaceIndices() {
        return interfaceIndices;
    }

    public void setInterfaceIndices(List<Short> interfaceIndices) {
        this.interfaceIndices = interfaceIndices;
    }

    public List<AttributeInfo> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeInfo> attributes) {
        this.attributes = attributes;
    }
}
