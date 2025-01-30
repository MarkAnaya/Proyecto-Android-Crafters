package com.example.proyectoandroidcrafters.view.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoandroidcrafters.databinding.ProductItemBinding
import com.example.proyectoandroidcrafters.model.ProductData

class ProductAdapter(
    private val product: MutableList<ProductData>
): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private lateinit var context: Context

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ProductItemBinding.bind(view)

        fun setupUI(item: ProductData) {
            binding.TitleTextView.text = item.date
            binding.maxTempTextView.text = item.day.maxTemp.toString() + "°C"
            binding.minTempTextView.text = item.day.minTemp.toString() + "°C"

            binding.containerView.setOnClickListener {
                Log.i("MENSAJE", "El clima estara: ${item.day.condition.text}")
            }

            Glide.with(itemView.context)
                .load(item.day.condition.icon)
                .placeholder(R.drawable.weather_ic)
                .error(R.drawable.broke_ic)
                .into(binding.weatherIcon)
        }
    }


    fun add(forecastItems: List<ForecastDay>) {
        forecast.addAll(forecastItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastAdapter.ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context)
            .inflate(R.layout.forecast_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return forecast.count()
    }

    override fun onBindViewHolder(holder: ForecastAdapter.ViewHolder, position: Int) {
        holder.setupUI(forecast[position])
    }
}