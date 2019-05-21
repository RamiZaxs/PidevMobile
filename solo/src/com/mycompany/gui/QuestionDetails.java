/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.facebook.ui.LikeButton;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;

import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entite.CategorieQuestion;
import com.mycompany.Entite.Question;
import com.mycompany.Service.QuestionService;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author bhk
 */
public class QuestionDetails {

    Form f;
    Image i;
    ImageViewer iv;
    ArrayList<CategorieQuestion> QuestionS = new ArrayList();
    public QuestionDetails() {
        
    }

    public void ShowQuestion(Question q)
    {
        TextArea QuestionLabel=new TextArea(q.getQuestion());
        QuestionLabel.setEditable(false);
        SpanLabel TexteLabel=new SpanLabel(q.getTexte());
        f = new Form(new BoxLayout(BoxLayout.Y_AXIS));
        f.getToolbar().addCommandToLeftBar("Ajouter Question", null, (ev)->{HomeFormForum h=new HomeFormForum();
            h.getF().show();
          });
        f.getToolbar().addCommandToRightBar("Retour", null, (ev)->{AffichageForum a=new AffichageForum();
            a.getF().show();
          });
        QuestionLabel.getAllStyles().setFgColor(4359924);
        Font largeBoldProportionalFont = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE);
        QuestionLabel.getAllStyles().setFont(largeBoldProportionalFont);
        Button supp=new Button("Supprimer Question");
        f.add(QuestionLabel);
        f.add(TexteLabel);
        f.add(supp);
        f.add(createPieChartForm());
        supp.addActionListener((e)->{
            QuestionService qs=new QuestionService();
            qs.deleteQuestion(q);
            Dialog.show("Succes","Question supprimée","ok", null);
            });
    }
    
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    private DefaultRenderer buildCategoryRenderer(int[] colors) {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(25);
        renderer.setLegendTextSize(25);
        renderer.setLabelsColor(30000);
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
        int k = 0;
        QuestionService qst=new QuestionService();
        QuestionS=qst.getStats();
        ArrayList<String> Name = new ArrayList();
        
        for(CategorieQuestion q: QuestionS)
            {
                Name.add(q.getNom());
            }
                int i=0;
                for (double value : values) { 
                    System.out.println("================");
                    series.add(Name.get(i+1), value);
                    i--;
                }
        
        return series;
    }

    public ChartComponent createPieChartForm() {

        // Generate the values
        QuestionService qst=new QuestionService();
        QuestionS=qst.getStats();
        int values1 = 0;
        int values2 = 0;
        double[] valuesF = null;
        for(CategorieQuestion q: QuestionS)
        {
            
            if(q.getNom().equals("Mobile"))
            {
                values1 =q.getId();

            }
            if(q.getNom().equals("Java")) 
            {
                values2 =q.getId();

            }
        }
        
        //System.out.println("================"+values1+values2);
        valuesF = new double[]{values1,values2};

        // Set up the renderer
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.MAGENTA};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setChartTitleTextSize(25);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        // Create the chart ... pass the values and renderer to the chart object.
        PieChart chart = new PieChart(buildCategoryDataset("Project budget", valuesF), renderer);

        // Wrap the chart in a Component so we can add it to a form
        ChartComponent c = new ChartComponent(chart);
        return c;
    }

}

