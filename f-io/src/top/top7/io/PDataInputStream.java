package top.top7.io;

/******
 *       Created by LEARNING on 2020/11/3 16:51.
 *
 **********************************************************************
 *                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
 *            __.'              ~.   .~              `.__
 *          .'//                  \./                  \\`.
 *        .'//                     |                     \\`.
 *      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
 *    .'//.-"                 `-.  |  .-'                 "-.\\`.
 *  .'//______.============-..   \ | /   ..-============.______\\`.
 *.'______________________________\|/______________________________`.
 *
 *
 *                     Don't forget to be awesome!                      
 **********************************************************************
 */

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * 数据输入流:DataInputStream
 * 1. 需要按照数据存储的顺序与类型读取
 */
public class PDataInputStream {
    public static void main(String[] args) throws Exception {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("f-io/src/data"));
        //数据写出时的顺序:
        /*dataOutputStream.writeByte(97);
        dataOutputStream.writeShort(3000);
        dataOutputStream.writeInt(858);
        dataOutputStream.writeLong(7956L);
        dataOutputStream.writeChar(97);
        dataOutputStream.writeBoolean(true);
        dataOutputStream.writeFloat(0.87F);
        dataOutputStream.writeDouble(585.8D);*/

        //按顺序读取数据
        System.out.println(dataInputStream.readByte());
        System.out.println(dataInputStream.readShort());
        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readLong());
        System.out.println(dataInputStream.readChar());
        System.out.println(dataInputStream.readBoolean());
        System.out.println(dataInputStream.readFloat());
        System.out.println(dataInputStream.readDouble());

        dataInputStream.close();
    }
}
