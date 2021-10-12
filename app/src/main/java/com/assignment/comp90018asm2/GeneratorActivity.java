package com.assignment.comp90018asm2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class GeneratorActivity extends AppCompatActivity {

    private TextView generatorTV;
    private ImageView generatorIV;
    private Button generateCodeBtn;
    private Bitmap bitmap;
    private QRGEncoder qrgEncoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);
        generatorTV = findViewById(R.id.tvGenerator);
        generatorIV = findViewById(R.id.ivGenerator);
        generateCodeBtn = findViewById(R.id.GenerateCodeBtn);
        generateCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = getMyID();
                if (data.isEmpty()) {
                    Toast.makeText(GeneratorActivity.this,
                            "Error retrieving user ID",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);

                    Display display = manager.getDefaultDisplay();

                    Point point = new Point();
                    display.getSize(point);

                    int width = point.x;
                    int height = point.y;

                    int dimen = width < height ? width : height;
                    dimen = dimen * 3 / 4;

                    qrgEncoder = new QRGEncoder(data, null, QRGContents.Type.TEXT, dimen);
                    try {
                        generatorTV.setText("");
                        bitmap = qrgEncoder.encodeAsBitmap();
                        generatorIV.setImageBitmap(bitmap);
                    } catch (WriterException e) {
                        Log.e("GeneratorActivity", e.toString());
                    }
                }
            }
        });
    }

    private String getMyID() {
        return "MyID12345";
    }
}