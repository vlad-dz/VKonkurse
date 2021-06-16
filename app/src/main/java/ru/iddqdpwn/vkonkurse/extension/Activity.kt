package ru.iddqdpwn.vkonkurse.extension

import android.app.Activity
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified V : ViewBinding> activityBinding() = ActivityBinding(V::class.java)

@Suppress("UNCHECKED_CAST")
class ActivityBinding<T : ViewBinding>(private val bindingClass: Class<T>) :
    ReadOnlyProperty<Activity, T> {

    private var binding: T? = null

    override fun getValue(thisRef: Activity, property: KProperty<*>): T {
        val inflateMethod = bindingClass.getMethod("inflate", LayoutInflater::class.java)

        return binding ?: (inflateMethod.invoke(null, thisRef.layoutInflater) as T).also {
            binding = it
        }
    }
}