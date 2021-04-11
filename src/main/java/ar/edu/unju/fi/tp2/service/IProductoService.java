package ar.edu.unju.fi.tp2.service;

import ar.edu.unju.fi.tp2.model.Producto;



public interface IProductoService {
    
    public void agregarProducto(Producto producto);
    public Producto obtenerUltimoProducto();
}
