# myijkplayer
自己编译的安卓源码,修改直播缓冲,去掉-example中无用的activity,fragment,及资源文件,精简arm平台库并将其以jnilibs文件夹的形式将.so文件添加到-example中;方便将其集成到其他的工程中.
将该库以module或library的形式导入,或打包成jar或aar的形式进行集成.
参考记录<项目中集成ijkplayer官方demo>

# 基本使用:
## Activity中:

public class TestActivity extends AppCompatActivity {

    private AndroidMediaController mMediaController;
    private IjkVideoView mVideoView;
    String mVideoPath = "rtmp://live.hkstv.hk.lxdns.com/live/hks";
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

## 布局文件中:
    <tv.danmaku.ijk.media.example.widget.media.IjkVideoView
        android:id="@+id/video_view_test"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_gravity="center"/>


# 使用依赖库的形式
[依赖库网址](https://github.com/lichmeng/myijkplayer.git)

[![](https://jitpack.io/v/lichmeng/myijkplayer.svg)](https://jitpack.io/#lichmeng/myijkplayer)

