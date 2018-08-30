/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.service.DashbordService;
import com.service.DashbordServiceImp;
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
    DashbordService service;
    private int visitCount = 0;
    private int transactionCount = 0;
    private int userCount = 0;
    private int questionCount = 0;
    private int packageCount = 0;
    
    private PieChartModel pieModel;
    private int countAllUser;
    private LineChartModel lineModel;
    @PostConstruct
    public void init() {
        initLinearModel();
        initPieModel();
    }

    public chartBean() {
        service = new DashbordServiceImp();
        visitCount = service.countVisits();
        transactionCount = service.countTransaction();
        userCount = service.countUsers();
        questionCount = service.countQuestion();
        packageCount = service.countPackage();
    }
   

    public int getPackageCount() {
        return packageCount;
    }

    public void setPackageCount(int packageCount) {
        this.packageCount = packageCount;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
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
        LineChartSeries series2 = new LineChartSeries();
        LineChartSeries series3 = new LineChartSeries();
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
        series1.setLabel("فروش");
        series1.set(e, service.getListofSell(4));
        series1.set(d, service.getListofSell(3));
        series1.set(c, service.getListofSell(2));
        series1.set(b, service.getListofSell(1));
        series1.set(a, service.getListofSell(0));
        
        series2.setLabel("بازدید");
        series2.set(e, service.getListofVisit(4));
        series2.set(d, service.getListofVisit(3));
        series2.set(c, service.getListofVisit(2));
        series2.set(b, service.getListofVisit(1));
        series2.set(a, service.getListofVisit(0));

        series3.setLabel("کاربر جدید");
        series3.set(e, service.getListofUsers(4));
        series3.set(d, service.getListofUsers(3));
        series3.set(c, service.getListofUsers(2));
        series3.set(b, service.getListofUsers(1));
        series3.set(a, service.getListofUsers(0));


        lineModel.addSeries(series1);
        lineModel.addSeries(series2);
        lineModel.addSeries(series3);

    }

    
  
    
    
}
