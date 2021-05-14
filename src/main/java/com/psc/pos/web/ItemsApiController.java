package com.psc.pos.web;


import com.psc.pos.service.items.ItemsService;
import com.psc.pos.web.dto.ItemResponseDto;
import com.psc.pos.web.dto.ItemSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ItemsApiController {

    private final ItemsService itemsService;

    @PostMapping("/api/v1/items")
    public Long save(@RequestBody ItemSaveRequestDto requestDto) {
        return itemsService.save(requestDto);
    }


//    @GetMapping("/api/v1/items/{id}")
//    public ItemResponseDto findById(@PathVariable String barCode) {
//
//        return this.itemsService.findByBarcode(barCode);
//    }
}
