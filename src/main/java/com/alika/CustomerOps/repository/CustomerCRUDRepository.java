package com.alika.CustomerOps.repository;

import com.alika.CustomerOps.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCRUDRepository extends CrudRepository<Customer,Long> {

}
