package br.edu.ifrs.canoas.jee.maven.bo;

import br.edu.ifrs.canoas.jee.maven.dao.ProductDAO;
import br.edu.ifrs.canoas.jee.maven.dao.ProductDAOImpl;
import br.edu.ifrs.canoas.jee.maven.dto.Product;

public class ProductBOImpl implements ProductBO {
	ProductDAO dao = new ProductDAOImpl();

	@Override
	public void create(Product product) {
		// TODO Auto-generated method stub
		dao.create(product);
		
	}

	@Override
	public Product find(Integer id) {
		 
		return dao.retrieve(id);
	}
}
