package com.psc.pos.service.items;


import com.psc.pos.domain.items.Items;
import com.psc.pos.domain.items.ItemsRepository;
import com.psc.pos.web.dto.items.ItemsListResponseDto;
import com.psc.pos.web.dto.items.ItemsResponseDto;
import com.psc.pos.web.dto.items.ItemsSaveRequestDto;
import com.psc.pos.web.dto.items.ItemsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ItemsService {

    private final ItemsRepository itemsRepository;

    @Transactional
    public Long save(ItemsSaveRequestDto requestDto) {
        return this.itemsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ItemsUpdateRequestDto requestDto) {

        Items items = this.itemsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No Content exists. id = " + id)
        );

        items.update(requestDto.getTitle(), requestDto.getPrice());
        return id;
    }

    public ItemsResponseDto findById(Long id) {
        Items entity = this.itemsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No Content exist. id = " + id)
        );
        return new ItemsResponseDto(entity);
    }

    @Transactional
    public List<ItemsListResponseDto> findAllDesc() {
        return this.itemsRepository.findAllDesc().stream()
                .map(ItemsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ItemsListResponseDto> findByBarcode(String barcode) {
        return this.itemsRepository.findItemsByBarcode(barcode).stream()
                .map(ItemsListResponseDto::new)
                .collect(Collectors.toList());
    }



    @Transactional
    public void delete(Long id) {

        Items items = this.itemsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No Content Exist. ID = " + id)
        );
        this.itemsRepository.delete(items);
    }


}
