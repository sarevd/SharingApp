package codeo.com.sharingapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class InstagramActivity extends AppCompatActivity {

    Button instagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        instagram = (Button) findViewById(R.id.button);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PackageManager pm = getPackageManager();
                boolean isInstalled = Util.isPackageInstalled("com.instagram.android", pm);
                if(isInstalled)
                createInstagramIntent();
            }
        });
    }

    private void createInstagramIntent() {
        final Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/*");
        String imagePath = Environment.getExternalStorageDirectory() + "/sc.png";
        final File photoFile = new File(imagePath);
        shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(photoFile));
        shareIntent.putExtra(Intent.EXTRA_TITLE, "sometext here");
        startActivity(Intent.createChooser(shareIntent, "Share image using"));
    }

}
