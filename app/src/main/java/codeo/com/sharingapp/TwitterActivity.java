package codeo.com.sharingapp;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import java.io.File;

import io.fabric.sdk.android.Fabric;


public class TwitterActivity extends AppCompatActivity {

    Button tweet;

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "vNneu6SY8CzOMQzFA0pJDVplm";
    private static final String TWITTER_SECRET = "jHXVWeknZJnbsQCcZC5l35F1C8ZpEKNBPrKJVRzrRcLbu4IZTV";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);

        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new TweetComposer());

        File myImageFile = new File(Environment.getExternalStorageDirectory() + "/sc.png");
        final Uri myImageUri = Uri.fromFile(myImageFile);

        tweet = (Button) findViewById(R.id.button2);
        tweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TweetComposer.Builder builder = new TweetComposer.Builder(TwitterActivity.this)
                        .text("just setting up my Fabric.")
                        .image(myImageUri);
                builder.show();
            }
        });
    }
}
