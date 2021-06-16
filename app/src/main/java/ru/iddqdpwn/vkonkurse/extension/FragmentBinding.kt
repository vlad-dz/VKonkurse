package ru.iddqdpwn.vkonkurse.extension

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding
import ru.iddqdpwn.vkonkurse.ui.base.BaseFragment
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified V : ViewBinding> fragmentBinding() = FragmentBinding(V::class.java)

@Suppress("UNCHECKED_CAST")
class FragmentBinding<T : ViewBinding>(private val bindingClass: Class<T>) :
    ReadOnlyProperty<BaseFragment, T> {

    private var binding: T? = null

    override fun getValue(thisRef: BaseFragment, property: KProperty<*>): T {
        initLifecycleListeners(thisRef)
        val inflateMethod = bindingClass.getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        )

        return binding ?: (inflateMethod.invoke(
            null,
            thisRef.layoutInflater,
            thisRef,
            false
        ) as T).also {
            binding = it
        }
    }

    private fun initLifecycleListeners(fragment: Fragment) {
        fragment.viewLifecycleOwner.lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                binding = null
            }
        })
    }

}