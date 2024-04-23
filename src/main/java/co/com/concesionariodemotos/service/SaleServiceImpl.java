package co.com.concesionariodemotos.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.concesionariodemotos.model.Client;
import co.com.concesionariodemotos.model.Moto;
import co.com.concesionariodemotos.model.Sale;
import co.com.concesionariodemotos.repository.ClientRepository;
import co.com.concesionariodemotos.repository.MotoRepository;
import co.com.concesionariodemotos.repository.SaleRepository;

@Service
public class SaleServiceImpl implements SaleService{
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private MotoRepository motoRepository;

    @Override
    public Sale createSale(Long clientId, List<Long> motoIds, BigDecimal total) {
        // Crea una nueva instancia de Sale
        Sale sale = new Sale();
        sale.setTotal(total);

        // Establece el usuario que realizó la compra
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("We can't find the client"));
        sale.setClientId(client);
        // Establece los productos que se compraron
        List<Moto> motos = motoRepository.findAllById(motoIds);
        sale.setMotos(motos);

        // Guarda la venta en la base de datos
        return saleRepository.save(sale);
    }

    @Override
    public Sale findSaleById(Long id) {
        // Busca una venta en la base de datos por su identificador
        return saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }

    @Override
    public List<Sale> findAllSales() {
        // Busca todas las ventas en la base de datos
        return saleRepository.findAll();
    }

    @Override
    public void deleteSaleById(Long id) {
        // Elimina una venta de la base de datos por su identificador
        saleRepository.deleteById(id);
    }

    @Override
    public Sale updateSale(Long id, Sale sale) {
        // Busca una venta en la base de datos por su identificador
        Sale existingSale = saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        // Actualiza los atributos de la venta
        existingSale.setTotal(sale.getTotal());
        existingSale.setClientId(sale.getClientId());
        existingSale.setMotos(sale.getMotos());

        // Guarda los cambios en la base de datos
        return saleRepository.save(existingSale);
    }

}