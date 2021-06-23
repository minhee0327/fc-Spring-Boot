package com.example.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class Encoder {
    private IEncoder iEncoder;

    //baseEncoder, urlEncoder 둘중 어떤건지 몰라서 에러 = > @Qualifier
    public Encoder( IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }

    public void setIEncoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }
}
