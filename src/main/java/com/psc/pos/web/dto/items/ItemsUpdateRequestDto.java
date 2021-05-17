package com.psc.pos.web.dto.items;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemsUpdateRequestDto {

    private String title;
    private Long price;

    @Builder
    public ItemsUpdateRequestDto(String title, Long price) {
        this.title = title;
        this.price = price;
    }
}
