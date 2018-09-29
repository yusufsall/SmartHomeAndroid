package sal.yusuf.numur;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Yusuf on 22.11.2017.
 */

public class LockActivity extends BaseActivity {
    ImageView[] images;
    Button[] buttons;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kilit);
        int[] ids = {R.id.thirteen,R.id.fourteen,R.id.fiveteen};
        images = getImages(ids);
        buttons = getButtons(ids);
        buttons[0].setText("Giriş");
        buttons[1].setText("Bahçe");
        buttons[2].setText("Garaj");


        for(int i = 0 ; i < images.length; i++)
            images[i].setOnClickListener(new ClickListener(images[i],i + 12));
    }
}
