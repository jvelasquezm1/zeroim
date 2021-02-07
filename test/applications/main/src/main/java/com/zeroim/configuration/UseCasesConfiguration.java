package com.zeroim.configuration;

import com.zeroim.bill.BillDetailUseCase;
import com.zeroim.bill.BillUseCase;
import com.zeroim.bill.gateway.BillDetailRepo;
import com.zeroim.bill.gateway.BillRepo;
import com.zeroim.client.BuyerUseCase;
import com.zeroim.client.IdTypeUseCase;
import com.zeroim.client.gateway.BuyerRepo;
import com.zeroim.client.gateway.IdTypeRepo;
import com.zeroim.product.ProductUseCase;
import com.zeroim.product.gateway.ProductRepository;
import com.zeroim.stock.StockItemUseCase;
import com.zeroim.stock.gateway.StockItemRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfiguration {

    @Bean
    public ProductUseCase productUseCase(ProductRepository productRepository) {
        return new ProductUseCase(productRepository);
    }

    @Bean
    public BillUseCase billUseCase(BillRepo billRepo) {
        return new BillUseCase(billRepo);
    }

    @Bean
    public BillDetailUseCase billDetailUseCase(BillDetailRepo billDetailRepo) {
        return new BillDetailUseCase(billDetailRepo);
    }

    @Bean
    public BuyerUseCase buyerUseCase(BuyerRepo buyerRepo) {
        return new BuyerUseCase(buyerRepo);
    }

    @Bean
    public IdTypeUseCase idTypeUseCase(IdTypeRepo idTypeRepo) {
        return new IdTypeUseCase(idTypeRepo);
    }

    @Bean
    public StockItemUseCase stockItemUseCase(StockItemRepo stockItemRepo) {
        return new StockItemUseCase(stockItemRepo);
    }

}
