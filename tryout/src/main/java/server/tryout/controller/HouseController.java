package server.tryout.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import server.tryout.model.Product;
import server.tryout.service.HouseService;

@Controller
public class HouseController {
    @Autowired
    HouseService hs; // Service Name And Object

    @GetMapping("/")
    public String get() {
        return "index"; // HTML INDEX page
    }

    @PostMapping("/GG") // It is Action from HTML
    @Transactional // To manage Database
    public String get1(Product p) {
        hs.setThe(p); // Save product using service
        return "result"; // Redirect to result page
    }

    @GetMapping("/datas")
    public String get2(Model m) {
        m.addAttribute("info", hs.data()); // Add product list to model
        return "information"; // Show information page
    }

    @GetMapping("/selectivedata/{id}") // Fetch single product data
    public String get3(@PathVariable Integer id, Model m) {
        Optional<Product> p = hs.particulardata(id);
        if (p.isPresent()) {
            m.addAttribute("info", p.get());
            return "information";
        } else {
            return "nodata";
        }
    }

 // Show edit form
    @GetMapping("/editProduct/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Optional<Product> product = hs.particulardata(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "update"; // Make sure update.html exists
        } else {
            return "nodata"; // Redirect if product is not found
        }
    }

    // Handle form submission for updating product
    @PostMapping("/updateProduct")
    public String updateProduct(Product product) {
        hs.setThe(product); // Save updated product details
        return "redirect:/datas"; // Redirect to product list
    }


    @RequestMapping("/deleteProduct/{id}") // Fix method name
    public String deleteProduct(@PathVariable("id") int id) {
        hs.delet(id); // Call the service correctly
        return "redirect:/datas"; // Redirect to product list
    }
}
