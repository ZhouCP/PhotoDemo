package com.kelvin.photodemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by kelvin on 16/4/20.
 */
public class FileUtils {

    /**
     *
     * @param fromPath 被复制的文件路径
     * @param toPath 复制的目录文件路径
     * @param rewrite 是否重新创建文件
     *
     * <p>文件的复制操作方法
     */
    public static void copyfile(String fromPath, String toPath, Boolean rewrite ){

        File fromFile = new File(fromPath);
        File toFile = new File(toPath);

        if(!fromFile.exists()){
            return;
        }
        if(!fromFile.isFile()){
            return;
        }
        if(!fromFile.canRead()){
            return;
        }
        if(!toFile.getParentFile().exists()){
            toFile.getParentFile().mkdirs();
        }
        if(toFile.exists() && rewrite){
            toFile.delete();
        }

        try {
            FileInputStream fosfrom = new FileInputStream(fromFile);
            FileOutputStream fosto = new FileOutputStream(toFile);

            byte[] bt = new byte[1024];
            int c;
            while((c=fosfrom.read(bt)) > 0){
                fosto.write(bt,0,c);
            }
            //关闭输入、输出流
            fosfrom.close();
            fosto.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
