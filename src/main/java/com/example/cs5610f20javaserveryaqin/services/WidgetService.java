package com.example.cs5610f20javaserveryaqin.services;

import com.example.cs5610f20javaserveryaqin.models.Widget;
import com.example.cs5610f20javaserveryaqin.repositories.WidgetRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository widgetRepository;

  public List<Widget> findWidgetsForTopic(String tid) {
    return widgetRepository.findWidgetsForTopic(tid);
  }


  public List<Widget> findAllWidgets() {
    return (List<Widget>) widgetRepository.findAll();
  }

  public Widget findWidgetById(Integer widgetId) {
    Optional widgetO = widgetRepository.findById(widgetId);
    if (widgetO.isPresent()) {
      return (Widget) widgetO.get();
    } else return null;
  }

  public Widget createWidget(Widget widget) {
    return widgetRepository.save(widget);
  }
  public Widget updateWidget(
      Integer widgetId,
      Widget newWidget) {
    Optional widgetO = widgetRepository.findById(widgetId);
    if (widgetO.isPresent()) {
      Widget widget = (Widget) widgetO.get();
      widget.setName(newWidget.getName());
      widget.setType(newWidget.getType());
      widget.setWidgetOrder(newWidget.getWidgetOrder());
      widget.setSize(newWidget.getSize());
      widget.setText(newWidget.getText());
      widget.setSrc(newWidget.getSrc());
      widget.setListOrder(newWidget.getListOrder());
      return widgetRepository.save(widget);
    } else {
      return null;
    }
  }

  public Integer deleteWidget(Integer wid) {
    Optional widgetO = widgetRepository.findById(wid);
    if (widgetO.isPresent()) {
      widgetRepository.deleteById(wid);
      return 1;
    } else return 0;
  }
}
