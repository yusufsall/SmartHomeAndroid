package sal.yusuf.numur;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {
    Button aydinlatma,energy,kilit,diger;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        new Thread(new Runnable() {
            @Override
            public void run() {
                UdpCommunication.start();
                if(!ClickListener.busy)
                UdpCommunication.send("a");

                UdpCommunication.recieve();
            }
        }).start();
        aydinlatma = findViewById(R.id.aydinlatma);
        energy = findViewById(R.id.enerji);
        kilit = findViewById(R.id.kilit);
        diger = findViewById(R.id.diger);



        aydinlatma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,LightActivity.class);
                startActivity(i);
            }
        });
        energy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,EnergyActivity.class);
                startActivity(i);
            }
        });
        kilit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,LockActivity.class);
                startActivity(i);
            }
        });
        diger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,OtherActivity.class);
                startActivity(i);
            }
        });


    }
}
