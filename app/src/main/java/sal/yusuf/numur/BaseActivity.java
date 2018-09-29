package sal.yusuf.numur;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Yusuf on 22.11.2017.
 */

public class BaseActivity extends AppCompatActivity {
    public static boolean[] relays = new boolean[16];
    public static boolean checkDoor = false;
    public static float sicaklik = 0.0f;
    public static float nem = 0.0f;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
    }
    public ImageView[] getImages(int[] ids){
        ImageView[] images = new ImageView[ids.length];

        for(int i = 0; i < ids.length; i++)
            images[i] = findViewById(ids[i]).findViewById(R.id.img);


        return images;
    }
    public Button[] getButtons(int[] ids){
        Button[] buttons = new Button[ids.length];

        for(int i = 0; i < ids.length; i++)
            buttons[i] = findViewById(ids[i]).findViewById(R.id.btn);


        return buttons;
    }
}
