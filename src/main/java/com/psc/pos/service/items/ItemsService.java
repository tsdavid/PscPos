package com.psc.pos.service.items;

import com.psc.pos.domain.items.Items;
import com.psc.pos.domain.items.ItemsRepository;
import com.psc.pos.web.dto.ItemResponseDto;
import com.psc.pos.web.dto.ItemSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ItemsService {

    private final ItemsRepository repository;

    @Transactional
    public Long save(ItemSaveRequestDto requestDto) {

        Items objj = this.repository.save(requestDto.toEntity());
        System.out.println(objj.getPrc_prc());

        return objj.getId();
    }

}
