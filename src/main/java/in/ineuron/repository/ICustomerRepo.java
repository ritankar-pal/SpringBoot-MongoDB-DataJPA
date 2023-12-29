package in.ineuron.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.ineuron.document.Customer;


public interface ICustomerRepo extends MongoRepository<Customer, String> {

}
