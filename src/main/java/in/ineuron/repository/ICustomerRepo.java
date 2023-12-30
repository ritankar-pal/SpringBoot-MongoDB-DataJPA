package in.ineuron.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.ineuron.document.Customer;


public interface ICustomerRepo extends MongoRepository<Customer, String> {
	public List<Customer> findByBillAmountBetween(Float minAmount, Float maxAmount);
	public List<Customer> findByCaddressInAndCmobileIsNotNull(String... address);
}
