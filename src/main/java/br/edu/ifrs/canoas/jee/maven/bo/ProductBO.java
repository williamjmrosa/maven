package br.edu.ifrs.canoas.jee.maven.bo;

import br.edu.ifrs.canoas.jee.maven.dto.Product;

public interface ProductBO {
	public void create(Product product);
	
	public Product find(Integer id);
}
