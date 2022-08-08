package com.hrhrng.yoso;

public class FileReader<E>{


    Ecoder ecoder;
    byte slice;

    public FileReader(Ecoder ecoder, byte slice) {
        this.ecoder = ecoder;
        this.slice = slice;
    }
}
