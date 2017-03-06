package in.ac.nith.music;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.*;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Map<String,Integer> map;
    MediaPlayer mMediaPlayer = null;
    Button start;
    EditText text;
    String notes;
    Button stop;
    SoundPool soundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        bindViews();
        final int x=R.raw.a1;
        map=new HashMap<String, Integer>();
        map.put("a1",soundPool.load(this,R.raw.a1,1));
        map.put("a1s",soundPool.load(this,R.raw.a1s,1));
        map.put("b1",soundPool.load(this,R.raw.b1,1));
        map.put("c1",soundPool.load(this,R.raw.c1,1));
        map.put("c1s",soundPool.load(this,R.raw.c1s,1));
        map.put("d1",soundPool.load(this,R.raw.d1,1));
        map.put("d1s",soundPool.load(this,R.raw.d1s,1));
        map.put("e1",soundPool.load(this,R.raw.e1,1));
        map.put("f1",soundPool.load(this,R.raw.f1,1));
        map.put("f1s",soundPool.load(this,R.raw.f1s,1));
        map.put("g1",soundPool.load(this,R.raw.g1,1));
        map.put("g1s",soundPool.load(this,R.raw.g1s,1));

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.release();
                soundPool=null;
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notes=text.getText().toString();
                //Toast.makeText(MainActivity.this, ""+notes, Toast.LENGTH_SHORT).show();
                String[] diffNotes=notes.split("\\.");
//                Toast.makeText(MainActivity.this, ""+diffNotes.length, Toast.LENGTH_SHORT).show();
                for(String note:diffNotes){
                   // Toast.makeText(MainActivity.this, ""+note, Toast.LENGTH_SHORT).show();
                    if(map.containsKey(note.toLowerCase())){
                        soundPool.play(map.get(note),1.0f,1.0f,0,-1,1);
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void bindViews(){
        text=(EditText) findViewById(R.id.text);
        start=(Button) findViewById(R.id.start);
        stop=(Button) findViewById(R.id.stop);
    }
}
