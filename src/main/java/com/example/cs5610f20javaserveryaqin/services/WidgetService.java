package com.example.cs5610f20javaserveryaqin.services;

import com.example.cs5610f20javaserveryaqin.models.Widget;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WidgetService {
  List<Widget> widgets = new ArrayList<Widget>();
  {
    widgets.add(new Widget("test1", "Widget_123", "HEADING", 0,
        "this is a heading", "1", "topic1"));
    widgets.add(new Widget("test2", "Widget_234", "PARAGRAPH", 1,
        "this is a paragraph", "-1", "topic1"));
    widgets.add(new Widget("test3", "Widget_345", "HEADING", 0,
        "heading for topic2", "3", "topic2"));
  }

  public List<Widget> findWidgetsForTopic(String tid) {
    List<Widget> ws = new ArrayList<Widget>();
    for(Widget w: widgets) {
      if(w.getTopicId().equals(tid)) {
        ws.add(w);
      }
    }
    return ws;
  }
  public List<Widget> findAllWidgets() {
    return widgets;
  }
  public Widget findWidgetById(String widgetId) {
    for(Widget w: widgets) {
      if(w.getId().equals(widgetId))
        return w;
    }
    return null;
  }
  public Widget createWidget(Widget widget) {
    widget.setId((new Date()).toString() + widget.getWidgetOrder());
    widgets.add(widget);
    return widget;
  }
  public Integer updateWidget(
      String widgetId,
      Widget newWidget) {
    for(Widget w: widgets) {
      if(w.getId().equals(widgetId)) {
        // We can add some if conditions here.
        w.setName(newWidget.getName());
        w.setType(newWidget.getType());
        w.setWidgetOrder(newWidget.getWidgetOrder());
        w.setText(newWidget.getText());
        w.setSize(newWidget.getSize());
        return 1;
      }
    }
    return 0;
  }

  public Integer deleteWidget(String widgetId) {
    for (int i = 0; i < widgets.size(); i++) {
      if (widgets.get(i).getId().equals(widgetId)) {
        widgets.remove(widgets.get(i));
        return 1;
      }
    }
    return 0;
  }
}
