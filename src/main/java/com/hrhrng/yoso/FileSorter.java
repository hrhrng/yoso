package com.hrhrng.yoso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileSorter<E> {

    private SwapHeap<E> swapHeap;
    private WinnerTree<E> winnerTree;
    // 读取文件的方式
    private FileReader fileReader;
    // 原始数据文件
    private File rowFile;

    public FileSorter(FileReader fileReader, File file) throws IOException {
        this.fileReader = fileReader;
        this.rowFile = file;
        FileChannel fc =  new FileInputStream(rowFile).getChannel();
        MappedByteBuffer map = fc.map(FileChannel.MapMode.READ_ONLY, 0, 1024*1024);
        map.getLong(0);

    }

    public File sort() {
        return new File("/sortd.txt");
    }
    private byte[] cache = new byte[100] ;

}
