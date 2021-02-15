 package com.example.sueldo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

 public class MainActivity extends AppCompatActivity {

    //Componentes que se van a utilizar
    Calendar myCalendar = Calendar.getInstance();
    Calendar myCalendar2 = Calendar.getInstance();
    private EditText etNombres;
    private EditText etApellidos;
    private EditText etFechaNacimiento;
    private EditText etFechaIngreso;
    private EditText etSueldo;
    private EditText etHorasExtra;
    private Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Puente vista
        etNombres = (EditText) findViewById(R.id.etNombres);
        etApellidos = (EditText) findViewById(R.id.etApellidos);
        etFechaNacimiento = (EditText) findViewById(R.id.etFechaNacimiento);
        etFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(MainActivity.this,datNac, myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        etFechaIngreso = (EditText) findViewById(R.id.etFechaIngreso);
        etFechaIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(MainActivity.this,datIng, myCalendar2.get(Calendar.YEAR),
                        myCalendar2.get(Calendar.MONTH),myCalendar2.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        etSueldo = (EditText) findViewById(R.id.etSueldo);
        etHorasExtra = (EditText) findViewById(R.id.etHorasExtra);
    }
     DatePickerDialog.OnDateSetListener datNac = new
             DatePickerDialog.OnDateSetListener() {
                 @Override
                 public void onDateSet(DatePicker view, int year, int mes, int dia) {
                     myCalendar.set(Calendar.YEAR, year);
                     myCalendar.set(Calendar.MONTH,mes);
                     myCalendar.set(Calendar.DAY_OF_MONTH,dia);
                     actualizarCampos();
                 }
             };
     DatePickerDialog.OnDateSetListener datIng = new
             DatePickerDialog.OnDateSetListener() {
                 @Override
                 public void onDateSet(DatePicker view, int year, int mes, int dia) {
                     myCalendar2.set(Calendar.YEAR, year);
                     myCalendar2.set(Calendar.MONTH,mes);
                     myCalendar2.set(Calendar.DAY_OF_MONTH,dia);
                     actualizarCampos();
                 }
             };
    public void resultado(View view){
        String nombre = etNombres.getText().toString();
        String apellido = etApellidos.getText().toString();
        String fechaNacimiento = etFechaNacimiento.getText().toString();
        String fechaIngreso = etFechaIngreso.getText().toString();
        int sueldo = Integer.parseInt(etSueldo.getText().toString());
        int horasExtra = Integer.parseInt(etHorasExtra.getText().toString());

        Empleado empleado = new Empleado(nombre, apellido, fechaNacimiento, fechaIngreso, sueldo, horasExtra);
        Intent intent = new Intent(this, Resultado.class);
        intent.putExtra("empleado", empleado);
        startActivity(intent);
    }
     private void actualizarCampos() {
         String formatoDeFecha = "MM/dd/yy";
         SimpleDateFormat formato = new SimpleDateFormat(formatoDeFecha, Locale.US);
         etFechaNacimiento.setText(formato.format(myCalendar.getTime()));
         etFechaIngreso.setText((formato.format(myCalendar2.getTime())));
     }
 }