  package productcrud.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrud.dao.ProductDao;
import productcrud.model.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productDao;

	//for index page
	@RequestMapping("/")
	public String home(Model m)
	{
		List<Product> products = productDao.getProducts();
		m.addAttribute("products" , products);
		return "index";
	}
	
	//Show add Product Form
	@RequestMapping("/add-product")
	public String addProduct(Model m)
	{
		m.addAttribute("title","Add Product");
		return "add_product_form";
	}
	
	//handle add Product Form
	@RequestMapping(value="/handle-product" , method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request)
	{
		//System.out.println(product);
		productDao.createProduct(product);
		RedirectView redirect = new RedirectView();
		redirect.setUrl(request.getContextPath()+ "/");
		return redirect;
	}
	
	 
	//Handle to delete
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId ,HttpServletRequest request)
	{
		this.productDao.deleteProduct(productId);
		RedirectView redirect = new RedirectView();
		redirect.setUrl( request.getContextPath()+ "/");
		return redirect;
	}
	
	@RequestMapping("/update/{productId}")
	public String updateForm(@PathVariable("productId") int productId , Model m)
	{
		Product product = this.productDao.getProduct(productId);
		m.addAttribute("product",product);
		return "update_form";
	}
}
