package in.ineuron.document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Document   //For SQL we call it @Entity and @Document for MongoDB
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {
	
	@Id
	private String id;
	
	@NonNull
	private Integer cno;
	
	@NonNull
	private String cname;
	
	@NonNull
	private Float billAmount;
	
	
}
