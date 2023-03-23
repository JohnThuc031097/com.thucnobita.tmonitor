package com.thucnobita.tmonitor.entity;

import java.util.ArrayList;
import java.util.List;

public class COOrderCategory
extends COBaseItem {
 private String srcImg;
 private List<String> srcImgIntros;
 private int type;
 private List<String> menuGroupCodes = new ArrayList<String>();
 private String alacarte;
 private String buffet;
 private String drinks;
 private String alacarteEn;
 private String buffetEn;
 private String drinksEn;
 private List<String> srcVideoIntros;
 private int restaurantIntroLocation;
 private List<String> restaurantLstImg;
 private List<String> restaurantLstVideo;
 private long timeModify;
 private String srcImgMultiCategory;
 private String srcImgSingleCategory;
 private Integer averageAmount;
 private String note;
 private long ticketAdultAmount;
 private long ticketChildAmount;
 
 public COOrderCategory() {
     this.srcImgIntros = new ArrayList<String>();
     this.srcVideoIntros = new ArrayList<String>();
     this.restaurantLstImg = new ArrayList<String>();
     this.restaurantLstVideo = new ArrayList<String>();
     this.restaurantIntroLocation = 0;
     this.ticketAdultAmount = 0;
     this.ticketChildAmount = 0;
     this.alacarte = "";
     this.buffet = "";
     this.drinks = "";
     this.alacarteEn = "";
     this.buffetEn = "";
     this.drinksEn = "";
 }
 
 public long getTicketAdultAmount() {
     return this.ticketAdultAmount;
 }

 public void setTicketAdultAmount(long ticketAdultAmount) {
     this.ticketAdultAmount = ticketAdultAmount;
 }

 public long getTicketChildAmount() {
     return this.ticketChildAmount;
 }

 public void setTicketChildAmount(long ticketChildAmount) {
     this.ticketChildAmount = ticketChildAmount;
 }

 public long getTimeModify() {
     return this.timeModify;
 }

 public void setTimeModify(long timeModify) {
     this.timeModify = timeModify;
 }

 public int getRestaurantIntroLocation() {
     return this.restaurantIntroLocation;
 }

 public void setRestaurantIntroLocation(int restaurantIntroLocation) {
     this.restaurantIntroLocation = restaurantIntroLocation;
 }

 public List<String> getRestaurantLstImg() {
     return this.restaurantLstImg;
 }

 public void setRestaurantLstImg(List<String> restaurantLstImg) {
     this.restaurantLstImg = restaurantLstImg;
 }

 public List<String> getRestaurantLstVideo() {
     return this.restaurantLstVideo;
 }

 public void setRestaurantLstVideo(List<String> restaurantLstVideo) {
     this.restaurantLstVideo = restaurantLstVideo;
 }

 public List<String> getSrcVideoIntros() {
     return this.srcVideoIntros;
 }

 public void setSrcVideoIntros(List<String> srcVideoIntros) {
     this.srcVideoIntros = srcVideoIntros;
 }

 public String getAlacarteEn() {
     return this.alacarteEn;
 }

 public void setAlacarteEn(String alacarteEn) {
     this.alacarteEn = alacarteEn;
 }

 public String getBuffetEn() {
     return this.buffetEn;
 }

 public void setBuffetEn(String buffetEn) {
     this.buffetEn = buffetEn;
 }

 public String getDrinksEn() {
     return this.drinksEn;
 }

 public void setDrinksEn(String drinksEn) {
     this.drinksEn = drinksEn;
 }

 public String getAlacarte() {
     return this.alacarte;
 }

 public void setAlacarte(String alacarte) {
     this.alacarte = alacarte;
 }

 public String getBuffet() {
     return this.buffet;
 }

 public void setBuffet(String buffet) {
     this.buffet = buffet;
 }

 public String getDrinks() {
     return this.drinks;
 }

 public void setDrinks(String drinks) {
     this.drinks = drinks;
 }

 public List<String> getMenuGroupCodes() {
     return this.menuGroupCodes;
 }

 public void setMenuGroupCodes(List<String> menuGroupCodes) {
     this.menuGroupCodes = menuGroupCodes;
 }

 public String getSrcImg() {
     return this.srcImg;
 }

 public void setSrcImg(String srcImg) {
     this.srcImg = srcImg;
 }

 public int getType() {
     return this.type;
 }

 public void setType(int type) {
     this.type = type;
 }

 public List<String> getSrcImgIntros() {
     return this.srcImgIntros;
 }

 public void setSrcImgIntros(List<String> srcImgIntros) {
     this.srcImgIntros = srcImgIntros;
 }

 public String getSrcImgMultiCategory() {
     return this.srcImgMultiCategory;
 }

 public void setSrcImgMultiCategory(String srcImgMultiCategory) {
     this.srcImgMultiCategory = srcImgMultiCategory;
 }

 public String getSrcImgSingleCategory() {
     return this.srcImgSingleCategory;
 }

 public void setSrcImgSingleCategory(String srcImgSingleCategory) {
     this.srcImgSingleCategory = srcImgSingleCategory;
 }

 public Integer getAverageAmount() {
     return this.averageAmount;
 }

 public void setAverageAmount(Integer averageAmount) {
     this.averageAmount = averageAmount;
 }

 public String getNote() {
     return this.note;
 }

 public void setNote(String note) {
     this.note = note;
 }
}

