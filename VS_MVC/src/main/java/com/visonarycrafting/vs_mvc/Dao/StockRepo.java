package com.visonarycrafting.vs_mvc.Dao;

import com.visonarycrafting.vs_mvc.Entities.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepo  extends CrudRepository<Stock,Long> {
}
