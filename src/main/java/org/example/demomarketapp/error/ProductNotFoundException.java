package org.example.demomarketapp.error;

public class ProductNotFoundException extends IllegalArgumentException{

  public ProductNotFoundException(Long id) {
    super(String.format("Product with id %s not found%n", id));
  }

  public ProductNotFoundException(String title) {
    super(String.format("Product with title %s not found%n", title));
  }
}
