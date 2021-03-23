package com.hand13.constant;

import com.hand13.enums.ConstantTag;

public class ConstantLongInfo extends ConstantInfo {
    private int highBytes;
    private int lowBytes;

    public ConstantLongInfo() {
        super(ConstantTag.LONG);
    }

    public int getHighBytes() {
        return highBytes;
    }

    public void setHighBytes(int highBytes) {
        this.highBytes = highBytes;
    }

    public int getLowBytes() {
        return lowBytes;
    }

    public void setLowBytes(int lowBytes) {
        this.lowBytes = lowBytes;
    }
}
