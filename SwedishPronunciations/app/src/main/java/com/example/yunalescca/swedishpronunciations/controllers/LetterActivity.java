package com.example.yunalescca.swedishpronunciations.controllers;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
import com.example.yunalescca.swedishpronunciations.*;
import com.example.yunalescca.swedishpronunciations.services.LetterManager;

public class LetterActivity extends Tools implements View.OnClickListener{

    private boolean isColored = true;
    private Timer myTimer = new Timer();

    private FloatingActionButton playRecordingButton, recordButton, stopRecordingButton, stopPlayingButton;
    private Recorder recorder;
    private static final int ASK_MULTIPLE_PERMISSION_REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_view);
        Drawable background = findViewById(R.id.activity_letter_view).getBackground();
        background.setAlpha(80);

        recorder = new Recorder();
        int audioPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);
        int storagePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if(audioPermission != PackageManager.PERMISSION_GRANTED ||
                storagePermission != PackageManager.PERMISSION_GRANTED){
            makeRequest();
        }

        int letterPosition = 0;
        int letterType = LetterManager.TYPE_ALL;

        Bundle args = getIntent().getExtras();

        if (args != null) {
            letterPosition = args.getInt(LetterFragment.ARG_LETTER_POSITION, letterPosition);
            letterType = args.getInt(LetterFragment.ARG_LETTER_TYPE, letterType);
        }

        LetterPagerAdapter mLetterPagerAdapter = new LetterPagerAdapter(getSupportFragmentManager());
        mLetterPagerAdapter.setLetterType(letterType);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mLetterPagerAdapter);
        mViewPager.setCurrentItem(letterPosition);

        init();
    }

    private void makeRequest() {
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.RECORD_AUDIO
                , Manifest.permission.WRITE_EXTERNAL_STORAGE},
                ASK_MULTIPLE_PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case ASK_MULTIPLE_PERMISSION_REQUEST_CODE:
                if (grantResults.length == 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Log.i("", "Permission has been denied by user");

                    //kommer returna false om man trycker in "never ask again".
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this,  Manifest.permission.RECORD_AUDIO)) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setMessage("Permission to access the microphone and storage is " +
                                "required for this app to record as well as play audio.")
                                .setTitle("Permission required");
                        builder.setPositiveButton("Try again", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                makeRequest();
                            }
                        });

                        builder.setNegativeButton("I'm sure", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //fab.setEnabled(false);
                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                    } else {
                        makeRequest();
                    }

                }
                break;

            default: //do nothing
                break;
        }
    }

    public void tutorialGoTo(View v){
        Intent intent = new Intent(this, TutorialActivity.class);
        startActivity(intent);
    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Swedish Pronunciations");
        initRecorderUI();
    }

    private void initRecorderUI() {

        playRecordingButton = (FloatingActionButton) findViewById(R.id.playRecording);
        playRecordingButton.setEnabled(false);
        playRecordingButton.setOnClickListener(this);
        playRecordingButton.getBackground().setAlpha(70);
        playRecordingButton.setImageAlpha(70);

        recordButton = (FloatingActionButton) findViewById(R.id.recordButton);
        recordButton.setEnabled(true);
        recordButton.setOnClickListener(this);

        stopRecordingButton = (FloatingActionButton) findViewById(R.id.stopButton);
        stopRecordingButton.setEnabled(true);
        stopRecordingButton.setVisibility(View.GONE);
        stopRecordingButton.setOnClickListener(this);

        stopPlayingButton = (FloatingActionButton) findViewById(R.id.stopPlayingButton);
        stopPlayingButton.setEnabled(false);
        stopPlayingButton.setVisibility(View.GONE);
        stopPlayingButton.setOnClickListener(this);

        recorder.syncWithRecorderPlayback(playRecordingButton,stopPlayingButton);
    }

    @Override
    public void onClick(View v) {
        stopRecordingButton.setEnabled(false);
        recordButton.setEnabled(false);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        stopRecordingButton.setEnabled(true);
                        recordButton.setEnabled(true);
                    }
                });
            }
        }, 100);

        int id = v.getId();

        switch(id){
            case R.id.stopButton:

                recordButton.setVisibility(View.VISIBLE);
                recordButton.setEnabled(true);
                stopRecordingButton.setVisibility(View.GONE);
                stopRecordingButton.setEnabled(false);
                recorder.stopRecording();

                myTimer.cancel();
                myTimer.purge();
                myTimer = new Timer();
                isColored = true;

                playRecordingButton.setEnabled(true);
                playRecordingButton.getBackground().setAlpha(255);
                playRecordingButton.setImageAlpha(255);

                break;

            case R.id.recordButton:
                recorder.stopAudio();
                playRecordingButton.setEnabled(false);
                playRecordingButton.getBackground().setAlpha(70);
                playRecordingButton.setImageAlpha(70);
                playRecordingButton.setVisibility(View.VISIBLE);

                stopPlayingButton.setEnabled(false);
                stopPlayingButton.setVisibility(View.GONE);

                recordButton.setVisibility(View.GONE);
                recordButton.setEnabled(false);
                stopRecordingButton.setVisibility(View.VISIBLE);
                stopRecordingButton.setEnabled(true);

                final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.stopButton);

                myTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                if(isColored){
                                    fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimary)));
                                    isColored = false;
                                } else {
                                    fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent
                                    )));
                                    isColored = true;
                                }
                            }
                        });
                    }
                }, 0, 800);
                recorder.recordAudio();

                break;

            case R.id.playRecording:
                playRecordingButton.setVisibility(View.GONE);
                playRecordingButton.setEnabled(false);
                stopPlayingButton.setVisibility(View.VISIBLE);
                stopPlayingButton.setEnabled(true);
                AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 100, 0);
                recorder.playAudio();
                break;

            case R.id.stopPlayingButton:
                playRecordingButton.setVisibility(View.VISIBLE);
                playRecordingButton.setEnabled(true);
                stopPlayingButton.setVisibility(View.GONE);
                stopPlayingButton.setEnabled(false);
                recorder.stopAudio();
                break;

            default: break;
        }
    }

    @Override
    public void onBackPressed() {
        recorder.stopAudio();
        Intent intent = new Intent(this, VowelMenuActivity.class);
        startActivity(intent);
    }
}
