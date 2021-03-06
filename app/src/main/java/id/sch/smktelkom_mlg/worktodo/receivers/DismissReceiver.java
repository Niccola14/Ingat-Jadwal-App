package id.sch.smktelkom_mlg.worktodo.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;

import id.sch.smktelkom_mlg.worktodo.utils.AlarmUtil;
import id.sch.smktelkom_mlg.worktodo.utils.NotificationUtil;

public class DismissReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int reminderId = intent.getIntExtra("NOTIFICATION_ID", 0);
        NotificationUtil.cancelNotification(context, reminderId);

        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean("checkBoxNagging", false)) {
            Intent alarmIntent = new Intent(context, NagReceiver.class);
            AlarmUtil.cancelAlarm(context, alarmIntent, reminderId);
        }
    }
}
