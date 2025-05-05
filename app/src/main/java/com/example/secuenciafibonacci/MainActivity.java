package com.example.secuenciafibonacci;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


//import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView fibonacciTextView;
    private int currentIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar componentes
        fibonacciTextView = findViewById(R.id.fibonacciTextView);
        Button advanceButton = findViewById(R.id.advanceButton);
        Button backButton = findViewById(R.id.backButton);

        // Establecer valor inicial en el TextView
        fibonacciTextView.setText(String.valueOf(calculateFibonacci(1)));

        // Listener para el botón de avance
        advanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                updateFibonacciText();
            }
        });

        // Listener para el botón de retroceso
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex > 1) {
                    currentIndex--;
                }
                updateFibonacciText();
            }
        });
    }

    //Aquí está el método para calcular la secuencia Fibonacci con ciclo for.
    private long calculateFibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        long first = 1, second = 1, result = 1;
        for (int i = 3; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    // Actualizar el TextView con el valor actual de la secuencia de Fibonacci
    private void updateFibonacciText() {
        long fibonacciValue = calculateFibonacci(currentIndex);
        fibonacciTextView.setText(String.valueOf(fibonacciValue));
    }

}