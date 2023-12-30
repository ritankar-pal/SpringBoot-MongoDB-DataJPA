package in.ineuron.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.document.Customer;
import in.ineuron.dto.CustomerDTO;
import in.ineuron.generator.IdGenerator;
import in.ineuron.repository.ICustomerRepo;


@Service("service")
public class CustomerMgmtService implements ICustomerMgmtService {

	@Autowired
	private ICustomerRepo repo;
	
	
	@Override
	public String registerCustomer(CustomerDTO dto) {
		System.out.println(repo.getClass().getName()); //check the implementation class
		
		
		if(dto != null) {
			Customer document = new Customer();
			document.setId(IdGenerator.generateID());
			BeanUtils.copyProperties(dto, document); //creating out own ID
			document = repo.insert(document);
			
			return "Document is Saved with the ID: " + document.getId();
		}
		
		return "Document Failed to Save";
	}


	@Override
	public List<Customer> findAllCustomers() {
		List<Customer> customers = repo.findAll();
		return customers;
	}


	@Override
	public String removeCustomer(String id) {
		
		Optional<Customer> optional = repo.findById(id);
		
		if(optional.isPresent()) {
			Customer customer = optional.get();
			repo.delete(customer);
			return "Document Successfully Deleted...";
		}
		
		return "Dcument Deletion Failed...";
	}


	@Override
	public List<Customer> fetchCustomerByBillAmount(Float min, Float max) {
		return repo.findByBillAmountBetween(min, max);
	}


	@Override
	public List<Customer> fetchCustomerByAddressAndHavingMobileNo(String... address) {
		return repo.findByCaddressInAndCmobileIsNotNull(address);
	}

}
