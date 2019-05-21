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
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.mycompany.Entite.Event;
import com.mycompany.Entite.Review;
import com.mycompany.Service.EvenementService;
import com.mycompany.Service.reviewService;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Oussema-PC
 */
public class AfficherEvenement {

    Form f;
    ImageViewer iv;
    Image i;
    Image istar;
    ImageViewer ivstar;
    int current_uid = 3;
    int current_eid;
    Event CurrentEvent;

    public AfficherEvenement() {
        f = new Form("Les événements", new BoxLayout(BoxLayout.Y_AXIS));

        ArrayList<Event> EvenementL = new ArrayList();
        EvenementService cs = new EvenementService();
        EvenementL = cs.getList3();
        for (Event e : EvenementL) {
            Container co;
            co = new Container(new BoxLayout(BoxLayout.X_AXIS));
            try {

                i = Image.createImage("/event.png").scaled(60, 60);
                iv = new ImageViewer(i);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            Label nomEventLabel = new Label(e.getName());
            Label typeEventLabel = new Label(e.getEventtype());

            co.add(iv);

            Container eve;
            eve = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            eve.add(nomEventLabel);
            eve.add(typeEventLabel);
            co.add(eve);
            //  co.add(lbd);
            f.add(co);

            iv.addPointerReleasedListener((ActionListener) (ActionEvent evt) -> {
                showEvent(e);
            });
            nomEventLabel.addPointerReleasedListener((ActionListener) (ActionEvent evt) -> {
                showEvent(e);
            });
        }

    }

    public void showEvent(Event e) {
        CurrentEvent = e;
        reviewService rs1 = new reviewService();
        try {
            istar = Image.createImage("/stars.png").scaled(50, 50);
            ivstar = new ImageViewer(istar);

        } catch (IOException ex) {

        }
        float f1 = (float) rs1.avgReview(e.getId());
        f1 = f1 * 100;
        f1 = (int) f1;
        f1 = f1 / 100;
        Label lrating = new Label(String.valueOf(f1));

        current_eid = e.getId();
        Form hi2 = new Form(e.getName(), BoxLayout.y());
        SpanLabel sl = new SpanLabel(e.getDescription());
        Container co1;
        co1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container cco1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        SpanLabel lieu1 = new SpanLabel("Etat : " + e.getEtat());
        SpanLabel lieu2 = new SpanLabel(" Ville : " + e.getVille());
        SpanLabel lieu3 = new SpanLabel(" Adresse : " + e.getAdresse());
        SpanLabel space = new SpanLabel();
        cco1.add(lieu1);
        cco1.add(lieu2);
        cco1.add(lieu3);
        cco1.add(space);
        try {
            Image i3 = Image.createImage("/lieu.png").scaled(50, 50);
            ImageViewer iv3 = new ImageViewer(i3);

            co1.add(iv3);
            co1.add(cco1);

        } catch (IOException ex) {
        }
        Container co2;
        co2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        SpanLabel nbr = new SpanLabel(e.getCapacity() - e.getReserved() + "  Places disponibles");
        try {
            Image i4 = Image.createImage("/nbrplace.png").scaled(40, 40);
            ImageViewer iv4 = new ImageViewer(i4);
            co2.add(iv4);
            co2.add(nbr);
        } catch (IOException ex) {
        }
        Container co3;
        co3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        SpanLabel date = new SpanLabel(e.getDate());
        try {
            Image i5 = Image.createImage("/logoevent.png").scaled(50, 50);
            ImageViewer iv5 = new ImageViewer(i5);
            co3.add(iv5);
            co3.add(date);
        } catch (IOException ex) {
        }

        Container co4;
        co4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label prix1 = new Label();
        if (e.isFree()) {
            prix1.setText(" GRATUIT");
        } else {
            prix1.setText(e.getPrix() + "  TND");
        }
        try {
            Image i6 = Image.createImage("/prix.png").scaled(40, 40);
            ImageViewer iv6 = new ImageViewer(i6);
            co4.add(iv6);
            co4.add(prix1);
        } catch (IOException ex) {
        }
        Image i2;
        try {
            i2 = Image.createImage("/event.png").scaled(100, 100);
            ImageViewer iv2 = new ImageViewer(i2);
            hi2.add(iv2);
            Container cocos = new Container(new BoxLayout(BoxLayout.X_AXIS));
            cocos.add(lrating);
            cocos.add(ivstar);
            Container cstarrating = new Container(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
            cstarrating.add(BorderLayout.CENTER, cocos);
            hi2.add(cstarrating);
        } catch (IOException ex) {
        }

        hi2.add(sl);

        hi2.add(co3);
        hi2.add(co1);
        hi2.add(co2);
        hi2.add(co4);
        
        
             reviewService rs = new reviewService();
        //mail api
        Button Bmail = new Button("Mail us!");
        Bmail.addActionListener((evt) -> {
            Message m = new Message("");
            m.getAttachments().put("conf", "text/plain");
            Display.getInstance().sendMessage(new String[]{"techevents.esprit.pidev@gmail.com"}, "", m);
        });
        hi2.add(Bmail);

        //mail api
        //stats api
        if (current_uid == CurrentEvent.getIdorganisateur()) {
           
            if (rs.getReviewList(current_eid).size() > 0) {
                Button Bstat = new Button("stats reviews");
                hi2.add(Bstat);
                Bstat.addActionListener((evt) -> {
                    Form F = createPieChartForm(current_eid);
                    F.getToolbar().addCommandToLeftBar("Retour", null, s -> hi2.showBack());
                    F.show();
                });
            }
        }
        //stats api

        hi2.getToolbar().addCommandToLeftBar("Retour", null, s -> f.showBack());
        hi2.getToolbar().addCommandToRightBar("rate", null, (evt) -> {
            Dialog d = new Dialog("rate");
            d.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            d.setDefaultBlurBackgroundRadius(8);
            Slider s = createStarRankSlider();
            Review R = new Review(0, s.getProgress(), current_uid, current_eid);
            System.out.println(rs.getExistingReview(R).getRate());
            if (rs.exists(R)) {
                s.setProgress(rs.getExistingReview(R).getRate());

                System.err.println(s.getProgress());
            }

            s.addActionListener((evtt) -> {
                System.out.println(s.getProgress());
                if (s.getProgress() > 5) {
                    s.setProgress(5);
                }
            });
            Command[] cmds = new Command[2];
            cmds[0] = new Command("Confirmer") {
                public void actionPerformed(ActionEvent evt) {
                    if(s.getProgress()>0){
                    Review R = new Review(0, s.getProgress(), current_uid, current_eid);
                    reviewService rs = new reviewService();
                    rs.doIT(R);}
                }
                
            };
            cmds[1] = new Command("Annuler") {
                public void actionPerformed(ActionEvent evt) {
                    d.dispose();
                }
            };

            d.show("rate", FlowLayout.encloseCenter(s), cmds);

            //d.show();
        });

        hi2.show();
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    private void initStarRankStyle(Style s, Image star) {
        s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
        s.setBorder(Border.createEmpty());
        s.setBgImage(star);
        s.setBgTransparency(0);
    }

    private Slider createStarRankSlider() {
        Slider starRank = new Slider();
        starRank.setEditable(true);
        starRank.setMinValue(1);
        starRank.setMaxValue(6);
        Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
                derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
        Style s = new Style(0xffff33, 0, fnt, (byte) 0);
        Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        s.setOpacity(100);
        s.setFgColor(0);
        Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
        initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
        starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
        return starRank;
    }

    private DefaultRenderer buildCategoryRenderer(int[] colors) {
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
        int k = 0;
        for (double value : values) {
            k++;
            if (value > 0) {
                series.add("Rating " + k, value);
            }
        }

        return series;
    }

    public Form createPieChartForm(int id) {
        // Generate the values
        reviewService rs = new reviewService();
        double[] values = rs.stats(id);

        // Set up the renderer
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(20);
        renderer.setDisplayValues(true);
        renderer.setLabelsColor(0);
        renderer.setShowLabels(true);

        /*SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
    r.setGradientEnabled(true);
    r.setGradientStart(0, ColorUtil.BLUE);
    r.setGradientStop(0, ColorUtil.GREEN);
    r.setHighlighted(true);*/
        // Create the chart ... pass the values and renderer to the chart object.
        PieChart chart = new PieChart(buildCategoryDataset("Rating", values), renderer);

        // Wrap the chart in a Component so we can add it to a form
        ChartComponent c = new ChartComponent(chart);

        // Create a form and show it.
        Form f = new Form("ratings", new BorderLayout());
        f.add(BorderLayout.CENTER, c);
        return f;

    }

}
