package demo131_Hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HotelController {
@Bean
public RestTemplate getRestTemplate() {
	return  new RestTemplate();
}
// @Autowired
public  RestTemplate  restTemplate=new RestTemplate();
static final String STUDENT_URL_MS="http://localhost:1414/";
@GetMapping("find/{id}")
public String fetchStudent(@PathVariable int id)
{
Product product=restTemplate.exchange(STUDENT_URL_MS +"product/"+id,HttpMethod.GET,null,Product.class).getBody();

return restTemplate.exchange(STUDENT_URL_MS +"product/"+id,HttpMethod.GET,null,String.class,Product.class).getBody();
// return restTemplate.getForObject(STUDENT_URL_MS+"product/"+id,String.class);
}
@GetMapping("find")
public String fetchProducts()
{
return  restTemplate.exchange(STUDENT_URL_MS +"productall",HttpMethod.GET,null,String.class,Product.class).getBody();	
}
@PostMapping("/addproduct")
public String addProduct(@RequestBody Product product)
{
	return restTemplate.postForObject(STUDENT_URL_MS+"add",Product.class,String.class);
}



	
}
