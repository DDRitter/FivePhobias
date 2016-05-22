package com.artactivo.fivephobias;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean[] isPhobiaVisible = {false, false, false, false, false};
    TextView title;
    TextView content;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when a phobia is touched
     * <p/>
     * Shows/hides the touched phobia
     *
     * @param view the view touched
     */
    public void togglePhobia(View view) {
        int phobiaNumber = Integer.parseInt(view.getTag().toString());
        getViewIds(phobiaNumber);
        if (content != null && image != null && title != null) {
            if (isPhobiaVisible[phobiaNumber]) {
                content.setVisibility(View.GONE);
                image.setVisibility(View.GONE);
                title.setBackgroundColor(ContextCompat.getColor(this, R.color.titleBackground));
                title.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.title_height);
                isPhobiaVisible[phobiaNumber] = false;
            } else {
                content.setVisibility(View.VISIBLE);
                image.setVisibility(View.VISIBLE);
                title.setBackgroundColor(Color.TRANSPARENT);
                //title.setHeight(300);  ????
                //title.setHeight(getResources().getDimensionPixelSize(R.dimen.image_height)); ????
                title.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.image_height);
                hidePhobias();
                isPhobiaVisible[phobiaNumber] = true;
            }
        }
    }


    /**
     * This method hides all the phobias
     */
    private void hidePhobias() {
        for (int i = 0; i <= 4; i++) {
            if (isPhobiaVisible[i]) {
                getViewIds(i);
                content.setVisibility(View.GONE);
                image.setVisibility(View.GONE);
                title.setBackgroundColor(ContextCompat.getColor(this, R.color.titleBackground));
                title.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.title_height);
                isPhobiaVisible[i] = false;
            }
        }
    }


    /**
     * This method gets the proper view ids
     */
    private void getViewIds(int viewNumber) {
        switch (viewNumber) {
            case 0:
                title = (TextView) findViewById(R.id.title_0);
                image = (ImageView) findViewById(R.id.image_0);
                content = (TextView) findViewById(R.id.content_0);
                break;
            case 1:
                title = (TextView) findViewById(R.id.title_1);
                image = (ImageView) findViewById(R.id.image_1);
                content = (TextView) findViewById(R.id.content_1);
                break;
            case 2:
                title = (TextView) findViewById(R.id.title_2);
                image = (ImageView) findViewById(R.id.image_2);
                content = (TextView) findViewById(R.id.content_2);
                break;
            case 3:
                title = (TextView) findViewById(R.id.title_3);
                image = (ImageView) findViewById(R.id.image_3);
                content = (TextView) findViewById(R.id.content_3);
                break;
            default:
                title = (TextView) findViewById(R.id.title_4);
                image = (ImageView) findViewById(R.id.image_4);
                content = (TextView) findViewById(R.id.content_4);
                break;
        }
    }
}