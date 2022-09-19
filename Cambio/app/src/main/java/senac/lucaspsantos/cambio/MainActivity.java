package senac.lucaspsantos.cambio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final float DOLLAR=5.2456f, EURO=5.2548f, STERLING=5.9933f;
    public static final String EXTRAKEY = "CAMPOKEY";

    public EditText campo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campo = findViewById(R.id.edittextnum);
        campo.setOnFocusChangeListener((view, b) -> {
            if(!b){
                Intent i = new Intent(MainActivity.this, ResultActivity.class);
                i.putExtra(EXTRAKEY, campo.getText());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        campo.setText("");
    }
}