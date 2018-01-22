package com.wickedsword.retar.comicquiz;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class SharingActivity extends AppCompatActivity {

    TextView thankyou_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharing);

        thankyou_message = (TextView) findViewById(R.id.end_message);

        String score = getIntent().getStringExtra("SCORE");
        String wrong = getIntent().getStringExtra("WRONG");
        String message = getString(R.string.end_message, score, wrong);

        thankyou_message.setText(message);
    }

    public void shareAnswers(View view) {
        String score = getIntent().getStringExtra("SCORE");
        String wrong = getIntent().getStringExtra("WRONG");
        String message = getString(R.string.share_message, score, wrong);

        shareTwitter(message);
    }

    private void shareTwitter(String message) {
        String url = "http://www.twitter.com/intent/tweet?text=" + message;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
