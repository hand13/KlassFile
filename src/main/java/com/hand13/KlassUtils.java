package com.hand13;

import com.hand13.constant.ConstantInfo;
import com.hand13.enums.ConstantTag;

import static com.hand13.KlassParser.b2i;

public class KlassUtils {
    public static void main(String[] args) {
        byte w = (byte) 0xfe;
        System.out.println(w);
    }

    public static String getUTF8(KlassFile klassFile, short index) {
        ConstantInfo constantInfo = klassFile.getConstantPool().getConstantByIndex(index);
        if (constantInfo.getTag() != ConstantTag.UTF8) {
            throw new RuntimeException();
        }
        return constantInfo.toString();
    }

    public static String disAssemble(KlassFile klassFile, byte[] code) {
        StringBuilder result = new StringBuilder();
        int offset = -1;
        while (offset + 1 != code.length) {
            offset++;
            switch (code[offset]) {
                case 0x32:
                    result.append("aaload");
                    break;
                case 0x53:
                    result.append("aastore");
                    break;
                case 0x1:
                    result.append("aconst_null");
                    break;
                case 0x19:
                    result.append("aload ");
                    offset++;
                    result.append(" ");
                    result.append(code[offset]);
                    break;
                case 0x2a:
                    result.append("aload_0");
                    break;
                case 0x2b:
                    result.append("aload_1");
                    break;
                case 0x2c:
                    result.append("aload_2");
                    break;
                case 0x2d:
                    result.append("aload_3");
                    break;
                case (byte) 0xbd:
                    result.append("anewarray");
                    offset++;
                    byte high = code[offset];
                    offset++;
                    byte low = code[offset];
                    result.append(" ");
                    result.append(high << 8 | low);
                    break;
                case (byte) 0xb0:
                    result.append("areturn");
                    break;
                case (byte) 0xbe:
                    result.append("arraylength");
                    break;
                case 0x3a:
                    result.append("astore");
                    offset++;
                    result.append(" ");
                    result.append(code[offset]);
                    break;
                case 0x4b:
                    result.append("atore_0");
                    break;
                case 0x4c:
                    result.append("atore_1");
                    break;
                case 0x4d:
                    result.append("atore_2");
                    break;
                case 0x4e:
                    result.append("atore_3");
                    break;
                case (byte) 0xbf:
                    result.append("athrow");
                    break;
                case 0x33:
                    result.append("baload");
                    break;
                case (byte) 0x54:
                    result.append("bastore");
                    break;
                case 0x10:
                    result.append("bipush");
                    offset++;
                    result.append(" ");
                    result.append(code[offset]);
                    break;
                case 0x34:
                    result.append("caload");
                    break;
                case 0x55:
                    result.append("castore");
                    break;
                case (byte) 0xc0:
                    result.append("checkcast");
                    offset++;
                    high = code[offset];
                    offset++;
                    low = code[offset];
                    result.append(" ");
                    result.append(high << 8 | low);
                    break;
                case (byte) 0x90:
                    result.append("d2f");
                    break;
                case (byte) 0x8e:
                    result.append("d2i");
                    break;
                case (byte) 0x8f:
                    result.append("d2l");
                    break;
                case 0x63:
                    result.append("dadd");
                    break;
                case 0x31:
                    result.append("daload");
                    break;
                case 0x52:
                    result.append("dastore");
                    break;
                case (byte) 0x98:
                    result.append("dcmpg");
                    break;
                case (byte) 0x97:
                    result.append("dcmpl");
                case 0xe:
                    result.append("dconst_0");
                    break;
                case 0xf:
                    result.append("dconst_1");
                    break;
                case 0x6f:
                    result.append("ddiv");
                    break;
                case 0x18:
                    result.append("dload");
                    offset++;
                    result.append(" ");
                    result.append(code[offset]);
                    break;
                case 0x26:
                    result.append("dload_0");
                    break;
                case 0x27:
                    result.append("dload_1");
                    break;
                case 0x28:
                    result.append("dload_2");
                    break;
                case 0x29:
                    result.append("dload_3");
                    break;
                case 0x6b:
                    result.append("dmul");
                    break;
                case 0x77:
                    result.append("dneg");
                    break;
                case 0x73:
                    result.append("drem");
                    break;
                case (byte) 0xaf:
                    result.append("dreturn");
                    break;
                case 0x39:
                    result.append("dstore");
                    offset++;
                    result.append(" ");
                    result.append(code[offset]);
                    break;
                case 0x47:
                    result.append("dstore_0");
                    break;
                case 0x48:
                    result.append("dstore_1");
                    break;
                case 0x49:
                    result.append("dstore_2");
                    break;
                case 0x4a:
                    result.append("dstore_3");
                    break;
                case 0x67:
                    result.append("dsub");
                    break;
                case 0x59:
                    result.append("dup");
                    break;
                case 0x5a:
                    result.append("dup_x1");
                    break;
                case 0x5b:
                    result.append("dup_x2");
                    break;
                case 0x5c:
                    result.append("dup2");
                    break;
                case 0x5d:
                    result.append("dup2_x1");
                    break;
                case 0x5e:
                    result.append("dup2_x2");
                    break;
                case (byte) 0x8d:
                    result.append("f2d");
                    break;
                case (byte) 0x8b:
                    result.append("f2i");
                    break;
                case (byte) 0x8c:
                    result.append("f2l");
                    break;
                case 0x62:
                    result.append("fadd");
                    break;
                case 0x30:
                    result.append("faload");
                    break;
                case 0x51:
                    result.append("fastore");
                    break;
                case (byte) 0x96:
                    result.append("fcmpg");
                    break;
                case (byte) 0x95:
                    result.append("fcmpl");
                    break;
                case 0xb:
                    result.append("fconst_0");
                    break;
                case 0xc:
                    result.append("fconst_1");
                    break;
                case 0xd:
                    result.append("fconst_2");
                    break;
                case 0x6e:
                    result.append("fdiv");
                    break;
                case 0x17:
                    result.append("fload");
                    offset++;
                    result.append(" ");
                    result.append(code[offset]);
                    break;
                case 0x22:
                    result.append("fload_0");
                    break;
                case 0x23:
                    result.append("fload_1");
                    break;
                case 0x24:
                    result.append("fload_2");
                    break;
                case 0x25:
                    result.append("fload_3");
                    break;
                case 0x6a:
                    result.append("fmul");
                    break;
                case 0x76:
                    result.append("fneg");
                    break;
                case 0x72:
                    result.append("frem");
                    break;
                case (byte) 0xae:
                    result.append("freturn");
                    break;
                case 0x38:
                    result.append("fstore");
                    offset++;
                    result.append(" ");
                    result.append(code[offset]);
                    break;
                case 0x43:
                    result.append("fstore_0");
                    break;
                case 0x44:
                    result.append("fstore_1");
                    break;
                case 0x45:
                    result.append("fstore_2");
                    break;
                case 0x46:
                    result.append("fstore_3");
                    break;
                case 0x66:
                    result.append("fsub");
                    break;
                case (byte) 0xb4:
                    result.append("getfield");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0xb2:
                    result.append("getstatic");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0xa7:
                    result.append("goto");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0xc8:
                    result.append("goto_w");
                    result.append(" ");
                    result.append(nextU4(code, offset));
                    offset += 4;
                    break;
                case (byte) 0x91:
                    result.append("i2b");
                    break;
                case (byte) 0x92:
                    result.append("i2c");
                    break;
                case (byte) 0x87:
                    result.append("i2d");
                    break;
                case (byte) 0x86:
                    result.append("i2f");
                    break;
                case (byte) 0x85:
                    result.append("i2l");
                    break;
                case (byte) 0x93:
                    result.append("i2s");
                    break;
                case 0x60:
                    result.append("iadd");
                    break;
                case 0x2e:
                    result.append("iaload");
                    break;
                case 0x7e:
                    result.append("iand");
                    break;
                case 0x4f:
                    result.append("iastore");
                    break;
                case 0x2:
                    result.append("iconst_m1");
                    break;
                case 0x3:
                    result.append("iconst_0");
                    break;
                case 0x4:
                    result.append("iconst_1");
                    break;
                case 0x5:
                    result.append("iconst_2");
                    break;
                case 0x6:
                    result.append("iconst_3");
                    break;
                case 0x7:
                    result.append("iconst_4");
                    break;
                case 0x8:
                    result.append("iconst_5");
                    break;
                case 0x6c:
                    result.append("idiv");
                    break;
                case (byte) 0xa5:
                    result.append("if_acmpeq");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0xa6:
                    result.append("if_acmpne");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0x9f:
                    result.append("if_icmpeq");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0xa0:
                    result.append("if_icmpne");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0xa1:
                    result.append("if_icmplt");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0xa2:
                    result.append("if_icmpge");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0xa3:
                    result.append("if_icmpgt");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0xa4:
                    result.append("if_icmple");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0x99:
                    result.append("ifeq");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0x9a:
                    result.append("ifne");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0x9b:
                    result.append("iflt");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0x9c:
                    result.append("ifge");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0x9d:
                    result.append("ifgt");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0x9e:
                    result.append("ifle");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0xc7:
                    result.append("ifnonnull");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0xc6:
                    result.append("ifnull");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0x84:
                    result.append("iinc");
                    offset++;
                    result.append(" ");
                    result.append(code[offset]);
                    offset++;
                    result.append(" ");
                    result.append(code[offset]);
                    break;
                case 0x15:
                    result.append("iload");
                    offset++;
                    result.append(" ");
                    result.append(code[offset]);
                    break;
                case 0x1a:
                    result.append("iload_0");
                    break;
                case 0x1b:
                    result.append("iload_1");
                    break;
                case 0x1c:
                    result.append("iload_2");
                    break;
                case 0x1d:
                    result.append("iload_3");
                    break;
                case 0x68:
                    result.append("imul");
                    break;
                case 0x74:
                    result.append("ineg");
                    break;
                case (byte) 0xc1:
                    result.append("instanceof");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0xba:
                    result.append("invokedynamic");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    result.append(" ");
                    result.append("0");
                    result.append(" ");
                    result.append("0");
                    offset += 4;
                    break;
                case (byte) 0xb9:
                    result.append("invokeinterface");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    offset += 1;
                    result.append(" ");
                    result.append(code[offset]);
                    offset += 1;
                    result.append(" ");
                    result.append("0");
                    break;
                case (byte) 0xb7:
                    result.append("invokespecial");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0xb8:
                    result.append("invokestatic");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0xb6:
                    result.append("invokevirtual");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0x80:
                    result.append("ior");
                    break;
                case 0x70:
                    result.append("irem");
                    break;
                case (byte) 0xac:
                    result.append("ireturn");
                    break;
                case 0x78:
                    result.append("ishl");
                    break;
                case 0x7a:
                    result.append("ishr");
                    break;
                case 0x36:
                    result.append("istore");
                    offset++;
                    result.append(code[offset]);
                    break;
                case 0x3b:
                    result.append("istore_0");
                    break;
                case 0x3c:
                    result.append("istore_1");
                    break;
                case 0x3d:
                    result.append("istore_2");
                    break;
                case 0x3e:
                    result.append("istore_3");
                    break;
                case 0x64:
                    result.append("isub");
                    break;
                case 0x7c:
                    result.append("iushr");
                    break;
                case (byte) 0x82:
                    result.append("ixor");
                    break;
                case (byte) 0xa8:
                    result.append("jsr");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                case (byte) 0xc9:
                    result.append("jsr");
                    result.append(" ");
                    result.append(nextU4(code, offset));
                    offset += 4;
                    break;
                case (byte) 0x8a:
                    result.append("i2d");
                    break;
                case (byte) 0x89:
                    result.append("i2f");
                    break;
                case (byte) 0x88:
                    result.append("l2i");
                    break;
                case (byte) 0x61:
                    result.append("ladd");
                    break;
                case (byte) 0x2f:
                    result.append("laload");
                    break;
                case (byte) 0x7f:
                    result.append("land");
                    break;
                case (byte) 0x50:
                    result.append("lastore");
                    break;
                case (byte) 0x94:
                    result.append("lcmp");
                    break;
                case 0x9:
                    result.append("lconst_0");
                    break;
                case 0xa:
                    result.append("lconst_1");
                    break;
                case 0x12:
                    result.append("ldc");
                    offset++;
                    result.append(code[offset]);
                    break;
                case 0x13:
                    result.append("ldc_w");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case 0x14:
                    result.append("ldc2_w");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case 0x6d:
                    result.append("ldiv");
                    break;
                case 0x16:
                    result.append("lload");
                    offset++;
                    result.append(" ");
                    result.append(code[offset]);
                    break;
                case 0x1e:
                    result.append("lload_0");
                    break;
                case 0x1f:
                    result.append("lload_1");
                    break;
                case 0x20:
                    result.append("lload_2");
                    break;
                case 0x21:
                    result.append("lload_3");
                    break;
                case 0x69:
                    result.append("lmul");
                    break;
                case 0x75:
                    result.append("lneg");
                    break;
                case (byte) 0xab:
                    throw new RuntimeException();
                case (byte) 0x81:
                    result.append("lor");
                    break;
                case 0x71:
                    result.append("lrem");
                    break;
                case (byte) 0xad:
                    result.append("lreturn");
                    break;
                case 0x79:
                    result.append("lshl");
                    break;
                case 0x7b:
                    result.append("lshr");
                    break;
                case 0x37:
                    result.append("lstore");
                    offset++;
                    result.append(" ");
                    result.append(code[offset]);
                    break;
                case 0x3f:
                    result.append("lstore_0");
                    break;
                case 0x40:
                    result.append("lstore_1");
                    break;
                case 0x41:
                    result.append("lstore_2");
                    break;
                case 0x42:
                    result.append("lstore_3");
                    break;
                case 0x65:
                    result.append("lsub");
                    break;
                case 0x7d:
                    result.append("lushr");
                    break;
                case (byte) 0x83:
                    result.append("lxor");
                    break;
                case (byte) 0xc2:
                    result.append("monitorenter");
                    break;
                case (byte) 0xc3:
                    result.append("monitorexit");
                    break;
                case (byte) 0xc5:
                    result.append("multianewarray");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    offset++;
                    result.append(" ");
                    result.append(code[offset]);
                    break;
                case (byte) 0xbb:
                    result.append("new");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0xbc:
                    result.append("newarray");
                    offset++;
                    result.append(" ");
                    result.append(code[offset]);
                    break;
                case 0x0:
                    result.append("nop");
                    break;
                case 0x57:
                    result.append("pop");
                    break;
                case 0x58:
                    result.append("pop2");
                    break;
                case (byte) 0xb5:
                    result.append("putfield");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0xb3:
                    result.append("putstatic");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                    break;
                case (byte) 0xa9:
                    result.append("ret");
                    offset++;
                    result.append(" ");
                    result.append(code[offset]);
                    break;
                case (byte) 0xb1:
                    result.append("return");
                    break;
                case (byte) 0x35:
                    result.append("saload");
                    break;
                case (byte) 0x56:
                    result.append("sastore");
                    break;
                case 0x11:
                    result.append("sipush");
                    result.append(" ");
                    result.append(nextU2(code, offset));
                    offset += 2;
                case 0x5f:
                    result.append("swap");
                    break;
                case (byte) 0xaa:
                    throw new RuntimeException();
                case (byte) 0xc4:
                    throw new RuntimeException();
                default:
                    break;
            }
            result.append("\n");
        }
        return result.toString();
    }

    public static short nextU2(byte[] data, int offset) {
        return (short) (b2i(data[offset + 1]) << 8 | b2i(data[offset + 2]));
    }

    private static int nextU4(byte[] data, int offset) {
        return ((b2i(data[offset + 1]) << 24) | (b2i(data[offset + 2]) << 16)
                | (b2i(data[offset + 3]) << 8) | b2i(data[offset + 4]));
    }
}
