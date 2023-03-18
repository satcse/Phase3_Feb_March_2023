package com.test.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/webapi")
public class ProductController {
	
	//REST Client  - PostMan
	//PostMan (REST Client) --> Controller --> Service --> Repository --> Entity --> Database
	
	@Autowired
    ProductService productService;
	
	@RequestMapping("/allproduct") // URL --> http://localhost:8080/webapi/allproduct
    public List<ProductEntity> getAllProduct()
    {
    	return productService.getAllProduct();
    }
	
	@RequestMapping("/product/{id}") // URL --> http://localhost:8080/webapi/product/11
    public ProductEntity getProduct(@PathVariable int id)
    {
    	return productService.getProduct(id);
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/product")   // URL --> http://localhost:8080/webapi/product
    public void addProduct(@RequestBody ProductEntity pe ) {
        productService.addProduct(pe);
    }
	
	@RequestMapping(method=RequestMethod.PUT, value="/product/{id}") // URL --> http://localhost:8080/webapi/product/11
    public void updateProduct(@PathVariable int id, @RequestBody ProductEntity pe ) {
        productService.updateProduct(id, pe);
    }   

    @RequestMapping(method=RequestMethod.DELETE, value="/product/{id}") // URL --> http://localhost:8080/webapi/product/11
    public void deleteProduct(@PathVariable int id)  {
        productService.deleteProduct(id);
    }   


}
