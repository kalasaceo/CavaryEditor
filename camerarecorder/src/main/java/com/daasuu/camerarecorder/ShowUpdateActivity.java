package com.daasuu.camerarecorder;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.view.View;
import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;
public class ShowUpdateActivity extends AppCompatActivity {
    private Boolean canUpdate=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_updatezero);
        final Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_heart);
        final Shape.DrawableShape drawableShape = new Shape.DrawableShape(drawable, true);
        final KonfettiView konfettiView = findViewById(R.id.konfettiView);
                konfettiView.build()
                        .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                        .setDirection(0.0, 359.0)
                        .setSpeed(1f, 5f)
                        .setFadeOutEnabled(true)
                        .setTimeToLive(2000L)
                        .addShapes(Shape.Square.INSTANCE, Shape.Circle.INSTANCE, drawableShape)
                        .addSizes(new Size(12, 5f))
                        .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                        .streamFor(300, 5000L);
        findViewById(R.id.a11).setOnClickListener(v -> {
            canUpdate=true;
            finish();
        });
        findViewById(R.id.a22).setOnClickListener(v -> {
            canUpdate=false;
            finish();
        });
    }
    @Override
    public void finish() {
        String s="false";
        Intent data = new Intent();
        if(canUpdate==true)
        {
            s="true";
        }
        data.putExtra("UpdateStatus", s);
        this.setResult(RESULT_OK, data);
        super.finish();
    }
}