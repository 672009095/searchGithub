package rama.id.searchgithub.shared.extensions

import android.content.Context
import android.content.Intent

fun Context.startActivityClearTask(intent: Intent) {
    startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
}