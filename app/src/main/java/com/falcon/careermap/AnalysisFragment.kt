package com.falcon.careermap

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.falcon.careermap.databinding.FragmentAnalysisBinding
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class AnalysisFragment : Fragment() {
    private var _binding: FragmentAnalysisBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnalysisBinding.inflate(inflater, container, false)


// Creating Pie Chart
        val pieChart = binding.chart
        // Create a data set for the chart
        val pieEntries = listOf(
            PieEntry(20f, "Radiologic Technologist"),
            PieEntry(30f, "Audiologist"),
            PieEntry(50f, "Dentist")
        )
        val pieDataSet = PieDataSet(pieEntries, "       Professions")
        // Set the colors for the chart slices
        pieDataSet.colors = listOf(Color.RED, Color.GREEN, Color.BLUE)
        // Create a PieData object with the data set
        val pieData = PieData(pieDataSet)
        pieChart.setCenterTextColor(Color.RED)
        // Set the data for the chart
        pieChart.data = pieData
        // Refresh the chart
        pieChart.invalidate()
// Creating BarChart
        // Get the chart view from the layout
        val chart = binding.barChart
        // Create a data set for the chart
        val entries = listOf(
            BarEntry(0f, 20f),
            BarEntry(1f, 30f),
            BarEntry(2f, 50f)
        )
        val dataSet = BarDataSet(entries, "Professions")
        // Set the colors for the chart bars
        dataSet.colors = listOf(Color.RED, Color.GREEN, Color.BLUE)
        // Create a BarData object with the data set
        val data = BarData(dataSet)
        // Set the data for the chart
        chart.data = data
        // Refresh the chart
        chart.invalidate()




        // Set the x-axis labels for the chart
        val labels = listOf("Radiologic Technologist", "Audiologist", "Dentist")
        val xAxis = chart.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(labels)
        // Set the y-axis label text and color
        val yAxis = chart.axisLeft
        yAxis.axisMinimum = 0f
        yAxis.axisMaximum = 60f
        yAxis.textColor = Color.BLACK
        // Set the legend to display at the bottom of the chart
        chart.legend.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        chart.legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
        // Set the text size and color for the chart labels
        chart.xAxis.textSize = 12f
        chart.xAxis.textColor = Color.BLACK
        chart.axisLeft.textSize = 12f
        chart.axisLeft.textColor = Color.BLACK
        // Animate the chart when it is drawn
        chart.animateXY(1000, 1000)

        return binding.root
    }
}