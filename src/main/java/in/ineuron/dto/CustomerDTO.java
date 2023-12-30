package in.ineuron.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {
	
	private Integer cno;
	private String cname;
	private String caddress;
	private Float billAmount;
	private Long cmobile;
}
