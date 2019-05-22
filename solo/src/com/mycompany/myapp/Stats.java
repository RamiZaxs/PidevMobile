/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.Entite.User;
import com.mycompany.Service.ServiceUser;
import com.mycompany.gui.ProfileForm;
import com.mycompany.gui.SelectPays;
import java.io.IOException;

/**
 *
 * @author lazre
 */
public class Stats {
    
    Form f;

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public Container getCn() {
        return cn;
    }

    public void setCn(Container cn) {
        this.cn = cn;
    }
    Container cn;
    
    public Stats() {
    
      f = new Form("Répartition", new FlowLayout(CENTER, CENTER));
       f.getToolbar().addMaterialCommandToRightBar("Profil", FontImage.MATERIAL_ACCOUNT_CIRCLE, (e)->{
                              try {
                                  ProfileForm i=new ProfileForm();
                                  i.getF().show();      } catch (IOException ex) {
                                    System.out.println(ex.getMessage());
                              }
        });
        cn = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        createPieChartForm(cn);
        f.add(cn);
        
}
        
    public DefaultRenderer buildCategoryRenderer(int[] colors) {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(15);
        renderer.setLegendTextSize(15);
        renderer.setMargins(new int[]{20, 30, 15, 0});
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }

    /**
     * Builds a category series using the provided values.
     *
     * @param titles the series titles
     * @param values the values
     * @return the category series
     */
    
    
    
    protected CategorySeries buildCategoryDataset(String title, double[] values) {
        CategorySeries series = new CategorySeries(title);
            series.add(SelectPays.pays1.getText(), values[0]);
            series.add(SelectPays.pays2.getText(), values[1]);
            series.add(SelectPays.pays3.getText(), values[2]);
            series.add(SelectPays.pays4.getText(), values[3]);
            series.add("Reste du monde", values[4]);
        

        return series;
    }

    public void createPieChartForm(Container cn) {

        // Generate the values
        double[] values = new double[]{nbEventParLieu(SelectPays.pays1.getText()), nbEventParLieu(SelectPays.pays2.getText()), nbEventParLieu(SelectPays.pays3.getText()), nbEventParLieu(SelectPays.pays4.getText()), nbEventParLieu_1()};

        // Set up the renderer
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.GRAY, ColorUtil.CYAN};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(20);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setGradientEnabled(true);
        r.setGradientStart(0, ColorUtil.BLUE);
        r.setGradientStop(0, ColorUtil.GREEN);
        r.setHighlighted(true);

        // Create the chart ... pass the values and renderer to the chart object.
        PieChart chart = new PieChart(buildCategoryDataset("Project budget", values), renderer);

        // Wrap the chart in a Component so we can add it to a form
        ChartComponent c = new ChartComponent(chart);

       
        // Create a form and show it.
        cn.add( c);
                
    }
    
    
    public int nbEventParLieu(String lieu)
    {
        int nb=0;
        ServiceUser es=new ServiceUser();
        for(User e:es.getList2())
        {
                                     if(e.getRole().equals("[ROLE_PARTICIPANT, ROLE_USER]")){
            System.out.println(e);

            if(e.getPays().equals(lieu))
                nb++;
        }}
        return nb;
    }
        public int nbEventParLieu_1()
    {
        int nb=0;
        ServiceUser es=new ServiceUser();
        for(User e:es.getList2())
        {
                         if(e.getRole().equals("[ROLE_PARTICIPANT]")){

            if((e.getPays().equals(SelectPays.pays1.getText())==false)&&(e.getPays().equals(SelectPays.pays2.getText())==false)&&(e.getPays().equals(SelectPays.pays3.getText())==false)&&(e.getPays().equals(SelectPays.pays4.getText())==false))
                nb++;
                         }
        }
        return nb;
    }
    
}
