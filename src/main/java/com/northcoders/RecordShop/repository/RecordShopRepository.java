package com.northcoders.RecordShop.repository;

import com.northcoders.RecordShop.model.Record;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordShopRepository extends CrudRepository<Record, Long> {
}
