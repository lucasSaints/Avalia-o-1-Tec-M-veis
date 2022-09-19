package senac.lucaspsantos.analisadordetriangulo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private EditText ladoA, ladoB, ladoC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.resultLabel);
        ladoA = findViewById(R.id.ladoAtext);
        ladoA.setOnFocusChangeListener((view, b) -> {
            if(!b) updateResultText();
        });
        ladoB = findViewById(R.id.ladoBtext);
        ladoB.setOnFocusChangeListener((view, b) -> {
            if(!b) updateResultText();
        });
        ladoC = findViewById(R.id.ladoCtext);
        ladoC.setOnFocusChangeListener((view, b) -> {
            if(!b) updateResultText();
        });
    }

    private void updateResultText() {
        if(ladoA.getText().length()>0 && ladoB.getText().length()>0
                && ladoC.getText().length()>0) {
            float a = Float.parseFloat(ladoA.getText().toString()),
                    b = Float.parseFloat(ladoB.getText().toString()),
                    c = Float.parseFloat(ladoC.getText().toString());
            if (a == b && b == c) result.setText("equilátero");
            else if (a == b || b == c || a == c) result.setText("isósceles");
            else result.setText("escaleno");
        } else result.setText("");
    }
}