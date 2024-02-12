package kr.co.shield.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderDto {
	
	private String paymentType; // (plan|additional)
	
	private String servicePlan; // (basic|standard)
	private String servicePeriod; // month
	
	private List<Product> products;
	
	@Getter
	public class Product {
		private String productTp; // (plan|traffic,profile,account)
		private int productCnt;
	}
	
}
