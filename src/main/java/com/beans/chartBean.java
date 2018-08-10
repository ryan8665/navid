/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.dto.UserTypeDto;
import com.service.UserService;
import com.service.UserServiceImp;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.utility.DateTime;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author ryan
 */
@ManagedBean
@ViewScoped
public class chartBean extends BaseBean {
    
    private PieChartModel pieModel;
    private int countAllUser;
    private LineChartModel lineModel;
    @PostConstruct
    public void init() {
        initLinearModel();
        initPieModel();
    }
    public LineChartModel getLineModel() {
        return lineModel;
    }
    
    public PieChartModel getPieModel() {
        return pieModel;
    }

    public int getCountAllUser() {
        return countAllUser;
    }
    
    
    private void initPieModel() {

        pieModel = new PieChartModel();
        UserService UserService = new UserServiceImp();
        List<Object[]> list = UserService.cuntUserGroupByUser();

        for (Object[] result : list) {
            pieModel.set(result[1].toString(), Integer.parseInt(result[0].toString()));
            countAllUser =+ Integer.parseInt(result[0].toString());

        }
        pieModel.setExtender("skinPie");

    }
    
    private void initLinearModel() {
        lineModel = new LineChartModel();
        // lineModel.setTitle("گزارش ۵ روز گذشته");
        lineModel.setLegendPosition("e");
        lineModel.setExtender("skinChart");
        lineModel.setAnimate(true);
        lineModel.getAxes().put(AxisType.X, new CategoryAxis(""));
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        //yAxis.setMax(10);
        String a = "", b = "", c = "", d = "", e = "";
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("فروش");
        Calendar cal = Calendar.getInstance();

        try {
            
            cal.add(Calendar.DATE, 0);
            a = DateTime.justDay(cal.getTime());
            cal.add(Calendar.DATE, -1);
            b = DateTime.justDay(cal.getTime());
            cal.add(Calendar.DATE, -1);
            c = DateTime.justDay(cal.getTime());
            cal.add(Calendar.DATE, -1);
            d = DateTime.justDay(cal.getTime());
            cal.add(Calendar.DATE, -1);
            e = DateTime.justDay(cal.getTime());
        } catch (ParseException ex) {

        }
        series1.set(e, 34);
        series1.set(d, 64);
        series1.set(c, 34);
        series1.set(b, 36);
        series1.set(a, 87);



        lineModel.addSeries(series1);

    }

    
  
    
    
}
