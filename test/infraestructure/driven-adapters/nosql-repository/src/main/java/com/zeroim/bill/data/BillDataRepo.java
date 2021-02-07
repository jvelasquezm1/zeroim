package com.zeroim.bill.data;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BillDataRepo extends ReactiveCrudRepository<BillData, Long> {
}
