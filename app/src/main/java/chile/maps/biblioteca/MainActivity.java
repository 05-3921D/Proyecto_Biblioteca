package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declarar
    private EditText et1, et2;
    private ProgressBar pb;
    private Button btn;
    private TextView tvpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Byid
        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        btn = (Button) findViewById(R.id.btn);
        pb = (ProgressBar)findViewById(R.id.pb);
        tvpass = (TextView)findViewById(R.id.tvpass);


        //Invisible pb y Rest clave
        pb.setVisibility(View.INVISIBLE);
        tvpass.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Task().execute(et1.getText().toString());
            }
        });
    }


    class Task extends AsyncTask<String, Void, String>
    {

        // configura mi tarea inicial
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setVisibility(View.VISIBLE); // Hago visible mi progress.
            btn.setEnabled(false);
        }

        // se ejecuta la tarea o proceso complejo.
        @Override
        protected String doInBackground(String... strings) {

            try
            {
                Thread.sleep(5000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }

        // es lo que se va a realizar despues de mi tarea pesada.
        @Override
        protected void onPostExecute(String s) {

            String user = et1.getText().toString();
            String pass = et2.getText().toString();

            if (et1.getText().toString().equals("User1") || et1.getText().toString().equals("User2")
                    && et2.getText().toString().equals("123")) {
                pb.setVisibility(View.INVISIBLE);
                Toast.makeText(getBaseContext(), "Ha ingresado correctamente",
                        Toast.LENGTH_LONG).show();

                //Vaya al home
                Intent i = new Intent(getBaseContext(), Home_act.class);
                i.putExtra("Usuario", user);
                i.putExtra("clave", pass);
                startActivity(i);
            }
            else {
                Toast.makeText(getBaseContext(), "Clave NO Valida",
                        Toast.LENGTH_LONG).show();
                pb.setVisibility(View.INVISIBLE);
                tvpass.setVisibility((View.VISIBLE)); //Aparezca
                btn.setEnabled(true);
            }
        }
    }



    public void Home(View v)
    {
        Intent i = new Intent(this, Home_act.class);
        startActivity(i);
    }

    public void Location(View v)
    {
        Intent i = new Intent(this, Location_act.class);
        startActivity(i);
    }
}