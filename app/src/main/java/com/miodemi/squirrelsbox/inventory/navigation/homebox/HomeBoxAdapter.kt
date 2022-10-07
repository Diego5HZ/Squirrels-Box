package com.miodemi.squirrelsbox.inventory.navigation.homebox

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.miodemi.squirrelsbox.R
import com.miodemi.squirrelsbox.inventory.data.BoxData
import com.miodemi.squirrelsbox.databinding.ItemBoxBinding
import com.miodemi.squirrelsbox.inventory.components.box.BoxDialogModelViewFragment
import com.miodemi.squirrelsbox.inventory.components.box.UpdateBoxDialogFragment

class HomeBoxAdapter(

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val homeBoxItems = mutableListOf<BoxData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HomeBoxItemViewHolder(parent)
    }

    inner class HomeBoxItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).
                inflate(R.layout.item_box, parent, false)
    ) {

        private val binding = ItemBoxBinding.bind(itemView)

        fun onBind(
            homeBoxItem : BoxData
        ){
            binding.boxNameTv.text = homeBoxItem.name.toString()
            val boxId = homeBoxItem.id.toString()
            val boxName = homeBoxItem.name.toString()
            binding.editBtn.setOnClickListener { v : View ->
                Toast.makeText(itemView.context, "You clicked on item # ${position + 1}", Toast.LENGTH_SHORT).show()
                val activity = v.context as AppCompatActivity
                val fragmentViewFragment : BoxDialogModelViewFragment by activity.viewModels()
                fragmentViewFragment.setId(boxId)
                fragmentViewFragment.setName(boxName)
                fragmentViewFragment.setDate(boxName)

                UpdateBoxDialogFragment().show(activity.supportFragmentManager, "UpdateBoxDialog")
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as HomeBoxItemViewHolder).onBind(
            homeBoxItem = homeBoxItems[position])
    }

    override fun getItemCount(): Int = homeBoxItems.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(newsFeedItems: List<BoxData>?) {
        this.homeBoxItems.clear()
        this.homeBoxItems.addAll(newsFeedItems ?: emptyList())
        notifyDataSetChanged()
    }
}