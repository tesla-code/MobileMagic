package com.example.eartrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class StatisticActivity extends AppCompatActivity implements OnChartGestureListener, OnChartValueSelectedListener
{
    private static final String TAG = "StatisticActivity";
    private LineChart m_chart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);

        m_chart = (LineChart) findViewById(R.id.linechart);

        m_chart.setOnChartGestureListener(StatisticActivity.this);
        m_chart.setOnChartValueSelectedListener(StatisticActivity.this);

        m_chart.setDragEnabled(true);
        m_chart.setScaleEnabled(false);
        ArrayList<Entry> yValues = new ArrayList<>();

        // Update these points based on storage
        yValues.add(new Entry(0, 60f));
        yValues.add(new Entry(1, 50f));
        yValues.add(new Entry(2, 70f));
        yValues.add(new Entry(3, 30f));
        yValues.add(new Entry(4, 50f));
        yValues.add(new Entry(5, 60f));
        yValues.add(new Entry(6, 65f));

        LineDataSet set1 = new LineDataSet(yValues, "Points Gained");

        set1.setFillAlpha(110);
        set1.setLineWidth(2f);
        set1.setValueTextSize(7f);

        // Disables the right axis
        m_chart.getAxisRight().setEnabled(false);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);

        m_chart.setData(data);

    }

    @Override
    public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture)
    {

    }

    @Override
    public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture)
    {

    }

    @Override
    public void onChartLongPressed(MotionEvent me)
    {

    }

    @Override
    public void onChartDoubleTapped(MotionEvent me)
    {

    }

    @Override
    public void onChartSingleTapped(MotionEvent me)
    {

    }

    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY)
    {

    }

    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY)
    {

    }

    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY)
    {

    }

    @Override
    public void onValueSelected(Entry e, Highlight h)
    {

    }

    @Override
    public void onNothingSelected()
    {

    }
}
