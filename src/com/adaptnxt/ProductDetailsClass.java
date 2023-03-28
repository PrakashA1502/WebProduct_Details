package com.adaptnxt;

import java.io.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.adaptnxt.model.Product;

public class ProductDetailsClass 
{

	public static void main(String[] args) 
	{
		        String url = "https://www.quill.com/hanging-file-folders/cbl/4378.html";
		        ArrayList<Product> products = new ArrayList<>();

		        try 
		        {
		            // Send a GET request to the URL and parse the HTML response with Jsoup
		            Document doc = Jsoup.connect(url).get();

		            // Extract the product details from the HTML response
		            Elements productElements = doc.select(".card-body");
		            
		            for (Element productElement : productElements)
		            {
		                String name = productElement.select(".card-title").text().trim();
		                String product_code = productElement.select("data-skus").text().trim();
		                String price = productElement.select(".card-price__final-price").text().trim();
		                String rating = productElement.select(".sr-only").text().trim();
		                String reviews = productElement.select("div.star-ratings span.num-ratings").text().trim();
		                String brand = productElement.select("div.desc span.brand").text().trim();
		                String color = productElement.select("div.desc span.color").text().trim();
		                String material = productElement.select("div.desc span.material").text().trim();
		                String dimensions = productElement.select("div.desc span.dimensions").text().trim();
		                String weight = productElement.select("div.desc span.weight").text().trim();
		                
		                products.add(new Product(name,product_code, price, rating,reviews,brand,color,material,dimensions,weight));
		            }

		            // Sort the products by price and get the top 10 products
		            Collections.sort(products);
		            List<Product> top10Products = products.subList(0, Math.min(10, products.size()));

		            // Write the top 10 products to a CSV file
		            String filename ="product_details.csv3";
		            FileWriter writer = new FileWriter(filename);
		            writer.append("Product Name,Product_code,Price,Rating,Reviews,Brand,Color,Material,Dimensions,Weight");
		            
		            for (Product product : top10Products) 
		            {
		                writer.append(product.getName());
		                writer.append(product.getProduct_code());
		                writer.append(product.getPrice());
		                writer.append(product.getRating());
		                writer.append(product.getReviews());
		                writer.append(product.getBrand());
		                writer.append(product.getColor());
		                writer.append(product.getMaterial());
		                writer.append(product.getDimensions());
		                writer.append(product.getWeight());
		            }
		            writer.flush();
		            writer.close();
		            
		            System.out.println("Product Details has been Stored in "+"("+ filename +")"+" file");

		        } 
		        catch (IOException e) 
		        {
		            e.printStackTrace();
		        }
		    }

		   
		

	

}
