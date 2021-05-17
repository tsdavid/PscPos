package com.psc.pos.web.dto.items;

import com.psc.pos.domain.items.Items;
import lombok.Getter;

@Getter
public class ItemsResponseDto {

    private Long id;
    private String title;
    private String barcode;
    private Long price;

    public ItemsResponseDto(Items entity) {

        this.id = entity.getId();
        this.title = entity.getTitle();
        this.barcode = entity.getBarcode();
        this.price = entity.getPrice();
    }
}
