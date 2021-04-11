package ar.edu.unju.fi.tp2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import ar.edu.unju.fi.tp2.model.Producto;
import ar.edu.unju.fi.tp2.service.IProductoService;

@Controller
public class ProductoController {
    
    @Autowired
    private IProductoService productoService;

    @Autowired
    private Producto producto;

    @GetMapping("/producto")
    public String getProducto(Model model){
        model.addAttribute(producto);
        return "nuevo";
    }

    /**
     * Método que permite agregar un producto a la lista 
     * @param producto es un objeto tipo Producto
     * @return String que es el nombre de la vista
     */
    @PostMapping("/producto/guardar")
    public String agregarProducto(@ModelAttribute("producto") Producto producto){
        productoService.agregarProducto(producto);
        return "resultado";
    }

    /**
     * Método que obtiene el ultimo producto de la lista y lo manda a la vista 
     * @param model que es el objeto que se enviara a la vista
     * @return String que es el nombre de la vista 
     */
    @GetMapping("/producto/ultimo")
    public String mostrarUltimoProducto(Model model){
        Producto producto = productoService.obtenerUltimoProducto();
        model.addAttribute(producto);

        return "ultimoProducto";


    }
}
