package com.psc.pos.web.dto;

import com.psc.pos.domain.items.Items;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemSaveRequestDto {

    private String prd_title;
    private String prd_code;
    private String contributor;
    private String bar_code;
    private String prc_prc;

    @Builder
    public ItemSaveRequestDto(String prd_title, String prd_code, String contributor, String bar_code, String prc_prc) {

        this.prd_title = prd_title;
        this.prd_code = prd_code;
        this.contributor = contributor;
        this.bar_code = bar_code;
        this.prc_prc = prc_prc;
    }

    public Items toEntity() {

        return Items.builder()
                .prd_title(prd_title)
                .prd_code(prd_code)
                .contributor(contributor)
                .bar_code(bar_code)
                .prc_prc(prc_prc)
                .build();
    }
}
