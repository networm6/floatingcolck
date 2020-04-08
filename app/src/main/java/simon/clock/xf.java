package simon.clock;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Gallery.LayoutParams;
public enum xf
{
	INTERFACE;
	
  
    private    WindowManager mWindowManager;
    private    UpdateTimeTextView toucherLayout;
    public boolean ishow=false;
    private    WindowManager.LayoutParams mParams;
   

    public void show(){
		if(!ishow){
        mWindowManager.addView(toucherLayout, mParams);     
		ishow=true;
		}else{
		mWindowManager.removeView(toucherLayout);
		ishow=false;
		}
    }
    public xf in(Context incon){
        mWindowManager = (WindowManager) incon.getSystemService(Context.WINDOW_SERVICE);
        mParams = new WindowManager.LayoutParams();
        mParams.type =WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
        // WindowManager.LayoutParams.TYPE_SYSTEM_ERROR; // 系统提示类型,重要
        mParams.format = PixelFormat.RGBA_8888;
        mParams.flags = 
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        mParams.gravity = Gravity.CENTER; // 调整悬浮窗口至左上角
        mParams.width = LayoutParams.MATCH_PARENT;
        mParams.height = LayoutParams.MATCH_PARENT;
 	toucherLayout=new UpdateTimeTextView(incon);
		ViewGroup.LayoutParams pa=new ViewGroup.LayoutParams(-1,-1);
		toucherLayout.setLayoutParams(pa);
		toucherLayout.setGravity(17|88);
        return this;
    }

}



