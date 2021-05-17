package com.psc.pos.domain.items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Items, Long> {

    @Query("SELECT p FROM Items p ORDER BY p.id DESC ")
    List<Items> findAllDesc();

    @Query("SELECT p FROM  Items p WHERE p.barcode like %?1%")
    List<Items> findItemsByBarcode(String barcode);
}
