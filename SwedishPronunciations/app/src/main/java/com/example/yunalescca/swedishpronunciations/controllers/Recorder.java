package com.example.yunalescca.swedishpronunciations.controllers;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import java.io.IOException;

/**
 * Created by Yunalescca on 30/09/16.
 */

public class Recorder {

    private MediaRecorder mediaRecorder;
    private String outputAudioFile;
    private MediaPlayer mediaPlayer;

    public Recorder() {
        outputAudioFile = Environment.getExternalStorageDirectory().getAbsolutePath();
        outputAudioFile += "/myrec.3gp";

        mediaPlayer = new MediaPlayer();
    }

    public void recordAudio() {
        mediaRecorder = new MediaRecorder();

        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setOutputFile(outputAudioFile);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mediaRecorder.prepare();
            mediaRecorder.start();

        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopRecording() {
        try {
            mediaRecorder.stop();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        mediaRecorder.reset();
        mediaRecorder.release();
        mediaRecorder = null;
    }

    public void playAudio() {
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(outputAudioFile);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopAudio() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
    }

    public void syncWithRecorderPlayback(final FloatingActionButton play, final FloatingActionButton stop) {
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                play.setEnabled(true);
                play.setVisibility(View.VISIBLE);
                stop.setEnabled(false);
                stop.setVisibility(View.GONE);
            }
        });

    }
}