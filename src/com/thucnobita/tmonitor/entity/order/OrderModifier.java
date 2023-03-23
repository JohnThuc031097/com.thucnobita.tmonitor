package com.thucnobita.tmonitor.entity.order;

public class OrderModifier {
 private long id;
 private String lineGuid;
 private Modifier modifier;
 private long uni;
 private long price;
 private long count;

 public OrderModifier() {
 }

 public OrderModifier(String code, int count, long price) {
     this.modifier = new Modifier(code);
     this.count = count;
     this.price = price;
 }

 public OrderModifier(Modifier modifier, int count, long price) {
     this.modifier = modifier;
     this.count = count;
     this.price = price;
 }

 public long getId() {
     return this.id;
 }

 public void setId(long id) {
     this.id = id;
 }

 public long getPrice() {
     return this.price;
 }

 public void setPrice(long price) {
     this.price = price;
 }

 public long getCount() {
     return this.count;
 }

 public void setCount(long count) {
     this.count = count;
 }

 public Modifier getModifier() {
     return this.modifier;
 }

 public void setModifier(Modifier modifier) {
     this.modifier = modifier;
 }

 public String getLineGuid() {
     return this.lineGuid;
 }

 public void setLineGuid(String lineGuid) {
     this.lineGuid = lineGuid;
 }

 public long getUni() {
     return this.uni;
 }

 public void setUni(long uni) {
     this.uni = uni;
 }
}
