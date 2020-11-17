package com.example.cs5610f20javaserveryaqin.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "widgets")
public class Widget {
  private String name;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String type;
  private Integer widgetOrder;
  private String text;
  private String src;
  private String size;
  private String topicId;
  private String listOrder;

  public Widget(String name, Integer id, String type, Integer widgetOrder, String text,
      String size, String topicId, String src, String listOrder) {
    this.name = name;
    this.id =id;
    this.type = type;
    this.widgetOrder = widgetOrder;
    this.text = text;
    this.size = size;
    this.topicId = topicId;
    this.src= src;
    this.listOrder = listOrder;
  }

  public Widget() {
  }

  public String getListOrder() {
    return this.listOrder;
  }

  public String getSrc() {return this.src;}

  public String getName() {
    return this.name;
  }

  public Integer getId() {
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

  public void setSrc(String src) {
    this.src = src;
  }

  public void setId(Integer id) {
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

  public void setListOrder(String listOrder) {this.listOrder = listOrder;}

}
