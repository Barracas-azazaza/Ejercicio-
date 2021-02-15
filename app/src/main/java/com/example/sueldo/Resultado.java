package com.example.sueldo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Resultado extends AppCompatActivity {
    private TextView Nombres;
    private TextView Apellidos;
    private TextView FechaNacimiento;
    private TextView FechaIngreso;
    private TextView Sueldo;
    private TextView HorasExtra;
    private TextView SueldoTotal;
    private TextView Edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        //Casteo
        Nombres = (TextView) findViewById(R.id.tvNombres);
        Apellidos = (TextView) findViewById(R.id.tvApellidos);
        FechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        FechaIngreso = (TextView) findViewById(R.id.tvFechaIngreso);
        Sueldo = (TextView) findViewById(R.id.tvSueldo);
        HorasExtra = (TextView) findViewById(R.id.tvHorasExtra);
        SueldoTotal = (TextView) findViewById(R.id.tvSueldoTotal);
        Impresion_Pantalla();
    }
    public void Impresion_Pantalla(){
        Empleado empleado = getIntent().getParcelableExtra("empleado");
        Nombres.setText(""+empleado.getNombre());
        Apellidos.setText(""+empleado.getApellido());
        FechaNacimiento.setText(""+empleado.getFechaNacimiento());
        FechaIngreso.setText(""+empleado.getFechaIngreso());
        Sueldo.setText(""+empleado.getSueldo());
        HorasExtra.setText(""+empleado.getHoras());
        SueldoTotal.setText(""+empleado.Sueldo_Total());
    }
}