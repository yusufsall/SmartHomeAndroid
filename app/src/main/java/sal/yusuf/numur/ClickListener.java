package sal.yusuf.numur;

import android.view.View;

/**
 * Created by Yusuf on 22.11.2017.
 */

public class ClickListener implements View.OnClickListener {
    int number = 0;
    boolean onoff = false;
    public static boolean busy = false;
    public ClickListener(View view,int number){
        this.number = number;
        onoff = BaseActivity.relays[number];
        if(!onoff)
            view.setBackgroundResource(R.drawable.off);
        else
            view.setBackgroundResource(R.drawable.on);

    }
    @Override
    public void onClick(View view) {
        if(!busy) {
            if (onoff) {
                view.setBackgroundResource(R.drawable.off);
                onoff = false;
                BaseActivity.relays[number] = onoff;
            } else {
                view.setBackgroundResource(R.drawable.on);
                onoff = true;
                BaseActivity.relays[number] = onoff;
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //UdpCommunication.start();
                    String buff = "";
                    for (int i = number; i < number + 5; i++)
                        if(i > 15)
                            break;
                        else
                        buff += (i + ":" + (BaseActivity.relays[i] ? "1" : "0") + ":");

                    if (!busy)
                        UdpCommunication.send(buff);
                }
            }).start();
        }

    }
}
