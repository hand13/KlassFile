package com.hand13.attribute;

public class ExceptionTable {
    private short startPc;
    private short endPc;
    private short handlerPc;
    private short catchType;

    public ExceptionTable(short startPc, short endPc, short handlerPc, short catchType) {
        this.startPc = startPc;
        this.endPc = endPc;
        this.handlerPc = handlerPc;
        this.catchType = catchType;
    }

    public short getStartPc() {
        return startPc;
    }

    public short getEndPc() {
        return endPc;
    }

    public short getHandlerPc() {
        return handlerPc;
    }

    public short getCatchType() {
        return catchType;
    }
}
