package com.hand13;

import com.hand13.attribute.AttributeInfo;
import com.hand13.attribute.CodeAttributeInfo;
import com.hand13.attribute.ExceptionTable;
import com.hand13.attribute.GenericAttributeInfo;
import com.hand13.constant.*;
import com.hand13.enums.ConstantTag;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class KlassParser {
    private static final int CAFEBABE = 0xcafebabe;
    private InputStream is;
    private int ioOffset = 0;

    public KlassParser(InputStream is) {
        this.is = is;
    }

    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("e:/BusinessException.class")) {
            KlassParser parser = new KlassParser(is);
            KlassFile file = parser.parse();
            for (MethodInfo methodInfo : file.getMethods()) {
                CodeAttributeInfo codeAttributeInfo = (CodeAttributeInfo) methodInfo.getAttributeInfoList().get(0);
                String dis = KlassUtils.disAssemble(file, codeAttributeInfo.getCode());
                System.out.println(dis);
                break;
            }
        } catch (IOException ignored) {
        }
    }

    public int getIoOffset() {
        return ioOffset;
    }

    public KlassFile parse() throws IOException {
        KlassFile klassFile = new KlassFile();
        if (CAFEBABE != nextU4()) {
            throw new RuntimeException();
        }
        klassFile.setMinorVersion(nextU2());
        klassFile.setMajorVersion(nextU2());
        klassFile.setConstantPoolCount(nextU2());
        ConstantPool constantPool = new ConstantPool();
        klassFile.setConstantPool(constantPool);
        for (int i = 0; i < klassFile.getConstantPoolCount() - 1; i++) {
            constantPool.getConstantInfoList().add(nextConstantInfo());
        }
        klassFile.setAccessFlag(nextU2());
        klassFile.setThisClassIndex(nextU2());
        klassFile.setSuperClassIndex(nextU2());
        short interfaceCount = nextU2();
        for (int i = 0; i < interfaceCount; i++) {
            klassFile.getInterfaceIndices().add(nextU2());
        }

        short fieldsCount = nextU2();
        for (int i = 0; i < fieldsCount; i++) {
            FieldInfo field = new FieldInfo(klassFile, nextU2(), nextU2(), nextU2());
            short attributeCount = nextU2();
            for (int j = 0; j < attributeCount; j++) {
                field.getAttributeInfos().add(nextAttribute(klassFile));
            }
            klassFile.getFields().add(field);
        }

        short methodsCount = nextU2();
        for (int i = 0; i < methodsCount; i++) {
            MethodInfo method = new MethodInfo(klassFile, nextU2(), nextU2(), nextU2());
            short attributeCount = nextU2();

            for (int j = 0; j < attributeCount; j++) {
                method.getAttributeInfoList().add(nextAttribute(klassFile));
            }
            klassFile.getMethods().add(method);
        }

        short attributeCount = nextU2();
        for (int i = 0; i < attributeCount; i++) {
            klassFile.getAttributes().add(nextAttribute(klassFile));
        }
        return klassFile;
    }

    private ConstantInfo nextConstantInfo() throws IOException {
        ConstantTag tag = ConstantTag.fromU1(nextU1());
        switch (tag) {
            case CLASS:
                ConstantClassInfo constantClassInfo = new ConstantClassInfo();
                constantClassInfo.setNameIndex(nextU2());
                return constantClassInfo;
            case FIELD_REF:
                ConstantFieldRefInfo fieldRefInfo = new ConstantFieldRefInfo();
                fieldRefInfo.setClassIndex(nextU2());
                fieldRefInfo.setNameAndTypeIndex(nextU2());
                return fieldRefInfo;
            case METHOD_REF:
                ConstantMethodRefInfo methodRefInfo = new ConstantMethodRefInfo();
                methodRefInfo.setClassIndex(nextU2());
                methodRefInfo.setNameAndTypeIndex(nextU2());
                return methodRefInfo;
            case INTERFACE_METHOD_REF:
                ConstantInterfaceMethodRefInfo info = new ConstantInterfaceMethodRefInfo();
                info.setClassIndex(nextU2());
                info.setNameAndTypeIndex(nextU2());
                return info;
            case STRING:
                ConstantStringInfo stringInfo = new ConstantStringInfo();
                stringInfo.setStringIndex(nextU2());
                return stringInfo;
            case INTEGER:
                ConstantIntegerInfo integerInfo = new ConstantIntegerInfo();
                integerInfo.setValues(nextU4());
                return integerInfo;
            case FLOAT:
                ConstantFloatInfo floatInfo = new ConstantFloatInfo();
                floatInfo.setValue(nextU4());
                return floatInfo;
            case LONG:
                ConstantLongInfo constantLongInfo = new ConstantLongInfo();
                constantLongInfo.setHighBytes(nextU4());
                constantLongInfo.setLowBytes(nextU4());
                return constantLongInfo;
            case DOUBLE:
                ConstantDoubleInfo doubleInfo = new ConstantDoubleInfo();
                doubleInfo.setHighBytes(nextU4());
                doubleInfo.setLowBytes(nextU4());
                return doubleInfo;
            case NAME_AND_TYPE:
                ConstantNameAndTypeInfo nameAndTypeInfo = new ConstantNameAndTypeInfo();
                nameAndTypeInfo.setNameIndex(nextU2());
                nameAndTypeInfo.setDescriptorIndex(nextU2());
                return nameAndTypeInfo;
            case UTF8:
                ConstantUtf8Info utf8Info = new ConstantUtf8Info();
                utf8Info.setLength(nextU2());
                utf8Info.setBytes(nextBytes(is, utf8Info.getLength()));
                return utf8Info;
            case METHOD_HANDLE:
                ConstantMethodHandleInfo methodHandleInfo = new ConstantMethodHandleInfo();
                methodHandleInfo.setReferenceKind(nextU1());
                methodHandleInfo.setReferenceIndex(nextU2());
                return methodHandleInfo;
            case METHOD_TYPE:
                ConstantMethodTypeInfo methodTypeInfo = new ConstantMethodTypeInfo();
                methodTypeInfo.setDescriptorIndex(nextU2());
                return methodTypeInfo;
            case INVOKE_DYNAMIC:
                ConstantInvokeDynamicInfo dynamicInfo = new ConstantInvokeDynamicInfo();
                dynamicInfo.setBootstrapMethodAttrIndex(nextU2());
                dynamicInfo.setNameAndTypeIndex(nextU2());
                return dynamicInfo;
            default:
                return null;
        }
    }

    private AttributeInfo nextAttribute(KlassFile klassFile) throws IOException {
        short nameIndex = nextU2();
        if (KlassUtils.getUTF8(klassFile, nameIndex).equals("Code")) {
            CodeAttributeInfo codeAttributeInfo = new CodeAttributeInfo(klassFile, nameIndex);
            int length = nextU4();
            codeAttributeInfo.setMaxStack(nextU2());
            codeAttributeInfo.setMaxLocals(nextU2());
            int codeLength = nextU4();
            codeAttributeInfo.setCode(nextBytes(is, codeLength));
            short expLength = nextU2();
            for (short i = 0; i < expLength; i++) {
                ExceptionTable exceptionTable = new ExceptionTable(nextU2(), nextU2(), nextU2(), nextU2());
                codeAttributeInfo.getExceptionTables().add(exceptionTable);
            }
            short attrCount = nextU2();
            for (short i = 0; i < attrCount; i++) {
                codeAttributeInfo.getAttributeInfos().add(nextAttribute(klassFile));
            }
            return codeAttributeInfo;
        } else {
            GenericAttributeInfo genericAttributeInfo = new GenericAttributeInfo(klassFile, nameIndex);
            int length = nextU4();
            genericAttributeInfo.setAttributes(nextBytes(is, length));
            return genericAttributeInfo;
        }
    }

    private byte nextU1() throws IOException {
        return nextBytes(is, 1)[0];
    }

    private short nextU2() throws IOException {
        byte[] buffer = nextBytes(is, 2);
        return (short) (b2i(buffer[0]) << 8 | b2i(buffer[1]));
    }

    private int nextU4() throws IOException {
        byte[] buffer = nextBytes(is, 4);
        return ((b2i(buffer[0]) << 24) | (b2i(buffer[1]) << 16) | (b2i(buffer[2]) << 8) | b2i(buffer[3]));
    }

    public static int b2i(byte b) {
        return 0xff & b;
    }


    public byte[] nextBytes(InputStream ins, int length) throws IOException {
        ioOffset += length;
        byte[] buffer = new byte[length];
        int left = length;
        int reads;
        int offset = 0;
        while ((left > 0) && (reads = ins.read(buffer, offset, left)) > 0) {
            left -= reads;
            offset += reads;
        }
        if (left > 0) {
            throw new RuntimeException();
        }
        return buffer;
    }
}
