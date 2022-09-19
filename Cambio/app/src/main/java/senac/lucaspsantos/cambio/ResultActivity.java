package senac.lucaspsantos.cambio;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView dolar = findViewById(R.id.dollarvalue);
        TextView euro = findViewById(R.id.eurovalue);
        TextView libra = findViewById(R.id.sterlingvalue);

        String aux = getIntent().getExtras().getString(MainActivity.EXTRAKEY);
        double value = aux.isEmpty() ? 0 : Double.parseDouble(aux);
        dolar.setText(String.valueOf(value*MainActivity.DOLLAR));
        euro.setText(String.valueOf(value*MainActivity.EURO));
        libra.setText(String.valueOf(value*MainActivity.STERLING));

        findViewById(R.id.backbutton).setOnClickListener(view -> finish());
    }
}