package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.EditText;


/**
 * Created by pushpak on 19/5/17.
 */

public class MyView extends AppCompatEditText {

    private Paint paint;

    public MyView(Context context) {
        super(context);
        initPaint();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void initPaint() {
        paint = new Paint();
        paint.setStrokeWidth(3.2f);
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawCircle(100,100,100,paint);
        setGravity(Gravity.TOP | Gravity.LEFT);



        for (int i = 10; i < getHeight(); i += 90) {
            canvas.drawLine(10, i, getWidth(), i, paint);
            paint.setColor(Color.CYAN);
        }

        for (int i = 10; i < getWidth(); i += 90) {
            canvas.drawLine(10, i, getWidth(), i, paint);
            paint.setColor(Color.CYAN);
        }
        for (int i = 10; i < getWidth(); i += 90) {
            canvas.drawLine(i, 10, i, getHeight(), paint);
            paint.setColor(Color.MAGENTA);

        }
    }
}

