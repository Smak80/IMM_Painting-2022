package ru.smak.imm_painting_2022.ui.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class BoxPainter extends View {

    private Paint paintBg;
    private Paint paintBox;

    public BoxPainter(Context context){
        super(context);
        init();
    }

    public BoxPainter(Context context, AttributeSet attr){
        super(context, attr);
        init();
    }

    private void init(){
        paintBg = new Paint();
        paintBg.setColor(0xfffffff0);
        paintBox = new Paint();
        paintBox.setColor(0x800000ff);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPaint(paintBg);
        //canvas.drawRect(30, 30, 200, 200, paintBox);
        //canvas.drawRect(130, 130, 300, 300, paintBox);
        canvas.drawRect(x1, y1, x2, y2, paintBox);
    }

    float x1, y1;
    float x2, y2;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //return super.onTouchEvent(event);
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                x1 = x;
                y1 = y;

                break;
            }
            case MotionEvent.ACTION_UP: {
                x2 = x;
                y2 = y;
                invalidate();
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                break;
            }
        }
        return true;
    }
}
