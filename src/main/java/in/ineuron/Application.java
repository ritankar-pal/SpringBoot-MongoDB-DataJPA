package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.dto.CustomerDTO;
import in.ineuron.service.CustomerMgmtService;
import in.ineuron.service.ICustomerMgmtService;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(Application.class, args);
		ICustomerMgmtService service = factory.getBean(CustomerMgmtService.class);
		
		
		//insert one customer:
		
		  String status = service.registerCustomer(new CustomerDTO(17, "Rimi", 650.40f)); 
		  System.out.println(status);
		 
		
		
		System.out.println();
		//findAll() customers::
//		service.findAllCustomers().forEach(System.out::println);
		
		//delete:
		/*
		 * String status = service.removeCustomer("658e72844fea167a7f10d42c");
		 * System.out.println(status);
		 */
		
		((ConfigurableApplicationContext) factory).close();
	}

}
