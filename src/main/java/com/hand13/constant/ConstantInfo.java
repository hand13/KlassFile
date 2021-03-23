package com.hand13.constant;

import com.hand13.enums.ConstantTag;

public abstract class ConstantInfo {
    private ConstantTag tag;

    public ConstantInfo(ConstantTag tag) {
        this.tag = tag;
    }

    public ConstantTag getTag() {
        return tag;
    }

    public void setTag(ConstantTag tag) {
        this.tag = tag;
    }
}
