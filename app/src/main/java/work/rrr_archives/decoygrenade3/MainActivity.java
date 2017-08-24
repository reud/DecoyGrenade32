package work.rrr_archives.decoygrenade3;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    SoundPool pool;
    int sound1;
    int sound2;
    int sound3;
    int sound4;
    int sound5;
    int sound6;
    int sound7;
    int sound8;
    int sound9;
    String item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AudioAttributes attr=new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();
                pool=new SoundPool.Builder()
                .setAudioAttributes(attr)
                .setMaxStreams(9)
                .build();
        sound1=pool.load(this,R.raw.beamgun1,1);
        sound2=pool.load(this,R.raw.gun1,1);
        sound3=pool.load(this,R.raw.gun2,1);
        sound4=pool.load(this,R.raw.machinegun2,1);
        sound5=pool.load(this,R.raw.nc25721,1);
        sound6=pool.load(this,R.raw.nc30638,1);
        sound7=pool.load(this,R.raw.nc83409,1);
        sound8=pool.load(this,R.raw.nc122208,1);
        sound9=pool.load(this,R.raw.shot1,1);




    }

    public void onClickButton(View view){
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        TextView textview=(TextView)findViewById(R.id.text);
        item = (String)spinner.getSelectedItem();
        textview.setText(item);
        Timer timer =new Timer(5000,1000);
        timer.start();
    }
    public class RandomShooter extends CountDownTimer{
        public RandomShooter(long millislnFuture,long countDownInterval){
            super(millislnFuture,countDownInterval);
        }
        @Override
        public void onFinish(){
            Timer randtimer=new Timer(1001,1000);
            randtimer.start();
        }
        public void onTick(long millislnFture)
        {
            switch(item){
                case"銃声1":
                    pool.play(sound1, 1.0F, 1.0F, 0, 0, 1.0F);
                    break;
                case"銃声2":
                    pool.play(sound2, 1.0F, 1.0F, 0, 0, 1.0F);
                    break;
                case"銃声3":
                    pool.play(sound3, 1.0F, 1.0F, 0, 0, 1.0F);
                    break;
                case"銃声4":
                    pool.play(sound4, 1.0F, 1.0F, 0, 0, 1.0F);
                    break;
                case"銃声5":
                    pool.play(sound5, 1.0F, 1.0F, 0, 0, 1.0F);
                    break;
                case"銃声6":
                    pool.play(sound6, 1.0F, 1.0F, 0, 0, 1.0F);
                    break;
                case"銃声7":
                    pool.play(sound7, 1.0F, 1.0F, 0, 0, 1.0F);
                    break;
                case"銃声8":
                    pool.play(sound8, 1.0F, 1.0F, 0, 0, 1.0F);
                    break;
                case"銃声9":
                    pool.play(sound9, 1.0F, 1.0F, 0, 0, 1.0F);
                    break;
            }
        }
    }

    public class Timer extends CountDownTimer {
        public Timer(long millislnFuture,long countDownInterval){
            super(millislnFuture,countDownInterval);
        }
        TextView time=(TextView)findViewById(R.id.Timer);
        @Override
        public void onFinish(){
            Random rand=new Random();
            time.setText("開始");

                RandomShooter randomShooter = new RandomShooter(rand.nextInt(30) * 100+5000, rand.nextInt(10) * (rand.nextInt(4)+rand.nextInt(3)+rand.nextInt(3)) * 10);
                randomShooter.start();

        }

        @Override
        public void onTick(long millislnFuture){
            time.setText("開始まで残り"+ millislnFuture/1000 +"秒");
        }
    }
}
