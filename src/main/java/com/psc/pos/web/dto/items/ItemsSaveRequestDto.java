package com.psc.pos.web.dto.items;

import com.psc.pos.domain.items.Items;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemsSaveRequestDto {

    private String title;
    private String barcode;
    private Long price;

    @Builder
    public ItemsSaveRequestDto(String title, String barcode, Long price) {

        this.title = title;
        this.barcode = barcode;
        this.price = price;
    }

    public Items toEntity() {

        return  Items.builder()
                .title(title)
                .barcode(barcode)
                .price(price)
                .build();
    }
}
