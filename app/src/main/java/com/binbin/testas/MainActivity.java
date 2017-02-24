package com.binbin.testas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.binbin.testas.opengl.MyFrameAnimationView2;

public class MainActivity extends AppCompatActivity {

    private int count = 93;
    private int[] res=new int[count];
    private int[] duration=new int[count];
    public static int sWidth,sHeight;

    private int playCount = 5;//播放次数
    private int playnumber = 0;//播放计数器
    private int  durationTime = 50;//每帧播放时间ms
    ImageView iv;
    private Button btPlay;
    private LinearLayout ll_viewroot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_viewroot = (LinearLayout) findViewById(R.id.ll_viewroot);

        btPlay = (Button) findViewById(R.id.bt_play);

        iv= (ImageView) findViewById(R.id.iv);

        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                playAnimation();
                playAnimation1();
//                playAnimation2();
//                playAnimation3();
            }
        });


    }

    private void playAnimation() {
        ll_viewroot.setVisibility(View.GONE);
        iv.setVisibility(View.VISIBLE);
        for (int i = 0; i < count; i++) {
            int id = getResources().getIdentifier("lbjn_" + i, "mipmap", getPackageName());
            res[i]=id;
            duration[i] = durationTime;
        }

        MyAnimationDrawable.getInstance().animateFromDrawableResource(res, duration, iv, new OnAnimationListener() {
            @Override
            public void onDrawableLoaded(Object obj) {
                Log.e("yd", "加载图片中");
            }

            @Override
            public void onAnimationStart() {
                Log.e("yd", "开始播放");
            }

            @Override
            public void onAnimationEnd() {
                ++playnumber;
                Log.e("yd", "播放次数" + playnumber);
                if (playCount == playnumber) {
                    playnumber = 0;
                    Log.e("yd", "播放完成");

                } else {
                    playAnimation();
                }

            }
        });
    }


    private void playAnimation1() {
        ll_viewroot.setVisibility(View.GONE);
        iv.setVisibility(View.VISIBLE);
        for (int i = 0; i < count; i++) {
            int id = getResources().getIdentifier("lbjn_" + i, "mipmap", getPackageName());
            res[i]=id;
            duration[i] = durationTime;
        }

        MyFrameAnimation.getInstance().animateFromDrawableResource(res, duration, iv, new OnAnimationListener() {
            @Override
            public void onDrawableLoaded(Object obj) {

            }

            @Override
            public void onAnimationStart() {

            }

            @Override
            public void onAnimationEnd() {
                ++playnumber;
                Log.e("yd", "播放次数" + playnumber);
                if (playCount == playnumber) {
                    playnumber = 0;
                    Log.e("yd", "播放完成");

                } else {
                    playAnimation1();
                }

            }
        });
    }

    private void playAnimation2() {
        ll_viewroot.removeAllViews();
        for (int i = 0; i < count; i++) {
            int id = getResources().getIdentifier("lbjn_" + i, "mipmap", getPackageName());
            res[i]=id;
            duration[i] = durationTime;
        }

        MyFrameAnimationView  myFrameAnimationViewnew = new MyFrameAnimationView(this, res, duration, new OnAnimationListener() {
           @Override
           public void onDrawableLoaded(Object obj) {

           }

           @Override
           public void onAnimationStart() {

           }

           @Override
           public void onAnimationEnd() {
               ++playnumber;
               Log.e("yd", "播放次数" + playnumber);
               if (playCount == playnumber) {
                   playnumber = 0;
                   Log.e("yd", "播放完成");

               } else {
                   playAnimation2();
               }
           }
       });
        ll_viewroot.addView(myFrameAnimationViewnew);

    }


    private void playAnimation3() {
        ll_viewroot.removeAllViews();
        for (int i = 0; i < count; i++) {
            int id = getResources().getIdentifier("lbjn_" + i, "mipmap", getPackageName());
            res[i]=id;
            duration[i] = durationTime;
        }

        MyFrameAnimationView2 myFrameAnimationViewnew = new MyFrameAnimationView2(MainActivity.this, res, duration, new OnAnimationListener() {
            @Override
            public void onDrawableLoaded(Object obj) {

            }

            @Override
            public void onAnimationStart() {

            }

            @Override
            public void onAnimationEnd() {
                ++playnumber;
                Log.e("yd", "播放次数" + playnumber);
                if (playCount == playnumber) {
                    playnumber = 0;
                    Log.e("yd", "播放完成");

                } else {
                    playAnimation3();
                }
            }
        });

        ll_viewroot.addView(myFrameAnimationViewnew);

    }

}
