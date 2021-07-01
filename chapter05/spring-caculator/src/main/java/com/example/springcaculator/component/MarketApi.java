package com.example.springcaculator.component;

import org.springframework.stereotype.Component;

@Component
public class MarketApi {
    public int connect(){
        //현재는 임의로 환율을 정했는데, naver, google,... 에서 가져와서 쓸 수있다.
        //naver
        //kakao
        return 1100;
    }
}
