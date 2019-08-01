package com.hvh.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hvh.model.InvoiceDTO;
import com.hvh.model.InvoiceItemDTO;
import com.hvh.model.ProductDTO;
import com.hvh.model.SettingDTO;
import com.hvh.model.UserDTO;
import com.hvh.service.CartService;
import com.hvh.service.InvoiceItemService;
import com.hvh.service.InvoiceService;
import com.hvh.service.ProductService;
import com.hvh.service.SettingService;
import com.hvh.service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	long millis = System.currentTimeMillis();
	java.util.Date created_at = new java.util.Date(millis);
	java.util.Date updated_at = new java.util.Date(millis);
	
	@Autowired
	ProductService productService;
	
	@Autowired
	InvoiceService invoiceService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	InvoiceItemService invoiceItemService;

	@Autowired
	SettingService settingService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value = {"/product","/"}, method = RequestMethod.GET)
	public String getProduct(Model model, HttpServletRequest req) {
		int pages = req.getParameter("pages") == null ? 1 : Integer.parseInt(req.getParameter("pages"));
		int limit = req.getParameter("limit") == null ? 8 : Integer.parseInt(req.getParameter("limit"));
		List<ProductDTO> productDTOs = productService.getListProduct(pages, limit);
		model.addAttribute("productDTOs", productDTOs);
		model.addAttribute("pages", pages);
		model.addAttribute("size", productService.getListProduct(1, 10000).size());
		return "homeAdmin";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String getProductByName(Model model, HttpServletRequest req) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("product_name", req.getParameter("productName") != null ? req.getParameter("productName") : "");
		params.put("price_from", req.getParameter("price_from") != null ? req.getParameter("price_from") : "");
		params.put("price_to", req.getParameter("price_to") != null ? req.getParameter("price_to") : "");
		int pages = req.getParameter("pages") == null ? 1 : Integer.parseInt(req.getParameter("pages"));
		int limit = req.getParameter("limit") == null ? 8 : Integer.parseInt(req.getParameter("limit"));
		List<ProductDTO> productDTOs = productService.searchProduct(params, pages, limit);
		model.addAttribute("productDTOs", productDTOs);
		model.addAttribute("pages", pages);
		model.addAttribute("size", productService.searchProduct(params, 1, 10000).size());
		model.addAttribute("product_name", params.get("product_name"));
		return "homeAdmin";
	}

	@RequestMapping(value = "/searchProduct", method = RequestMethod.GET)
	public String searchProduct(Model model, HttpServletRequest req) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("created_at", req.getParameter("created_at") == null ? "" : req.getParameter("created_at"));
		params.put("updated_at", req.getParameter("updated_at") == null ? "" : req.getParameter("updated_at"));
		params.put("sortPrice", req.getParameter("sortPrice") == null ? "" : req.getParameter("sortPrice"));
		params.put("sortQuantity", req.getParameter("sortQuantity") == null ? "" : req.getParameter("sortQuantity"));
		int pages = req.getParameter("pages") == null ? 1 : Integer.parseInt(req.getParameter("pages"));
		int limit = req.getParameter("limit") == null ? 8 : Integer.parseInt(req.getParameter("limit"));
		List<ProductDTO> productDTOs = productService.searchProductAdmin(params, pages, limit);
		model.addAttribute("productDTOs", productDTOs);
		model.addAttribute("pages", pages);
		model.addAttribute("size", productService.searchProductAdmin(params, 1, 10000).size());
		model.addAttribute("params", params);
		return "homeAdmin";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String addProduct(Model model) {
		model.addAttribute("product", new ProductDTO());
		model.addAttribute("url", "addProduct");
		model.addAttribute("headerPage", "Create Product");
		return "productAdmin";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(Model model, HttpServletRequest req, @RequestParam(name="file") MultipartFile file) {
		String productName = req.getParameter("product_name");
		int price = Integer.parseInt(req.getParameter("unit_price"));
		String description = req.getParameter("description");
		int quantity = Integer.parseInt(req.getParameter("quantity_available"));
		ProductDTO product = new ProductDTO();
		product.setProduct_name(productName);
		product.setUnit_price(price);
		product.setDescription(description);
		String fileName = file.getOriginalFilename();
		product.setImage(file.getOriginalFilename().substring(0, fileName.lastIndexOf('.')));
		product.setQuantity_available(quantity);
		product.setCreated_at(created_at);
		File files  = new File("D:\\java\\QLBH\\src\\main\\webapp\\resources\\images", fileName);
	    try {
			file.transferTo(files);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		productService.addProduct(product);
		return "redirect:/admin/product";
	}

	@RequestMapping(value = "/repairProduct", method = RequestMethod.GET)
	public String repairProduct(Model model, HttpServletRequest req) {
		int productId = Integer.parseInt(req.getParameter("id"));
		ProductDTO product = productService.getProductById(productId);
		model.addAttribute("product", product);
		model.addAttribute("url", "repairProduct");
		model.addAttribute("headerPage", "Repair Product");
		model.addAttribute("display", "none");
		return "productAdmin";
	}

	@RequestMapping(value = "repairProduct", method = RequestMethod.POST)
	public String repairProduct(Model model, HttpServletRequest req, @RequestParam(name="file", required = false) MultipartFile file) {
		int productId = Integer.parseInt(req.getParameter("id"));
		String productName = req.getParameter("product_name");
		int price = Integer.parseInt(req.getParameter("unit_price"));
		String description = req.getParameter("description");
		int quantity = Integer.parseInt(req.getParameter("quantity_available"));
		ProductDTO product = new ProductDTO();
		product.setId(productId);
		product.setProduct_name(productName);
		product.setUnit_price(price);
		product.setDescription(description);
		product.setImage(file.getOriginalFilename());
		product.setQuantity_available(quantity);
		product.setCreated_at(productService.getProductById(productId).getCreated_at());
		product.setUpdated_at(updated_at);
		productService.updateProduct(product);
		return "redirect:/admin/product";
	}
	@RequestMapping(value="/deleteProduct", method = RequestMethod.GET)
	public String deleteProduct(Model model, HttpServletRequest req) {
		int productId = Integer.parseInt(req.getParameter("id"));
		productService.deleteProduct(productId);
		return "redirect:/admin/product";
	}
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//		sdf.setLenient(true);
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
//	}
	@RequestMapping(value="/invoiceAdmin", method = RequestMethod.GET)
	public String invoice(Model model, HttpServletRequest req) {
		int limit = req.getParameter("limit") == null ? 10 : Integer.parseInt(req.getParameter("limit"));
		int page = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
		List<InvoiceDTO> invoiceDTOs = invoiceService.getListInvoice(limit, page);
		model.addAttribute("page", page);
		model.addAttribute("invoiceDTOs", invoiceDTOs);
		model.addAttribute("size", invoiceService.getListInvoice(10000, 1).size());
		return "invoiceAdmin";
	}
	@RequestMapping(value="/searchInvoiceAdmin", method = RequestMethod.GET)
	public String searchInvoice(Model model, HttpServletRequest req) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", req.getParameter("id") == null ? "" : req.getParameter("id"));
		params.put("status", req.getParameter("status") == null ? "" : req.getParameter("status"));
		params.put("day", req.getParameter("day") == null ? "" : req.getParameter("day"));
		params.put("month", req.getParameter("month") == null ? "" : req.getParameter("month"));
		params.put("year", req.getParameter("year") == null ? "" : req.getParameter("year"));
		int limit = req.getParameter("limit") == null ? 10 : Integer.parseInt(req.getParameter("limit"));
		int page = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
		List<InvoiceDTO> invoiceDTOs = invoiceService.searchInvoice(params, page, limit);
		model.addAttribute("page", page);
		model.addAttribute("invoiceDTOs", invoiceDTOs);
		model.addAttribute("size", invoiceService.searchInvoice(params, 1, 10000).size());
		model.addAttribute("params", params);
		return "invoiceAdmin";
	}
	@RequestMapping(value="/invoiceDetails", method = RequestMethod.GET)
	public String invoiceDetails(Model model, HttpServletRequest req) {
		int invoiceId = Integer.parseInt(req.getParameter("id"));
		int userId = Integer.parseInt(req.getParameter("userId"));
		InvoiceDTO invoiceDTO = invoiceService.getInvoiceById(invoiceId);
		UserDTO userDTO = userService.getUserById(userId);
		List<InvoiceItemDTO> invoiceItemDTOs = invoiceItemService.getInvoiceItemByInvoiceId(invoiceId);
		List<Map<String, Object>> informationInvoices = new ArrayList<Map<String, Object>>(); 
		for(InvoiceItemDTO invoiceItemDTO : invoiceItemDTOs) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("invoiceItem", invoiceItemDTO);
			params.put("product", productService.getProductById(invoiceItemDTO.getProduct_id()));
			informationInvoices.add(params);
		}
		model.addAttribute("invoiceDTO", invoiceDTO);
		model.addAttribute("userDTO", userDTO);
		model.addAttribute("informationInvoice", informationInvoices);
		return "invoiceDetailsAdmin";
	}
	@RequestMapping(value="/updateInvoice", method = RequestMethod.POST)
	public @ResponseBody String updateInvoiceAdmin(Model model, HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		String status = req.getParameter("invoiceStatus");
		invoiceService.updateStatusInvoiceById(id, status);
		return null;		
	}
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public String getUser(Model model, HttpServletRequest req) {
		int page = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
		int limit = req.getParameter("limit") == null ? 10 : Integer.parseInt(req.getParameter("limit"));
		List<UserDTO> userDTOs = userService.getListUser(page, limit);
		model.addAttribute("page", page);
		model.addAttribute("userDTOs", userDTOs);
		model.addAttribute("size", userService.getListUser(1, 10000).size());
		return "userAdmin";
	}
	
	@RequestMapping(value="/createUser", method = RequestMethod.GET)
	public String createdUser(Model model) {
		model.addAttribute("display", "none");
		model.addAttribute("url", "createUser");
		return "repairUserAdmin";
	}
	
	@RequestMapping(value="/createUser", method = RequestMethod.POST)
	public String createUser(Model model, HttpServletRequest req) {		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String retypePassword = req.getParameter("retypePassword");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		if(password.equals(retypePassword) && userService.getUserByInforUser(username, phone, email)) {
			UserDTO userDTO = new UserDTO();
			userDTO.setUsername(username);
			userDTO.setPassword(bCryptPasswordEncoder.encode(password));
			userDTO.setFullname(req.getParameter("fullname"));
			userDTO.setAddress(req.getParameter("address"));
			userDTO.setEmail(email);
			userDTO.setPhone(phone);
			userDTO.setCreated_at(created_at);
			userDTO.setUpdated_at(updated_at);
			userDTO.setRole(req.getParameter("enabled"));
			userDTO.setEnabled(Integer.parseInt(req.getParameter("enabled")));
			userService.addUser(userDTO);
			return "redirect:/admin/user";
		} else {
			model.addAttribute("error", "Password does not match or The username is the same");
			return "redirect:/admin/user"; ////xu ly sau
		}	
	}
	
	@RequestMapping(value="/repairUser", method = RequestMethod.GET)
	public String repairUser(Model model, @RequestParam(name = "id")int id) {
		UserDTO userDTO = userService.getUserById(id);
		model.addAttribute("disabled", "disabled");
		model.addAttribute("display", "table-row");
		model.addAttribute("display2", "none");
		model.addAttribute("userDTO", userDTO);
		model.addAttribute("url", "repairUser");
		return "repairUserAdmin";
	}
	@RequestMapping(value="/repairUser", method = RequestMethod.POST)
	public String repairUser(Model model, HttpServletRequest req) {		
		int id = Integer.parseInt(req.getParameter("userId"));
		UserDTO userDTOcurrent = userService.getUserById(id);
		String username = userDTOcurrent.getUsername();
		String password = req.getParameter("password");
		String fullname = req.getParameter("fullname");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		Date created_at = userDTOcurrent.getCreated_at();
		String role = req.getParameter("role");
		int enabled = Integer.parseInt(req.getParameter("enabled"));
		UserDTO userDTO = new UserDTO(id, username, password, fullname, address, phone, email, created_at, updated_at, role, enabled, null, null);
		userService.updateUser(userDTO);
		return "redirect:/admin/user";
	}
	@RequestMapping(value="deleteUser", method = RequestMethod.GET)
	public String deleteUser(Model model, @RequestParam(name = "id") int id) {
		cartService.deleteCartByUserId(id);
		for(InvoiceDTO invoiceDTO : invoiceService.getListInvoiceByUserId(id)) {
			invoiceItemService.deleteInvoiceItemByInvoiceId(invoiceDTO.getId());
		}
		invoiceService.deleteInvoiceByUserId(id);
		userService.deleteUser(id);
		return "redirect:/admin/user";
	}
	
	//chua phan trang
	@RequestMapping(value="/searchUser", method = RequestMethod.GET)
	public String searchUser(Model model, HttpServletRequest req) {
		int page = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
		int limit = req.getParameter("limit") == null ? 10 : Integer.parseInt(req.getParameter("limit"));
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", req.getParameter("username") == null ? "" : req.getParameter("username"));
		params.put("email", req.getParameter("email") == null ? "" : req.getParameter("email"));
		params.put("phone", req.getParameter("phone") == null ? "" : req.getParameter("phone"));
		params.put("created_at", req.getParameter("created_at") == null ? "" : req.getParameter("created_at"));
		List<UserDTO> userDTOs = userService.searchUser(params, page, limit);
		model.addAttribute("userDTOs", userDTOs);
		model.addAttribute("params", params);
		return "userAdmin";
	}
	
	
	@RequestMapping(value="/setting", method = RequestMethod.GET)
	public String setting(Model model, HttpServletRequest req, HttpServletResponse resp) {
		int page = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
		int limit = req.getParameter("limit") == null ? 8 : Integer.parseInt(req.getParameter("limit"));
		List<SettingDTO> settingDTOs = settingService.getListSetting(page, limit);
		model.addAttribute("settingDTOs", settingDTOs);
		model.addAttribute("page", page);
		model.addAttribute("size", settingService.getListSetting(1, 10000).size());
		return "settingAdmin";
	}
	@RequestMapping(value="/createSetting", method = RequestMethod.POST)
	public String setting(Model model, HttpServletRequest req) {
		String settingName = req.getParameter("settingName");
		if(settingService.getSettingByName(settingName) == null) {
			String value = req.getParameter("value");
			SettingDTO settingDTO = new SettingDTO();
			settingDTO.setSetting_name(settingName);
			settingDTO.setValue(value);
			settingDTO.setCreated_at(created_at);
			settingService.addSetting(settingDTO);
		}else {
//			model.addAttribute("error", "Setting exist!!!");
			//xu ly thong bao loi sau
		}
		
		return "redirect:/admin/setting";
	}
	@RequestMapping(value="/deleteSetting", method = RequestMethod.GET)
	public String deleteSetting(HttpServletRequest req) {
		int settingId = Integer.parseInt(req.getParameter("id"));
		settingService.deleteSetting(settingId);
		return "redirect:/admin/setting";
	}
	@RequestMapping(value="/repairSetting", method = RequestMethod.GET)
	public String repairSetting(Model model, HttpServletRequest req) {
		int settingId = Integer.parseInt(req.getParameter("id"));
		model.addAttribute("settingDTO", settingService.getSettingById(settingId));
		return "repairSettingAdmin";
	}
	@RequestMapping(value="/repairSetting", method = RequestMethod.POST)
	public String repairSetting(HttpServletRequest req) {
		int settingId = Integer.parseInt(req.getParameter("id"));
		String settingName = req.getParameter("settingName");
		String value = req.getParameter("value");
		SettingDTO settingDTO = new SettingDTO(settingId, settingName, value, settingService.getSettingById(settingId).getCreated_at(), updated_at);
		settingService.updateSetting(settingDTO);
		return "redirect:/admin/setting";
	}
	@RequestMapping(value="/searchSetting", method = RequestMethod.GET)
	public String searchSetting(Model model, HttpServletRequest req) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("setting_name", req.getParameter("setting_name") == null ? "" : req.getParameter("setting_name"));
		params.put("created_at_from", req.getParameter("created_at_from") == null ? "" : req.getParameter("created_at_from"));
		params.put("created_at_to", req.getParameter("created_at_to") == null ? "" : req.getParameter("created_at_to"));
		params.put("updated_at_from", req.getParameter("updated_at_from") == null ? "" : req.getParameter("updated_at_from"));
		params.put("updated_at_to", req.getParameter("updated_at_to") == null ? "" : req.getParameter("updated_at_to"));
		int page = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
		int limit = req.getParameter("limit") == null ? 8 : Integer.parseInt(req.getParameter("limit"));
		List<SettingDTO> settingDTOs = settingService.searchSetting(params, page, limit);
		model.addAttribute("params", params);
		model.addAttribute("page", page);
		model.addAttribute("settingDTOs", settingDTOs);
		model.addAttribute("size", settingService.searchSetting(params, 1, 10000).size());
		return "settingAdmin";
	}
}
