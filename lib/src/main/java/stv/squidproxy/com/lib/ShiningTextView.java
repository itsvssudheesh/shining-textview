package stv.squidproxy.com.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * TextView to display its content in a shining manner
 * Created by Sudhi on 5/18/2015.
 */
public class ShiningTextView extends TextView{

    private Context mContext;
    private float mCount=0;
    private int[] mColors=new int[]{Color.RED,Color.GREEN};
    private Shader mShader;
    private float mSpeed;

    public ShiningTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }

    public ShiningTextView(Context context) {
        super(context);
        initView(context,null);
    }

    public ShiningTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    /**
     * Initialise view items
     * @param context
     * @param attrs
     */
    private void initView(Context context, AttributeSet attrs){
        this.mContext=context;
        extractAttrsValues(attrs);
        mShader = new LinearGradient(0, 0, 0,getPaint().getTextSize() * mColors.length, mColors, null,
                Shader.TileMode.MIRROR);
    }

    /**
     * Extract attrs values from xml
     * @param attrs
     */
    private void extractAttrsValues(AttributeSet attrs) {
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.ShiningTextView, 0, 0);
        mSpeed = a.getFloat(R.styleable.ShiningTextView_speed,1.0f);
        int resource=a.getResourceId(R.styleable.ShiningTextView_color_array,0);
        mColors=a.getResources().getIntArray(resource);
        a.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Matrix matrix = new Matrix();
        matrix.setRotate(90);
        matrix.postTranslate(mCount, 0);
        mShader.setLocalMatrix(matrix);
        getPaint().setShader(mShader);
        mCount=mCount+mSpeed;
        invalidate();
    }
}
