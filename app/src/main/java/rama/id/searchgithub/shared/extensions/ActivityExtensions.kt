package rama.id.searchgithub.shared.extensions

import android.app.Activity
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import rama.id.searchgithub.R

/**
 * this class is for base default error message or default message info
 * this class contains toast, snackbar, or maybe dialog
 */
fun Activity.showToast(@StringRes resourceId: Int) {
    Toast.makeText(this, resourceId, Toast.LENGTH_SHORT).show()
}

fun Activity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Activity.showSnackBar(@StringRes resourceId: Int, onNext: (() -> Unit)? = null) {
    showSnackBar(getString(resourceId), onNext)
}

fun Activity.showSnackBar(message: String?, onNext: (() -> Unit)? = null) {
    Snackbar.make(
        findViewById(android.R.id.content),
        message ?: "Unexpected error",
        Snackbar.LENGTH_SHORT
    )
        .apply {
            onNext?.run {
                addCallback(object : BaseTransientBottomBar.BaseCallback<Snackbar>() {
                    override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                        onNext()
                    }
                })
            }
            val textView =
                view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            textView?.setTextColor(ContextCompat.getColor(this@showSnackBar, android.R.color.white))
        }
        .show()
}