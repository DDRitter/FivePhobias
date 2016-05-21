package com.artactivo.fivephobias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean [] isPhobiaVisible = { false, false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when a title is touched
     *
     * @param title the view touched
     */
    public void showPhobia(View title) {
        int phobiaNumber = Integer.parseInt(title.getTag().toString());
        TextView content;
        ImageView image;
        switch (phobiaNumber) {
            case 0:
                content = (TextView) findViewById(R.id.content_0);
                image = (ImageView) findViewById(R.id.image_0);
                break;
            case 1:
                content = (TextView) findViewById(R.id.content_1);
                image = (ImageView) findViewById(R.id.image_1);
                break;
            case 2:
                content = (TextView) findViewById(R.id.content_2);
                image = (ImageView) findViewById(R.id.image_2);
                break;
            case 3:
                content = (TextView) findViewById(R.id.content_3);
                image = (ImageView) findViewById(R.id.image_3);
                break;
            default:
                content = (TextView) findViewById(R.id.content_4);
                image = (ImageView) findViewById(R.id.image_4);
                break;
        }
        if (content != null && image != null) {
            if (isPhobiaVisible[phobiaNumber]) {
                content.setVisibility(View.GONE);
                //image.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.default_title_height);
                //title.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.default_title_height);
                isPhobiaVisible[phobiaNumber] = false;
            } else {
                content.setVisibility(View.VISIBLE);
                //image.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.expanded_title_height);
                //title.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.expanded_title_height);
                isPhobiaVisible[phobiaNumber] = true;
            }
        }
    }
}
