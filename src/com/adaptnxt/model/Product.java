package com.adaptnxt.model;


public class Product  implements Comparable<Product>
{
	        private String name;
	        private String product_code;
	        private String price;
	        private String rating;
	        private String reviews;
	        private String brand;
	        private String color;
	        private String material;
	        private String dimensions;
	        private String weight;
	        
	        
			public Product(String name, String product_code, String price, String rating, String reviews, String brand,
					String color, String material, String dimensions, String weight) 
			{
				super();
				this.name = name;
				this.product_code = product_code;
				this.price = price;
				this.rating = rating;
				this.reviews = reviews;
				this.brand = brand;
				this.color = color;
				this.material = material;
				this.dimensions = dimensions;
				this.weight = weight;
			}
			
			
			public String getName()
			{
				return name;
			}
			public String getProduct_code() 
			{
				return product_code;
			}
			public String getPrice() 
			{
				return price;
			}
			public String getRating()
			{
				return rating;
			}
			public String getReviews()
			{
				return reviews;
			}
			public String getBrand() 
			{
				return brand;
			}
			public String getColor()
			{
				return color;
			}
			public String getMaterial() 
			{
				return material;
			}
			public String getDimensions() 
			{
				return dimensions;
			}
			public String getWeight() 
			{
				return weight;
			}
			
			//Override
			 public int compareTo(Product o) 
			 {
		            double price1 = Double.parseDouble(price.replaceAll("\\$", ""));
		            double price2 = Double.parseDouble(o.getPrice().replaceAll("\\$", ""));
		            return Double.compare(price1, price2);
		        }
	        

	       
}
