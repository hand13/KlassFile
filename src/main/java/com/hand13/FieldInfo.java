package com.hand13;

import com.hand13.attribute.AttributeInfo;
import com.hand13.enums.FieldAccFlag;

import java.util.ArrayList;
import java.util.List;

public class FieldInfo {
    private KlassFile klassFile;
    private short accessFlag;
    private short nameIndex;
    private short descriptorIndex;
    private List<AttributeInfo> attributeInfos = new ArrayList<>();

    public FieldInfo(KlassFile klassFile, short accessFlag, short nameIndex, short descriptorIndex) {
        this.klassFile = klassFile;
        this.accessFlag = accessFlag;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
    }

    public List<FieldAccFlag> calcAccFlag() {
        List<FieldAccFlag> flags = new ArrayList<>();
        for (FieldAccFlag accFlag : FieldAccFlag.values()) {
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

    public List<AttributeInfo> getAttributeInfos() {
        return attributeInfos;
    }

    public void setAttributeInfos(List<AttributeInfo> attributeInfos) {
        this.attributeInfos = attributeInfos;
    }

    public KlassFile getKlassFile() {
        return klassFile;
    }

}
