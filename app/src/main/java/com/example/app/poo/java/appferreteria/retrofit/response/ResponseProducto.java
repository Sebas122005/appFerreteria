package com.example.app.poo.java.appferreteria.retrofit.response;

public class ResponseProducto {

    private Integer id_producto;
    private String nom_producto;
    private String descripcion;
    private Integer imagen;
    private Integer id_categoria;
    private Integer stock;
    private Double precio;
    private Boolean estado;

    public ResponseProducto(Integer id_producto, String nom_producto, String descripcion, Integer imagen, Integer id_categoria, Integer stock, Double precio, Boolean estado) {
        this.id_producto = id_producto;
        this.nom_producto = nom_producto;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.id_categoria = id_categoria;
        this.stock = stock;
        this.precio = precio;
        this.estado = estado;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getImagen() {
        return imagen;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
