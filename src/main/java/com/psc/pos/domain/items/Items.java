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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private float prc_prc;

    @Builder
    public Items(Long id, String prd_title, String prd_code, String bar_code, String contributor, float prc_prc) {

        this.id = id;
        this.prd_title = prd_title;
        this.prd_code = prd_code;
        this.bar_code = bar_code;
        this.contributor = contributor;
        this.prc_prc = prc_prc;
    }

    public void update(String contributor, float price) {
        this.contributor = contributor;
        this.prc_prc = price;
    }
}
