/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficoborrar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.text.TextUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Log;
import org.jfree.util.PrintStreamLogTarget;

/**
 * A simple demonstration application showing how to create a bar chart with a custom item
 * label generator.
 */
public class BarChartDemo7 extends ApplicationFrame {
    public BarChartDemo7(final String title) {
        super(title);
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
    }
    private CategoryDataset createDataset() {
        
        // row keys...
        final String series1 = "First";
        final String series2 = "Second";
        final String series3 = "Third";

        // column keys...
        final String category1 = "Category 1";
        final String category2 = "Category 2";
        final String category3 = "Category 3";
        final String category4 = "Category 4";
        final String category5 = "Category 5";

        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1.0, series1, category1);
        dataset.addValue(4.0, series1, category2);
        dataset.addValue(3.0, series1, category3);
        dataset.addValue(5.0, series1, category4);
        dataset.addValue(5555555.0, series1, category5);

      
        
        return dataset;
        
    }
    private JFreeChart createChart(final CategoryDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
            "Bar Chart Demo 7",       // chart title
            "Category",               // domain axis label
            "Value",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                    // include legend
            true,                     // tooltips?
            false                     // URLs?
        );

        chart.setBackgroundPaint(Color.WHITE);

        final CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
       // plot.setRangeZeroBaselinePaint(Color.RED);
        plot.setOutlineVisible(true);
        plot.setRangeGridlinePaint(Color.white);
        plot.setDomainGridlinePaint(Color.BLACK);        

        final CategoryAxis categoryAxis = (CategoryAxis) plot.getDomainAxis();
        categoryAxis.setAxisLineVisible(false);
        categoryAxis.setTickMarksVisible(false);
        //categoryAxis.setVisible(false);

        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        //rangeAxis.setAxisLineVisible(false);
        rangeAxis.setVisible(false);
        rangeAxis.setLabelPaint(new Color(243,192,14));
        //rangeAxis.setRange(0, 3);
		
		//to display values on bars 
		CategoryItemRenderer categoryItemRenderer = plot.getRenderer();
		categoryItemRenderer.setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator());
		categoryItemRenderer.setSeriesItemLabelsVisible(0, true);
		plot.setRenderer(categoryItemRenderer);
        //chart.setSeriesPaint(0, Color.BLUE);
        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart;
        
    }
    public static void main(final String[] args) {

        Log.getInstance().addTarget(new PrintStreamLogTarget());
        TextUtilities.setUseFontMetricsGetStringBounds(false);
        final BarChartDemo7 demo = new BarChartDemo7("Bar Chart Demo 7");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}