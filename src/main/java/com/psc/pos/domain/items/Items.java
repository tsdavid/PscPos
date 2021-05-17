package com.psc.pos.domain.items;


import com.psc.pos.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Items extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String barcode;

    private Long price;

    @Builder
    public Items(String title, String barcode, Long price) {

        this.title = title;
        this.barcode = barcode;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", barcode='" + barcode + '\'' +
                ", price=" + price +
                '}';
    }

    public void update(String title, Long price) {

        this.title = title;
        this.price = price;
    }
}
