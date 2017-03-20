package tv.danmaku.ijk.media.example.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import tv.danmaku.ijk.media.example.R;
import tv.danmaku.ijk.media.example.widget.media.AndroidMediaController;
import tv.danmaku.ijk.media.example.widget.media.IjkVideoView;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * Created by lichaomeng on 2017/3/10 0010.
 *
 * @Description:
 */

public class TestActivity extends AppCompatActivity {

    private AndroidMediaController mMediaController;
    private IjkVideoView mVideoView;
    String mVideoPath = "rtmp://live.hkstv.hk.lxdns.com/live/hks";
//    String    mVideoPath = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f30.mp4";
//   String     mVideoPath = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f30.mp4";
//    String mVideoPath = "rtmp://183.230.102.57:10800/myapp/338477024647581696_0_?token=KUR0OUV2K0-3*E1y*EV3*E10K0i1O0-xKlR3OE-2*EF3*UaAK0K$OE-4KEJ1OlR4OUiyOlm3Z0Ch";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test);
        mMediaController = new AndroidMediaController(this, false);
        // init player
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");

        mVideoView = (IjkVideoView) findViewById(R.id.video_view_test);
        mVideoView.setMediaController(mMediaController);
        mVideoView.setVideoPath(mVideoPath);
        mVideoView.start();
    }
}
