package sal.yusuf.numur;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Yusuf on 22.11.2017.
 */

public class LightActivity extends BaseActivity {
    ImageView[] images;
    Button[] buttons;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aydinlatma);
        int[] ids = {R.id.first,R.id.second,R.id.third,R.id.fourth,R.id.fifth,R.id.sixth};
        images = getImages(ids);
        buttons = getButtons(ids);
        buttons[0].setText("Giriş");
        buttons[1].setText("Salon");
        buttons[2].setText("Mutfak");
        buttons[3].setText("Çocuk Odası");
        buttons[4].setText("Yatak Odası");
        buttons[5].setText("Koridor");

        for(int i = 0 ; i < images.length; i++)
            images[i].setOnClickListener(new ClickListener(images[i] ,i));



    }


}
