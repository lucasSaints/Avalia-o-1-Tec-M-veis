package senac.lucaspsantos.advinheonumero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView label;
    private EditText campo;
    private int num;
    private Button guessbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = (int) Math.round(Math.random()*99)+1;
        label = findViewById(R.id.texto);
        campo = findViewById(R.id.editTextNumber);
        guessbtn = findViewById(R.id.GuessButton);
        guessbtn.setOnClickListener(view -> {
            try{
                int input = Integer.parseInt(campo.getText().toString());
                if(input == num) {
                    campo.setEnabled(false);
                    guessbtn.setEnabled(false);
                    label.setText("Correto!");
                }else if(input > num-5 && input < num+5) label.setText("Mais Perto");
                else label.setText("Mais Longe");
            }catch (Exception e){ System.out.println(e.getMessage()); }
        });
        findViewById(R.id.ReloadButton).setOnClickListener(view -> {
            finish();
            startActivity(getIntent());
        });
    }
}