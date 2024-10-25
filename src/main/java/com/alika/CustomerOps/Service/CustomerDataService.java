package com.alika.CustomerOps.Service;

import com.alika.CustomerOps.Exceptions.CustomerNotFoundException;
import com.alika.CustomerOps.dto.CustomerDTO;
import com.alika.CustomerOps.entity.Customer;
import com.alika.CustomerOps.repository.CustomerCRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomerDataService {

    @Autowired
    CustomerCRUDRepository crudRepository;

    public Customer createCustomer(CustomerDTO customerDTO){

        Customer customerObj = Customer.builder()
                .firstName(customerDTO.getFirstName())
                .lastName(customerDTO.getLastName())
                .dateOfBirth(customerDTO.getDateOfBirth())
                .createdBy("SYSTEM")
                .createdDate(LocalDateTime.now())
                .build();
        Customer customerDBObj = crudRepository.save(customerObj);

        return customerDBObj;
    }

    public Customer findCustomer(Long id) throws CustomerNotFoundException {
        Optional<Customer> customerDBObj = crudRepository.findById(id);

        if(customerDBObj.isEmpty())
        {
            throw new CustomerNotFoundException("Customer is not found for the provided ID - "+id);
        }

        return customerDBObj.get();

    }
}
