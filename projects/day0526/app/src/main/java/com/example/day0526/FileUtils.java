package com.example.day0526;

import android.content.Context;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FileUtils {

    public boolean write(Context context,String content,String filename) {
        boolean flag=false;
        FileOutputStream os=null;
        try {
            os = context.openFileOutput(filename, Context.MODE_PRIVATE);
            os.write(content.getBytes());
            flag=true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (os != null){
                try{
                    os.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }
    public String read(Context context,String filename)
    {
        FileInputStream fis=null;
        StringBuffer sb = new StringBuffer();
        BufferedReader br=null;
        String line=null;
        try {
            fis = context.openFileInput(filename);
            br=new BufferedReader(new InputStreamReader(fis,"utf-8"));
            while ((line = br.readLine())!=null){
                sb.append(line).append("\r\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br!=null){
                try {
                    br.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (fis!=null){
                try {
                    fis.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
