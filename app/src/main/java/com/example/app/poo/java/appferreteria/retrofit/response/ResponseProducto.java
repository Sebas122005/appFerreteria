package com.example.app.poo.java.appferreteria.retrofit.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class ResponseProducto implements Parcelable {



    private long id_producto;
    private String nom_producto;
    private String descripcion;
    private String imagen;
    private Integer id_categoria;
    private Integer stock;
    private Double precio;
    private Date fecha_modificacion;
    private Boolean estado;


    protected ResponseProducto(Parcel in) {
        id_producto = in.readLong();
        nom_producto = in.readString();
        descripcion = in.readString();
        imagen = in.readString();
        if (in.readByte() == 0) {
            id_categoria = null;
        } else {
            id_categoria = in.readInt();
        }
        if (in.readByte() == 0) {
            stock = null;
        } else {
            stock = in.readInt();
        }
        if (in.readByte() == 0) {
            precio = null;
        } else {
            precio = in.readDouble();
        }
        byte tmpEstado = in.readByte();
        estado = tmpEstado == 0 ? null : tmpEstado == 1;
    }

    public static final Creator<ResponseProducto> CREATOR = new Creator<ResponseProducto>() {
        @Override
        public ResponseProducto createFromParcel(Parcel in) {
            return new ResponseProducto(in);
        }

        @Override
        public ResponseProducto[] newArray(int size) {
            return new ResponseProducto[size];
        }
    };

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
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

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id_producto);
        parcel.writeString(nom_producto);
        parcel.writeString(descripcion);
        parcel.writeString(imagen);
        if (id_categoria == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(id_categoria);
        }
        if (stock == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(stock);
        }
        if (precio == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(precio);
        }
        parcel.writeByte((byte) (estado == null ? 0 : estado ? 1 : 2));
    }

    public ResponseProducto(long id_producto, String nom_producto, String descripcion, String imagen, Integer id_categoria, Integer stock, Double precio, Date fecha_modificacion, Boolean estado) {
        this.id_producto = id_producto;
        this.nom_producto = nom_producto;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.id_categoria = id_categoria;
        this.stock = stock;
        this.precio = precio;
        this.fecha_modificacion = fecha_modificacion;
        this.estado = estado;
    }
}
