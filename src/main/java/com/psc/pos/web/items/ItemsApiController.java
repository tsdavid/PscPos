package com.psc.pos.web.items;


import com.psc.pos.service.items.ItemsService;
import com.psc.pos.web.dto.items.ItemsResponseDto;
import com.psc.pos.web.dto.items.ItemsSaveRequestDto;
import com.psc.pos.web.dto.items.ItemsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ItemsApiController {

    private final ItemsService itemsService;

    @PostMapping("/api/v1/items")
    public Long save(@RequestBody ItemsSaveRequestDto requestDto) {
        return this.itemsService.save(requestDto);
    }

    @PutMapping("/api/v1/items/{id}")
    public Long update(@PathVariable Long id,
                       @RequestBody ItemsUpdateRequestDto requestDto) {
        return this.itemsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/items/{id}")
    public ItemsResponseDto findById(@PathVariable Long id) {
        return this.itemsService.findById(id);
    }

}
