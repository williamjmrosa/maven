package br.edu.ifrs.canoas.jee.maven.dao;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifrs.canoas.jee.maven.bo.ProductBO;
import br.edu.ifrs.canoas.jee.maven.bo.ProductBOImpl;
import br.edu.ifrs.canoas.jee.maven.dto.Product;

public class ProductDAOImplTest {

	private ProductDAO dao;
	private ProductBO bo;
	@Before
	public void setup(){
		dao = new ProductDAOImpl();
		bo = new ProductBOImpl();
	}

	@Test
	public void testCreateShouldCreateAProduct() {
		Product product = this.getProduct();

		//Busca o produto pelo Id
		Product retrievedProduct = dao.retrieve(product.getId());

		//Verifica que não existe o produto na camada de persistência
		assertThat(retrievedProduct).isNull();

		//Cria um novo produto
		dao.create(product);

		//Busca o produto pelo Id novamente
		retrievedProduct = dao.retrieve(product.getId());

		//Verifica que o produto de nome Phone agora existe.
		assertThat(retrievedProduct.getName()).isEqualTo("Phone");
		assertThat(retrievedProduct.getDescription()).isEqualTo("Awesome product!");
		assertThat(retrievedProduct.getPrice()).isEqualTo(100.2f);
		
		retrievedProduct = this.getProductUpdate();
		
		dao.update(retrievedProduct);
		
		retrievedProduct = dao.retrieve(retrievedProduct.getId());
		
		assertThat(retrievedProduct.getName()).isEqualTo("Celular");
		assertThat(retrievedProduct.getDescription()).isEqualTo("Produto Novo");
		assertThat(retrievedProduct.getPrice()).isEqualTo(100.2f);
		
		dao.delete(retrievedProduct.getId());
		
		retrievedProduct = dao.retrieve(retrievedProduct.getId());
		
		assertThat(retrievedProduct).isNull();
	}
	@Test
	public void testProdutoBO() {
		Product product = this.getProductUpdate();
		bo.create(product);
		Product retrievedProduct = bo.find(product.getId());
		
		assertThat(retrievedProduct.getName()).isEqualTo("Celular");
		assertThat(retrievedProduct.getDescription()).isEqualTo("Produto Novo");
		assertThat(retrievedProduct.getPrice()).isEqualTo(100.2f);
		
	}

 	private Product getProduct(){
		Product product = new Product();
		product.setId(1);
		product.setName("Phone");
		product.setDescription("Awesome product!");
		product.setPrice(100.2f);
		return product;
	}

 	private Product getProductUpdate(){
		Product product = new Product();
		product.setId(1);
		product.setName("Celular");
		product.setDescription("Produto Novo");
		product.setPrice(100.2f);
		return product;
	}
 	
}