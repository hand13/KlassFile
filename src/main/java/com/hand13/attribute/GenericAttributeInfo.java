package com.hand13.attribute;

import com.hand13.KlassFile;

public class GenericAttributeInfo extends AttributeInfo {
    private byte[] attributes;

    public GenericAttributeInfo(KlassFile klassFile, short attributeNameIndex) {
        super(klassFile, attributeNameIndex);
    }

    public void setAttributes(byte[] attributes) {
        this.attributes = attributes;
    }

    public byte[] getAttributes() {
        return attributes;
    }
}
