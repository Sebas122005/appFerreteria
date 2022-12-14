package com.example.app.poo.java.appferreteria.retrofit.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class ResponseLogin implements Parcelable {

    private Boolean rpta;
    private Long id_cuenta;
    private String usuario;
    private String contrasenia;
    private Long id_persona;
    private String nombres;
    private String ape_paterno;
    private String ape_materno;
    private String sexo;
    private String dni;
    private String direccion;
    private String foto;
    private String fecha_nacimiento;
    private String correo;
    private String num_celular;
    private String telefono;
    private Date fecha_modificacion;
    private String mensaje;

    protected ResponseLogin(Parcel in) {
        byte tmpRpta = in.readByte();
        rpta = tmpRpta == 0 ? null : tmpRpta == 1;
        if (in.readByte() == 0) {
            id_cuenta = null;
        } else {
            id_cuenta = in.readLong();
        }
        usuario = in.readString();
        contrasenia = in.readString();
        if (in.readByte() == 0) {
            id_persona = null;
        } else {
            id_persona = in.readLong();
        }
        nombres = in.readString();
        ape_paterno = in.readString();
        ape_materno = in.readString();
        sexo = in.readString();
        dni = in.readString();
        direccion = in.readString();
        foto = in.readString();
        correo = in.readString();
        num_celular = in.readString();
        telefono = in.readString();
        mensaje = in.readString();
    }

    public static final Creator<ResponseLogin> CREATOR = new Creator<ResponseLogin>() {
        @Override
        public ResponseLogin createFromParcel(Parcel in) {
            return new ResponseLogin(in);
        }

        @Override
        public ResponseLogin[] newArray(int size) {
            return new ResponseLogin[size];
        }
    };

    public Boolean getRpta() {
        return rpta;
    }

    public void setRpta(Boolean rpta) {
        this.rpta = rpta;
    }

    public Long getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(Long id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApe_paterno() {
        return ape_paterno;
    }

    public void setApe_paterno(String ape_paterno) {
        this.ape_paterno = ape_paterno;
    }

    public String getApe_materno() {
        return ape_materno;
    }

    public void setApe_materno(String ape_materno) {
        this.ape_materno = ape_materno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNum_celular() {
        return num_celular;
    }

    public void setNum_celular(String num_celular) {
        this.num_celular = num_celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (rpta == null ? 0 : rpta ? 1 : 2));
        if (id_cuenta == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(id_cuenta);
        }
        parcel.writeString(usuario);
        parcel.writeString(contrasenia);
        if (id_persona == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(id_persona);
        }
        parcel.writeString(nombres);
        parcel.writeString(ape_paterno);
        parcel.writeString(ape_materno);
        parcel.writeString(sexo);
        parcel.writeString(dni);
        parcel.writeString(direccion);
        parcel.writeString(foto);
        parcel.writeString(correo);
        parcel.writeString(num_celular);
        parcel.writeString(telefono);
        parcel.writeString(mensaje);
    }
}
