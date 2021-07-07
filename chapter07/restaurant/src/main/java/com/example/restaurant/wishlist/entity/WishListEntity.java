package com.example.restaurant.wishlist.entity;

import com.example.restaurant.db.MemoryDBEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WishListEntity extends MemoryDBEntity {

    private String title;               //음식명, 장소명
    private String category;            //카테고리
    private String address;             //주소
    private String roadAdress;         //도로명
    private String homePageLink;        //홈페이지주소
    private String imageLink;           //이미지
    private boolean isVisit;            //방문여부
    private int visitCount;             //방문횟수
    private LocalDateTime lastVisitDate;//마지막 방문 일자

}
