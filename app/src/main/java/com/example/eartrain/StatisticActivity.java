package com.example.eartrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.eartrain.models.Score;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;


public class StatisticActivity extends AppCompatActivity implements OnChartGestureListener, OnChartValueSelectedListener
{
    private static final String TAG = "StatisticActivity";
    private LineChart m_chart;
    private List<Achievement> allAchievements;
    private List<Score> m_score;
    final String[] xValues = new String[]{"mon", "tue", "wed", "thu", "fri", "sat,", "sun"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        allAchievements = (List<Achievement>) getIntent().getSerializableExtra("achievementsList");
        m_chart = (LineChart) findViewById(R.id.linechart);

        m_chart.setOnChartGestureListener(StatisticActivity.this);
        m_chart.setOnChartValueSelectedListener(StatisticActivity.this);

        m_chart.setDragEnabled(true);
        m_chart.setScaleEnabled(false);

        ArrayList<Entry> yValues = new ArrayList<>();
        m_score = (List<Score>) getIntent().getSerializableExtra("scoreList");

        Log.i("Score: ", "Score list contains: " + m_score.size() + " elements");

        for(int i = 0; i < m_score.size(); i++)
        {
            Log.i("Score: ", " i = " + i);
            Score tmp = (Score)m_score.get(i);
            yValues.add(new Entry(i, (float)tmp.getScore()));
        }

        LineDataSet set1 = new LineDataSet(yValues, "Points Gained");

        set1.setFillAlpha(110);
        set1.setLineWidth(2f);
        set1.setValueTextSize(9f);

        // Disables the right axis
        m_chart.getAxisRight().setEnabled(false);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);

        m_chart.setData(data);

        Toast.makeText(getApplicationContext(), Integer.toString(allAchievements.size()), Toast.LENGTH_LONG).show();
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
        Toast.makeText(getApplicationContext(), "Graph of how many points was gained each day", Toast.LENGTH_LONG).show();
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
