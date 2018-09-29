package sal.yusuf.numur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    Button login;
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        for(boolean relay : BaseActivity.relays)
            relay = false;

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals(""))
                    Toast.makeText(MainActivity.this,"Lütfen kullanıcı adı veya şifreyi boş bırakmayınız!",Toast.LENGTH_SHORT).show();
                else
                {
                    if(user.equals("admin") && pass.equals("00001111")) {
                        Intent i = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(i);
                        finish();
                    }else
                        Toast.makeText(MainActivity.this,"Şifre hatalı!",Toast.LENGTH_SHORT).show();
                }




            }
        });


    }
}
