package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Libros_act extends AppCompatActivity {

    private Spinner spn;
    private TextView tv;
    private EditText et1, et2;
    private String[] precios = new String[]{"5000", "12000", "25000", "18000", "40000"}; //Agrego 2 precios a la lista

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros_act);

        spn = (Spinner)findViewById(R.id.spn);
        tv = (TextView)findViewById(R.id.result);
        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);

        Bundle dat = getIntent().getExtras();
        String[] lista = dat.getStringArray("libros");

        ArrayAdapter adapt = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, lista);

        spn.setAdapter(adapt);

    }

    public void Calcular(View v) //Se agrega Caballo de toye y Narracion Extraorinaria
    {
        if(spn.getSelectedItem().equals("Farenheit"))
        {
            String precio = precios[0];
            int stock = Integer.parseInt(et1.getText().toString());
            int costo = Integer.parseInt(et2.getText().toString());
            int precioLibro = Integer.parseInt(precio);
            int resultado = precioLibro * stock + costo;

            tv.setText("Stock disponible: "+ stock + "\n"
                     + "El costo total es: "+ resultado);
        }

        if(spn.getSelectedItem().equals("Revival"))
        {
            String precioRevival = precios[1];

            int stock = Integer.parseInt(et1.getText().toString());
            int costo = Integer.parseInt(et2.getText().toString());
            int precioLibro = Integer.parseInt(precioRevival);

            int resultado = precioLibro*stock+costo;

            tv.setText("Stock disponible: " +stock+ "\n"
            +"El costo total es: "+ resultado);
        }

        if(spn.getSelectedItem().equals("Tesla"))
        {

            String precioTesla = precios[2];

            int stock = Integer.parseInt(et1.getText().toString());
            int costo = Integer.parseInt(et2.getText().toString());
            int precioLibro = Integer.parseInt(precioTesla);

            int resultado = precioLibro*stock+costo;

            tv.setText("Stock disponible: " +stock+ "\n"
                    +"El costo total es: "+ resultado);
        }

        if(spn.getSelectedItem().equals("Caballo de Troya"))
        {

            String precioTesla = precios[3];

            int stock = Integer.parseInt(et1.getText().toString());
            int costo = Integer.parseInt(et2.getText().toString());
            int precioLibro = Integer.parseInt(precioTesla);

            int resultado = precioLibro*stock+costo;

            tv.setText("Stock disponible: " +stock+ "\n"
                    +"El costo total es: "+ resultado);
        }

        if(spn.getSelectedItem().equals("Narracion Extraorinaria"))
        {

            String precioTesla = precios[4];

            int stock = Integer.parseInt(et1.getText().toString());
            int costo = Integer.parseInt(et2.getText().toString());
            int precioLibro = Integer.parseInt(precioTesla);

            int resultado = precioLibro*stock+costo;

            tv.setText("Stock disponible: " +stock+ "\n"
                    +"El costo total es: "+ resultado);
        }
    }

}


