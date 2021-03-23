package com.hand13;

import com.hand13.attribute.AttributeInfo;
import com.hand13.enums.MethodAccFlag;

import java.util.ArrayList;
import java.util.List;

public class MethodInfo {
    private KlassFile klassFile;
    private short accessFlag;
    private short nameIndex;
    private short descriptorIndex;
    private List<AttributeInfo> attributeInfoList = new ArrayList<>();

    public MethodInfo(KlassFile klassFile, short accessFlag, short nameIndex, short descriptorIndex) {
        this.klassFile = klassFile;
        this.accessFlag = accessFlag;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
    }

    public List<MethodAccFlag> calcAccFlag() {
        List<MethodAccFlag> flags = new ArrayList<>();
        for (MethodAccFlag accFlag : MethodAccFlag.values()) {
            if ((accFlag.value() & accessFlag) != 0) {
                flags.add(accFlag);
            }
        }
        return flags;
    }

    public String getName() {
        return KlassUtils.getUTF8(klassFile, nameIndex);
    }

    public String getDescriptor() {
        return KlassUtils.getUTF8(klassFile, descriptorIndex);
    }


    public short getAccessFlag() {
        return accessFlag;
    }

    public short getNameIndex() {
        return nameIndex;
    }

    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    public List<AttributeInfo> getAttributeInfoList() {
        return attributeInfoList;
    }

    public void setAttributeInfoList(List<AttributeInfo> attributeInfoList) {
        this.attributeInfoList = attributeInfoList;
    }

    public KlassFile getKlassFile() {
        return klassFile;
    }
}
