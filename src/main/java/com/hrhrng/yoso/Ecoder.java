package com.hrhrng.yoso;

public interface Ecoder<E> {
    E encoder(byte[] bytes);
}
