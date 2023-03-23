package com.thucnobita.tmonitor.entity.order;

public class Discount
extends ItemXML {
 private String lineGuid;
 private int state;
 private String guid;
 private long amount;
 private String cardCode;

 public String getCardCode() {
     return this.cardCode;
 }

 public void setCardCode(String cardCode) {
     this.cardCode = cardCode;
 }

 public String getLineGuid() {
     return this.lineGuid;
 }

 public void setLineGuid(String lineGuid) {
     this.lineGuid = lineGuid;
 }

 public int getState() {
     return this.state;
 }

 public void setState(int state) {
     this.state = state;
 }

 public String getGuid() {
     return this.guid;
 }

 public void setGuid(String guid) {
     this.guid = guid;
 }

 public long getAmount() {
     return this.amount;
 }

 public void setAmount(long amount) {
     this.amount = amount;
 }
}
