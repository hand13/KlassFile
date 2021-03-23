package com.hand13;

import com.hand13.constant.ConstantInfo;

import java.util.ArrayList;
import java.util.List;

public class ConstantPool {
    private List<ConstantInfo> constantInfoList = new ArrayList<>();

    public List<ConstantInfo> getConstantInfoList() {
        return constantInfoList;
    }

    public ConstantInfo getConstantByIndex(int index) {
        if (index - 1 > constantInfoList.size()) {
            throw new RuntimeException();
        }
        return constantInfoList.get(index - 1);
    }

    public void setConstantInfoList(List<ConstantInfo> constantInfoList) {
        this.constantInfoList = constantInfoList;
    }
}
