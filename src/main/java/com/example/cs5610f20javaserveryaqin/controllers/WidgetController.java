package com.example.cs5610f20javaserveryaqin.controllers;

import com.example.cs5610f20javaserveryaqin.models.Widget;
import com.example.cs5610f20javaserveryaqin.services.WidgetService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
  @Autowired
  WidgetService service;

  @GetMapping("/api/topics/{topicId}/widgets")
  public List<Widget> findWidgetsForTopic(
      @PathVariable("topicId") String topicId) {
    return service.findWidgetsForTopic(topicId);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }

  @GetMapping("/api/widgets/{wid}")
  public Widget findWidgetById(
      @PathVariable("wid") Integer widgetId) {
    return service.findWidgetById(widgetId);
  }

  @PostMapping("/api/widgets")
  public Widget createWidget(
      @RequestBody Widget widget) {
    return service.createWidget(widget);
  }

  @PutMapping("/api/widgets/{wid}")
  public Widget updateWidget(
      @PathVariable("wid") Integer widgetId,
      @RequestBody Widget newWidget) {
    return service.updateWidget(widgetId, newWidget);
  }

  @DeleteMapping("/api/widgets/{wid}")
  public Integer deleteWidget(
      @PathVariable("wid") Integer widgetId) {
    return service.deleteWidget(widgetId);
  }
}