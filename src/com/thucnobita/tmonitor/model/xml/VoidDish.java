package com.thucnobita.tmonitor.model.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(value=XmlAccessType.FIELD)
public class VoidDish {
 @XmlAttribute(name="id")
 private long id;
 @XmlAttribute(name="code")
 private String code;
 @XmlAttribute(name="name")
 private String name;
 @XmlAttribute(name="quantity")
 private double quantity;
 @XmlAttribute(name="line_guid")
 private String lineGuid;
 @XmlElement(name="Author")
 private EmployeeXML author;
 private boolean isPrinted;
 @XmlAttribute(name="openName")
 private String openName;
 private int touchKds;

 public int getTouchKds() {
     return this.touchKds;
 }

 public void setTouchKds(int touchKds) {
     this.touchKds = touchKds;
 }

 public String getOpenName() {
     return this.openName;
 }

 public void setOpenName(String openName) {
     this.openName = openName;
 }

 public long getId() {
     return this.id;
 }

 public void setId(long id) {
     this.id = id;
 }

 public String getCode() {
     return this.code;
 }

 public void setCode(String code) {
     this.code = code;
 }

 public String getName() {
     return this.name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public double getQuantity() {
     return this.quantity;
 }

 public void setQuantity(double quantity) {
     this.quantity = quantity;
 }

 public EmployeeXML getAuthor() {
     return this.author;
 }

 public void setAuthor(EmployeeXML author) {
     this.author = author;
 }

 public boolean isPrinted() {
     return this.isPrinted;
 }

 public void setPrinted(boolean isPrinted) {
     this.isPrinted = isPrinted;
 }

 public String getLineGuid() {
     return this.lineGuid;
 }

 public void setLineGuid(String lineGuid) {
     this.lineGuid = lineGuid;
 }
}

