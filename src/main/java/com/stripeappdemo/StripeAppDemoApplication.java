package com.stripeappdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stripeappdemo.models.Product;
import com.stripeappdemo.repository.ProductRepository;


@SpringBootApplication
public class StripeAppDemoApplication implements CommandLineRunner{
	
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(StripeAppDemoApplication.class, args);
	}
	
	@Override
	public void run(String... strings) throws Exception {
		Product product1 = new Product();
		product1.setName("macbook");
		product1.setDescription("Just when you thought your MacBook Pro was state of the art, Apple introduces the new MackBook Pro with new advanced processing power and graphics.");
		product1.setPrice(2897.23);

		Product product2 = new Product();
		product2.setName("iphone8");
		product2.setDescription("iPhone 8 dramatically improves the most important aspects of the iPhone experience. It introduces advanced new camera systems. The best performance and battery life ever in an iPhone.");
		product2.setPrice(978.14);

		Product product3 = new Product();
		product3.setName("iphonexsmax");
		product3.setDescription(" iPhone Xs Max build on the all-screen design of iPhone X and feature the sharpest displays with the highest pixel density of any Apple device. Now offered in 6.5-inch sizes,1 these Super Retina displays with a custom OLED design support Dolby Vision and HDR10 and have iOS system-wide color management for the best color accuracy in the industry. ");
		product3.setPrice(1228.45);
		
		if (productRepository.findByName("macbook")==null) {
			productRepository.save(product1);
		}
		
		if (productRepository.findByName("iphone8")==null) {
			productRepository.save(product2);
		}
		if (productRepository.findByName("iphonexsmax")==null) {
			productRepository.save(product3);
		}
	}
}
