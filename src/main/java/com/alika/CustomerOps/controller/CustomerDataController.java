package com.alika.CustomerOps.controller;

import com.alika.CustomerOps.Exceptions.CustomerNotFoundException;
import com.alika.CustomerOps.Service.CustomerDataService;
import com.alika.CustomerOps.dto.CustomerDTO;
import com.alika.CustomerOps.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/customer")
public class CustomerDataController {

    @Autowired
    CustomerDataService customerDataService;

    /**
     * This API will create a new Customer object in DB by using CustomerDTO as input
     * @param customerDTO
     * @return ResponseEntity<Customer>
     */
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = customerDataService.createCustomer(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    /**
     * This API will fetch customer based on id or else will return exception data to client.
     * @param id
     * @return ResponseEntity<Customer>
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable(value = "id")  Long id){
        Customer customer = null;
        try {
            customer = customerDataService.findCustomer(id);
        } catch (CustomerNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }



}
