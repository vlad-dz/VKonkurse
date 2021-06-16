package ru.iddqdpwn.vkonkurse.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ru.iddqdpwn.vkonkurse.R
import ru.iddqdpwn.vkonkurse.databinding.ItemGiveawayBinding
import ru.iddqdpwn.vkonkurse.ui.model.Giveaway
import kotlin.random.Random

class GiveawayAdapter: RecyclerView.Adapter<GiveawayAdapter.GiveawayVH>() {

    private val giveawayList = mutableListOf<Giveaway>()

    inner class GiveawayVH(val binding: ItemGiveawayBinding): RecyclerView.ViewHolder(binding.root) {
        init {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiveawayVH {
        return GiveawayVH(
            ItemGiveawayBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        )
    }

    override fun onBindViewHolder(holder: GiveawayVH, position: Int) {
        val item = giveawayList[position]

        holder.binding.apply {
            tvTitle.text = giveawayList[position].title

            val rand = Random.nextInt(0, 3)
            when (rand) {
                0 -> indicator.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.red))
                1 -> indicator.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.yellow))
                2-> indicator.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.green))
            }
        }
    }

    override fun getItemCount(): Int {
        return giveawayList.size
    }

    fun setList(list: List<Giveaway>) {
        giveawayList.clear()
        giveawayList.addAll(list)
        notifyDataSetChanged()
    }
}