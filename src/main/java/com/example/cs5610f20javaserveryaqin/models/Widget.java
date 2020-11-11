package com.example.cs5610f20javaserveryaqin.models;

public class Widget {
  private String name;
  private String id;
  private String type;
  private Integer widgetOrder;
  private String text;
  //private String src;
  private String size;
  private final String topicId;
//  private Integer width;
//  private Integer height;


  public Widget(String name, String id, String type, Integer widgetOrder, String text,
      String size, String topicId) {
    this.name = name;
    this.id =id;
    this.type = type;
    this.widgetOrder = widgetOrder;
    this.text = text;
    this.size = size;
    this.topicId = topicId;
  }

  public String getName() {
    return this.name;
  }

  public String getId() {
    return this.id;
  }

  public String getType() {
    return this.type;
  }

  public Integer getWidgetOrder() {
    return this.widgetOrder;
  }

  public String getText() {
    return this.text;
  }

  public String getTopicId() {
    return this.topicId;
  }

  public String getSize() {
    return this.size;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setWidgetOrder(Integer widgetOrder) {
    this.widgetOrder = widgetOrder;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setSize(String size) {
    this.size = size;
  }

}
