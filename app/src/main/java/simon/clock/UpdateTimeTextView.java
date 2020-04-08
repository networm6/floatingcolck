package simon.clock;


import android.content.Context;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;
import simon.clock.UpdateTimeTextView;

public class UpdateTimeTextView  extends TextView
{

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            UpdateTimeTextView.this.setText((String)msg.obj);
        }
    };
    private String DEFAULT_TIME_FORMAT = "HH : mm : ss";

    public UpdateTimeTextView(Context context) {
        super(context);
        init();
		setTextSize(24);
		setTextColor(Color.WHITE);
    }

    private void init() {
        new Thread(new Runnable() {
				@Override
				public void run() {
					while(true){
//                    SimpleDateFormat sdf=new SimpleDateFormat(DEFAULT_TIME_FORMAT);
//                    String str=sdf.format(new Date());
						SimpleDateFormat dateFormatter = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
						String time = dateFormatter.format(Calendar.getInstance().getTime());
						handler.sendMessage(handler.obtainMessage(100,time));
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
    }

//根据毫秒时间获取格式化的提示

}


