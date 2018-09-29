package sal.yusuf.numur;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.ImageView;

public class EnergyActivity extends BaseActivity {
    ImageView[] images;
    Button[] buttons;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.priz);
        int[] ids = {R.id.seventh,R.id.eighty,R.id.ninety,R.id.ten,R.id.eleven,R.id.twelve};
        images = getImages(ids);
        buttons = getButtons(ids);
        buttons[0].setText("Giriş");
        buttons[1].setText("Salon");
        buttons[2].setText("Mutfak");
        buttons[3].setText("Çocuk Odası");
        buttons[4].setText("Yatak Odası");
        buttons[5].setText("Koridor");


        for(int i = 0 ; i < images.length; i++)
            images[i].setOnClickListener(new ClickListener(images[i],i + 6));


    }
}
