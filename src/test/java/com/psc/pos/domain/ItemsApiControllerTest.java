package com.psc.pos.domain;

import com.psc.pos.domain.items.Items;
import com.psc.pos.domain.items.ItemsRepository;
import com.psc.pos.web.dto.items.ItemsSaveRequestDto;
import com.psc.pos.web.dto.items.ItemsUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ItemsRepository itemsRepository;

    @After
    public void tearDown() throws  Exception {
        this.itemsRepository.deleteAll();
    }

    @Test
    public void Items_Create() throws  Exception {

        String title = "title_test";
        String barcode = "EMS1099022";
        Long price = 19000L;
        String url = "http://localhost:" + port + "/api/v1/items";

        ItemsSaveRequestDto requestDto = ItemsSaveRequestDto.builder()
                .title(title)
                .barcode(barcode)
                .price(price)
                .build();

        ResponseEntity<Long> responseEntity = this.restTemplate.postForEntity(url, requestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Items> all = this.itemsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getBarcode()).isEqualTo(barcode);



    }

    @Test
    public void Items_Update() throws Exception {

        Items save_items = this.itemsRepository.save(getSaveTestEntity());
        Long id = save_items.getId();


        String title = "title_update_test";

        ItemsUpdateRequestDto itemsUpdateRequestDto = ItemsUpdateRequestDto.builder()
                .title(title)
                .price(save_items.getPrice())
                .build();

        String url = "http://localhost:" + port + "/api/v1/items/" + id;

        HttpEntity<ItemsUpdateRequestDto> requestDtoHttpEntity = new HttpEntity<>(itemsUpdateRequestDto);

        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestDtoHttpEntity, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Items> all = this.itemsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);


    }

    @Test
    public void Items_Read() {

        String title = "title_test";
        String barcode = "EMS1099022";
        Long price = 19000L;

        this.itemsRepository.save(Items.builder()
                .title(title)
                .barcode(barcode)
                .price(price)
                .build());


        List<Items> items = this.itemsRepository.findAll();

        Items item = items.get(0);
        assertThat(item.getTitle()).isEqualTo(title);
        assertThat(item.getBarcode()).isEqualTo(barcode);
    }


    @Test
    public void BaseTimeEntity_Register() {

        LocalDateTime now = LocalDateTime.of(2021,5,17,4,5,0);
        this.itemsRepository.save(getSaveTestEntity());

        List<Items> itemsList = this.itemsRepository.findAll();

        Items item = itemsList.get(0);

        assertThat(item.getCreatedDate()).isAfter(now);
        assertThat(item.getModifiedDate()).isAfter(now);
    }


    ItemsSaveRequestDto getSaveTestDto() {

        String title = "title_test";
        String barcode = "EMS1099022";
        Long price = 19000L;

        return ItemsSaveRequestDto.builder()
                .title(title)
                .barcode(barcode)
                .price(price)
                .build();
    }

    Items getSaveTestEntity() {

        String title = "title_test";
        String barcode = "EMS1099022";
        Long price = 19000L;

        return Items.builder()
                .title(title)
                .barcode(barcode)
                .price(price)
                .build();

    }
}
