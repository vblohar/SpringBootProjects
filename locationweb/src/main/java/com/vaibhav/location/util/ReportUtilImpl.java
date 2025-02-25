package com.vaibhav.location.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ReportUtilImpl implements ReportUtil {

	
	@Override
	public void generatePieChart(String path, List<Object[]> data) {
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		for (Object[] objects : data ) {
			dataset.setValue(objects[0].toString(), new Double(objects[1].toString()));
		}
		
		JFreeChart chart = ChartFactory.createPieChart3D("Location type report", dataset);
		
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/pieChart.jpeg"), chart, 300, 300);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}

}
