package server.tryout.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.tryout.jpa.Repjpa;
import server.tryout.model.Product;

@Service
public class HouseService {
    @Autowired
    Repjpa r;

    public void setThe(Product p) {
        r.save(p);
    }

    public List<Product> data() {
        return r.findAll(); // Return all products
    }

    public Optional<Product> particulardata(Integer id) {
        return r.findById(id); // Fetch product by ID
    }

    public void delet(Integer id) {
        r.deleteById(id); // Delete product by ID
    }
}
