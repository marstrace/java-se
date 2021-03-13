package top.top7.io;

/******
 *       Created by LEARNING on 2020/11/3 16:26.
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

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * DataOutputStream:数据输出流
 */
public class PDateOutputStream {
    public static void main(String[] args) throws Exception{
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("f-io/src/data"));
        dataOutputStream.writeByte(97);
        dataOutputStream.writeShort(3000);
        dataOutputStream.writeInt(858);
        dataOutputStream.writeLong(7956L);
        dataOutputStream.writeChar(97);
        dataOutputStream.writeBoolean(true);
        dataOutputStream.writeFloat(0.87F);
        dataOutputStream.writeDouble(585.8D);




        // size() 返回数据所占字节数
        int size = dataOutputStream.size();
        System.out.println(size);
        dataOutputStream.close();
    }
}
