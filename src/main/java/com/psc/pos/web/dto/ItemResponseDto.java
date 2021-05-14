package com.psc.pos.web.dto;

import com.psc.pos.domain.items.Items;
import lombok.Getter;

@Getter
public class ItemResponseDto {

    private Long id;
    private String prd_title;
    private String prd_code;
    private String contributor;
    private String bar_code;
    private String prc_prc;

    public ItemResponseDto(Items entity){
        this.id = entity.getId();
        this.prd_title = entity.getPrd_title();
        this.prd_code = entity.getPrd_code();
        this.contributor = entity.getContributor();
        this.bar_code = entity.getBar_code();
        this.prc_prc = entity.getPrc_prc();
    }

}
