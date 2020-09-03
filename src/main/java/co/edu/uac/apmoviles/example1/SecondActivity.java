package co.edu.uac.apmoviles.example1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.os.*;
import android.text.*;
import android.view.*;
import android.widget.*;


import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView texto;
    EditText p1, p2;
    Button mayor, vocal, invertir, longitud, ocultar;
    CheckBox edtmaymin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i = getIntent();
        String user = i.getStringExtra("Usuario");
        texto = findViewById(R.id.texto);
        texto.setText(texto.getText().toString() + " " + user);
        p1 = findViewById(R.id.edtp1);
        p2 = findViewById(R.id.edtp2);
        mayor = findViewById(R.id.btnmayor);
        vocal = findViewById(R.id.btnvocales);
        invertir = findViewById(R.id.btninvertir);
        longitud = findViewById(R.id.btnlongitud);
        ocultar = findViewById(R.id.ocultar);
        edtmaymin = findViewById(R.id.edtmaymin);

        vocal.setOnClickListener(this);
        longitud.setOnClickListener(this);
        invertir.setOnClickListener(this);
        ocultar.setOnClickListener(this);
        mayor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(p1.getText().toString()) || TextUtils.isEmpty(p2.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Datos invalidos",Toast.LENGTH_LONG).show();
               }
                else{
                    if (p1.getText().toString().compareToIgnoreCase(p2.getText().toString())>0){
                        Toast.makeText(getApplicationContext(),"Palabra 1 es mayor que P2", Toast.LENGTH_LONG).show();
                    }
                    else{
                        if (p1.getText().toString().compareToIgnoreCase(p2.getText().toString())<00){
                            Toast.makeText(getApplicationContext(),"Palabra 1 es menor que P2", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Las dos palabras son iguales", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });



    }



    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnlongitud: int l1 = p1.getText().toString().length();
                                  int l2 = p2.getText().toString().length();
                Toast.makeText(getApplicationContext(),"L1=" + l1 + " L2=" + l2, Toast.LENGTH_LONG).show();
                 break;
            case R.id.btninvertir:
                p1.setText(revertir(p1.getText().toString()));
                p2.setText(revertir(p2.getText().toString()));
                 break;

            case R.id.btnvocales:
                p1.setText(quitarVocales(p1.getText().toString()));
                p2.setText(quitarVocales(p2.getText().toString()));
                break;
            case R.id.ocultar:
                if (vocal.getVisibility() == View.INVISIBLE){
                    vocal.setVisibility(View.VISIBLE);
                    longitud.setVisibility(View.VISIBLE);
                    invertir.setVisibility(View.VISIBLE);
                    mayor.setVisibility(View.VISIBLE);
                    edtmaymin.setVisibility(View.VISIBLE);
                }else{
                    vocal.setVisibility(View.INVISIBLE);
                    longitud.setVisibility(View.INVISIBLE);
                    invertir.setVisibility(View.INVISIBLE);
                    mayor.setVisibility(View.INVISIBLE);
                    edtmaymin.setVisibility(View.INVISIBLE);
                }
                break;
        }
    }


    public String changeString(String x, boolean y){
        String new_string = "";
        if (y){
            new_string = x.toLowerCase();
        }else{
            new_string = x.toUpperCase();
        }
        return new_string;
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.edtmaymin:
                if (checked) {
                    p1.setText(this.changeString(p1.getText().toString(),false));
                    p2.setText(this.changeString(p2.getText().toString(),false));
                }
            else {
                    p1.setText(this.changeString(p1.getText().toString(),true));
                    p2.setText(this.changeString(p2.getText().toString(),true));
                }
            break;
        }
    }

    public String quitarVocales(String x){
        return x.replace("a", "").replace("e", "").replace("i", "").replace("o", "").replace("u", "");
    }

    public String revertir(String x){
        String _x = "";
        for (int y=x.length()-1; y>=0;y--){
            _x += x.charAt(y);
        }
        return _x;
    }

}
