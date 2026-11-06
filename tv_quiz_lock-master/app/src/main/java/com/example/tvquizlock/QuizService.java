package com.example.tvquizlock;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;

public class QuizService extends Service {
    private Handler h = new Handler(Looper.getMainLooper());
    private Runnable task;
    private static final long DURATION = 300 * 1000;

    @Override
    public void onCreate() {
        super.onCreate();
        task = () -> {
            Intent i = new Intent(QuizService.this, QuizActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        };
    }

    public void startTimer() {
        h.removeCallbacks(task);
        h.postDelayed(task, DURATION);
    }

    public void stopTimer() {
        h.removeCallbacks(task);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startTimer();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) { return null; }
}