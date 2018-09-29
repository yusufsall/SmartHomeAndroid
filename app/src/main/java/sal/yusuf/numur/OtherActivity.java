package sal.yusuf.numur;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Yusuf on 22.11.2017.
 */

public class OtherActivity extends BaseActivity {
    ImageView[] images;
    Button[] buttons;
    TextView temp,humadity,behav;
    Button update;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diger);
        int[] ids = {R.id.sixteen};
        images = getImages(ids);
        temp = findViewById(R.id.temp);
        humadity = findViewById(R.id.humadity);
        behav = findViewById(R.id.behaviour);
        update = findViewById(R.id.update);
        buttons = getButtons(ids);
        buttons[0].setText("Yedek");

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        UdpCommunication.send("a");
                        UdpCommunication.recieve();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                updateText();
                            }
                        });

                    }
                }).start();
            }
        });

        updateText();
        for(int i = 0 ; i < images.length; i++)
            images[i].setOnClickListener(new ClickListener(images[i],i + 15));


    }

    void updateText(){
        temp.setText("Sıcaklık: " + BaseActivity.sicaklik);
        humadity.setText("Nem       : " + BaseActivity.nem);
        behav.setText("Hareket :   " + (BaseActivity.checkDoor ? "Var" : "Yok"));
    }
}
