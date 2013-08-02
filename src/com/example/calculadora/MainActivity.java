package com.example.calculadora;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import android.view.*;
import java.*;
import java.math.RoundingMode;

public class MainActivity extends Activity {


public Button boton;
public EditText mostrar;
public View.OnClickListener Clic;
public View.OnClickListener Igual;
public View.OnClickListener Borra;
public View.OnClickListener Elimina;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	
	Clic = new View.OnClickListener() {
	    public void onClick(View v) {
	        // Do something in response to button click
	    	
	    	String escribir = "";
	    	switch (v.getId())
	    	{
	    		case R.id.Btn0 :
	    			escribir= "0";
	    			break;
	    		case R.id.Btn1 :
	    			escribir= "1";
	    			break;
	    		case R.id.Btn2 :
	    			escribir= "2";
	    			break;
	    		case R.id.Btn3 :
	    			escribir= "3";
	    			break;
	    		case R.id.Btn4 :
	    			escribir= "4";
	    			break;
	    		case R.id.Btn5 :
	    			escribir= "5";
	    			break;
	    		case R.id.Btn6 :
	    			escribir= "6";
	    			break;
	    		case R.id.Btn7 :
	    			escribir= "7";
	    			break;
	    		case R.id.Btn8 :
	    			escribir= "8";
	    			break;
	    		case R.id.Btn9 :
	    			escribir= "9";
	    			break;
	    		case R.id.BtnSuma :
	    			escribir= " + ";
	    			break;
	    		case R.id.BtnResta :
	    			escribir= " - ";
	    			break;
	    		case R.id.BtnMultiplica :
	    			escribir= " x ";
	    			break;
	    		case R.id.BtnDivide :
	    			escribir= " / ";
	    			break;
	    	}	
	    	EditText editText = (EditText) findViewById(R.id.Resultado);
	    	String[] Arreglo =(editText.getText().toString().split(" "));
	    	if (EsOperador(Arreglo[Arreglo.length-1]) && EsOperador(escribir.trim()))
	    	{
	    		return;
	    	}
	    	editText.setText(editText.getText()+ escribir);
	    }
	};
	
	Igual=  new View.OnClickListener() {
	    public void onClick(View v) {
			
	    	EditText editText = (EditText) findViewById(R.id.Resultado);
	    	editText.setText(SacaCuenta(editText.getText().toString()));
	    	  	
		}
	};
	Borra=  new View.OnClickListener() {
	    public void onClick(View v) {
	    	EditText editText = (EditText) findViewById(R.id.Resultado);
	    	if (editText.getText().length()>0)
	    	if(editText.getText().toString().toCharArray()[editText.getText().length()-1]== ' ')
	    		editText.setText(editText.getText().toString().substring(0, editText.getText().length()-3));
	    	else
	    		editText.setText(editText.getText().toString().substring(0, editText.getText().length()-1));
	    		
	    }
	};
	Elimina	=  new View.OnClickListener() {
	    public void onClick(View v) {
	    	EditText editText = (EditText) findViewById(R.id.Resultado);
	    	editText.getText().clear();
	    }
	};
	
	
	 ((Button)findViewById(R.id.Btn0)).setOnClickListener(Clic);
	 ((Button)findViewById(R.id.Btn1)).setOnClickListener(Clic);
	 ((Button)findViewById(R.id.Btn2)).setOnClickListener(Clic);
	 ((Button)findViewById(R.id.Btn3)).setOnClickListener(Clic);
	 ((Button)findViewById(R.id.Btn4)).setOnClickListener(Clic);
	 ((Button)findViewById(R.id.Btn5)).setOnClickListener(Clic);
	 ((Button)findViewById(R.id.Btn6)).setOnClickListener(Clic);
	 ((Button)findViewById(R.id.Btn7)).setOnClickListener(Clic);
	 ((Button)findViewById(R.id.Btn8)).setOnClickListener(Clic);
	 ((Button)findViewById(R.id.Btn9)).setOnClickListener(Clic);
	 ((Button)findViewById(R.id.BtnSuma)).setOnClickListener(Clic);
	 ((Button)findViewById(R.id.BtnResta)).setOnClickListener(Clic);
	 ((Button)findViewById(R.id.BtnMultiplica)).setOnClickListener(Clic);
	 ((Button)findViewById(R.id.BtnDivide)).setOnClickListener(Clic);
	 ((Button)findViewById(R.id.BtnIgual)).setOnClickListener(Igual);
	 ((Button)findViewById(R.id.BtnBorrar)).setOnClickListener(Borra);
	 ((Button)findViewById(R.id.BtnElimina)).setOnClickListener(Elimina);

	}
	public boolean EsOperador(String dato)
	{
		if  ((dato.contains("x")|| dato.contains("/") || dato.contains("+") || dato.contains("-")))
			return true; 
	
		return false;
	}

	public String SacaCuenta(String valor)
	{
		double Acumulador=0;
		String Operador=  "";
		String [] arreglo;
		arreglo=valor.split(" ");
		
		for (String dato : arreglo) {
			if  (!EsOperador(dato)) 
			{
				if (Operador== "")
					Acumulador= Double.valueOf(dato);
				else
					
				{
					if (Operador.contains("+"))
						Acumulador=  Double.valueOf(dato) + Acumulador;
					if (Operador.contains("-"))
						Acumulador=Acumulador- Double.valueOf(dato) ;
					if (Operador.contains("x"))
						Acumulador=  Double.valueOf(dato) * Acumulador;
					if (Operador.contains("/"))
						Acumulador= Acumulador /  Double.valueOf(dato);
					
				}
				continue;
			}
			Operador= dato;
			
		}
		
		return Double.toString(Acumulador);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
