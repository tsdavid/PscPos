package com.psc.pos.web.dto.items;

import com.psc.pos.domain.items.Items;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ItemsListResponseDto {

    private Long id;
    private String title;
    private String barcode;
    private Long price;
    private LocalDateTime modifiedDate;

    public ItemsListResponseDto(Items entity) {

        this.id = entity.getId();
        this.title = entity.getTitle();
        this.barcode = entity.getBarcode();
        this.price = entity.getPrice();
        this.modifiedDate = entity.getModifiedDate();
    }


}
