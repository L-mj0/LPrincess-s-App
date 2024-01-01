package com.example.lprincesssbloglimengjueroe21005;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class OverviewROE21005 extends AppCompatActivity {

    private PieChart pieChartlimengjue,pieChartCommentslimengjue;
    private MysqlROE21005 mysqllimengjue;

    @Override
    protected void onCreate(Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_overview_roe21005);

        pieChartlimengjue = findViewById(R.id.pieChart);
        pieChartCommentslimengjue = findViewById(R.id.pieChartComments);
        mysqllimengjue = new MysqlROE21005(this,"db_user",null,2);

        setupPieChart();
        loadPieChartlikesData();
        loadPieChartCommentsData();

    }

    private void setupPieChart(){
        pieChartlimengjue.setUsePercentValues(true);
        pieChartlimengjue.getDescription().setEnabled(false);
        pieChartlimengjue.setExtraOffsets(5,10,5,5);
        pieChartlimengjue.setDragDecelerationFrictionCoef(0.95f);

        pieChartlimengjue.setDrawHoleEnabled(true);
        pieChartlimengjue.setHoleColor(android.R.color.white);
        pieChartlimengjue.setTransparentCircleRadius(61f);
    }

    private void loadPieChartlikesData(){
        int guitar_likeslimengjue = mysqllimengjue.getallLikes(1);
        int piano_likeslimengjue = mysqllimengjue.getallLikes(2);
        int dance_likeslimengjue = mysqllimengjue.getallLikes(3);

        List<PieEntry> entrieslimengjue = new ArrayList<>();
        entrieslimengjue.add(new PieEntry(guitar_likeslimengjue,"Guitar\uD83C\uDFB8"));
        entrieslimengjue.add(new PieEntry(piano_likeslimengjue,"Piano\uD83C\uDFB9"));
        entrieslimengjue.add(new PieEntry(dance_likeslimengjue,"Dance\uD83D\uDC83\uD83C\uDFFB"));

        PieDataSet dataSetlimengjue = new PieDataSet(entrieslimengjue,"特长点赞比例");
        dataSetlimengjue.setSliceSpace(3f);
        dataSetlimengjue.setSelectionShift(5f);
        dataSetlimengjue.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData datalimengjue = new PieData(dataSetlimengjue);
        datalimengjue.setValueTextSize(10f);
        datalimengjue.setValueTextColor(android.R.color.black);

        pieChartlimengjue.setData(datalimengjue);
        pieChartlimengjue.invalidate();
    }

    private void loadPieChartCommentsData(){
        int guitar_commentslimengjue = mysqllimengjue.getallComments(1);
        int piano_commentslimengjue = mysqllimengjue.getallComments(2);
        int dance_commentslimengjue = mysqllimengjue.getallComments(3);

        List<PieEntry> entrieslimengjue = new ArrayList<>();
        entrieslimengjue.add(new PieEntry(guitar_commentslimengjue,"Guitar\uD83C\uDFB8"));
        entrieslimengjue.add(new PieEntry(piano_commentslimengjue,"Piano\uD83C\uDFB9"));
        entrieslimengjue.add(new PieEntry(dance_commentslimengjue,"Dance\uD83D\uDC83\uD83C\uDFFB"));

        PieDataSet dataSetlimengjue = new PieDataSet(entrieslimengjue,"特长评论比例");
        dataSetlimengjue.setSliceSpace(3f);
        dataSetlimengjue.setSelectionShift(5f);
        dataSetlimengjue.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData datalimengjue = new PieData(dataSetlimengjue);
        datalimengjue.setValueTextSize(10f);
        datalimengjue.setValueTextColor(android.R.color.black);

        pieChartCommentslimengjue.setData(datalimengjue);
        pieChartCommentslimengjue.invalidate();
    }
}
