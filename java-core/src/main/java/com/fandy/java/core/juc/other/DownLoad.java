package com.fandy.java.core.juc.other;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;


public class DownLoad {

    private URL url=null;
    private URLConnection connection=null;
    public DownLoad()
    {

    }
    public static void main(String[] args) throws IOException
    {
        DownLoad load=new DownLoad();
        load.download("http://www.kmabc.com/satan/qhc.mp3","青花瓷.mp3",1024);
        load.close();
    }
    private void close()
    {

    }
    /**
     *
     * @param string 下载地址
     * @param buffer 缓冲区大小
     * @param string2 保存地址
     * @throws IOException
     */
    private void download(String string, String string2,int buffer) throws IOException
    {
        this.url=new URL(string);

        this.connection=url.openConnection();
        connection.setRequestProperty("","");

        BufferedInputStream in=new BufferedInputStream(this.connection.getInputStream());
        FileOutputStream out=new FileOutputStream(string2);
        byte[] bs=new byte[buffer];
        int n=0;
        int i=0;
        while((n=in.read(bs))!=-1)
        {
            out.write(bs,0,n);
            i++;
            System.out.println("下载中..."+i);
        }
        out.flush();
        out.close();
        in.close();
    }

}
