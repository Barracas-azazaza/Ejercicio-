package com.example.sueldo;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Empleado implements Parcelable {
    String nombre;
    String apellido;
    String fechaNacimiento;
    String fechaIngreso;
    int sueldo;
    int horas;
    public Empleado(String nombre, String apellido, String fechaNacimiento, String fechaIngreso, int sueldo, int horas){
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.sueldo = sueldo;
        this.horas = horas;
    }

    protected Empleado(Parcel in) {
        nombre = in.readString();
        apellido = in.readString();
        fechaNacimiento = in.readString();
        fechaIngreso = in.readString();
        sueldo = in.readInt();
        horas = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(apellido);
        dest.writeString(fechaNacimiento);
        dest.writeString(fechaIngreso);
        dest.writeInt(sueldo);
        dest.writeInt(horas);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Empleado> CREATOR = new Creator<Empleado>() {
        @Override
        public Empleado createFromParcel(Parcel in) {
            return new Empleado(in);
        }

        @Override
        public Empleado[] newArray(int size) {
            return new Empleado[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public double Sueldo_Total(){
        double resultado = 0;
            resultado = (double) (getSueldo()*0.02)*getHoras()+getSueldo();
        return resultado;
    }
    /*
    public int Edad_Total(){
        int resultado = 0;
            resultado = (obtenerFechaActual(""+Calendar.getInstance())-(getFechaNacimiento());
            return resultado;
    }*/

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    /*
    public static String obtenerFechaConFormato(String formato, String zonaHoraria) {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat(formato);
        sdf.setTimeZone(TimeZone.getTimeZone(zonaHoraria));
        return sdf.format(date);
    }
    public static String obtenerFechaActual(Calendar zonaHoraria) {
        String formato = "MM-dd-yy";
        return obtenerFechaConFormato(formato, zonaHoraria);
    }

     */
}
