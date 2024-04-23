package co.com.concesionariodemotos.service;

import java.math.BigDecimal;
import java.util.List;

import co.com.concesionariodemotos.model.Sale;

public interface SaleService {

    Sale createSale(Long clientId, List<Long> motoIds, BigDecimal total);

    Sale findSaleById(Long id);

    List<Sale> findAllSales();

    void deleteSaleById(Long id);

    Sale updateSale(Long id, Sale sale);

}