package id.co.gits.jntexpress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Telepon(View view) {
        Intent Telp = new Intent(Intent.ACTION_DIAL);
        Telp.setData(Uri.parse("tel: (085381189922)"));
        startActivity(Telp);
    }

    public void email(View view) {
        String [] TO = {"maskurnia.id@gmail.com"};
        Intent EmailIntent = new Intent(Intent.ACTION_SEND);

        EmailIntent.setData(Uri.parse("mailto: "));
        EmailIntent.setType("message/rfc822");
        EmailIntent.putExtra(Intent.EXTRA_EMAIL, TO);

        try {
            startActivity(Intent.createChooser(EmailIntent, "send mail...."));
            finish();
        } catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(MainActivity.this, "Tidak ada email yang dimasukkan", Toast.LENGTH_SHORT).show();
        }
    }

    public void profil(View view) {
        Intent i = new Intent(this, Profil.class);
        startActivity(i);
    }

    public void whatsapp(View view) {
        String url = "https://api.whatsapp.com/send?phone=+6285381189922";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void maps(View view) {
        Uri link_maps = Uri.parse("https://maps.app.goo.gl/XYghFrQXTKF7cJ2g6");
        Intent buka_maps = new Intent(Intent.ACTION_VIEW, link_maps);
        startActivity(buka_maps);
    }
}