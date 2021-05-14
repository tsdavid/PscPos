package com.psc.pos.domain.items;


import com.psc.pos.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Items extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //3
    private Long id;


    @Column(length = 100, nullable = false)
    private String prd_title;

    @Column(length = 100, nullable = false)
    private String prd_code;

    @Column(length = 500, nullable = false)
    private String contributor;

    @Column(length = 200, nullable = false)
    private String bar_code;

    @Column
    private String prc_prc;

    @Builder
    public Items(String prd_title, String prd_code, String contributor, String bar_code, String prc_prc) {

        this.prd_title = prd_title;
        this.prd_code = prd_code;
        this.contributor = contributor;
        this.bar_code = bar_code;
        this.prc_prc = prc_prc;
    }

//    public void update(String contributor, float price) {
//
//        this.contributor = contributor;
//        this.prc_prc = price;
//    }
}
