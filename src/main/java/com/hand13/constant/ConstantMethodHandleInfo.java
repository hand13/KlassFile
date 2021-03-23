package com.hand13.constant;

import com.hand13.enums.ConstantTag;

/**
 * @author $Author$
 * @version $Revision$ $Date$
 */
public class ConstantMethodHandleInfo extends ConstantInfo {
    private byte referenceKind;
    private short referenceIndex;

    public ConstantMethodHandleInfo() {
        super(ConstantTag.METHOD_HANDLE);
    }

    public byte getReferenceKind() {
        return referenceKind;
    }

    public void setReferenceKind(byte referenceKind) {
        this.referenceKind = referenceKind;
    }

    public short getReferenceIndex() {
        return referenceIndex;
    }

    public void setReferenceIndex(short referenceIndex) {
        this.referenceIndex = referenceIndex;
    }
}
