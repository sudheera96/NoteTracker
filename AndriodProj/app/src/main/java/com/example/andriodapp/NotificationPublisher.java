package com.example.andriodapp;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NotificationPublisher extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String selectedNote = intent.getStringExtra("selectedNote");
        ObjectMapper objectMapper = new ObjectMapper();
        Note selectedNoteObj = null;
        try {
            selectedNoteObj = objectMapper.readValue(selectedNote, Note.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification(selectedNoteObj);
        notificationHelper.getManager().notify(1, nb.build());
        Notification notification = nb.build();
        notification.defaults |= Notification.DEFAULT_VIBRATE;
        notification.defaults |= Notification.DEFAULT_SOUND;
    }
}