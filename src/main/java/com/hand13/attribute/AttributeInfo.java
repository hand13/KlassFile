package com.hand13.attribute;

import com.hand13.KlassFile;
import com.hand13.KlassUtils;

public abstract class AttributeInfo {
    private KlassFile klassFile;
    private short attributeNameIndex;

    public AttributeInfo(KlassFile klassFile, short attributeNameIndex) {
        this.klassFile = klassFile;
        this.attributeNameIndex = attributeNameIndex;
    }

    public String getAttributeName() {
        return KlassUtils.getUTF8(klassFile, attributeNameIndex);
    }

    public short getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public KlassFile getKlassFile() {
        return klassFile;
    }
}
