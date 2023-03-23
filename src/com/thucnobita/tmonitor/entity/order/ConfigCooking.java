package com.thucnobita.tmonitor.entity.order;

import java.util.List;

import com.thucnobita.tmonitor.entity.kds.GroupTypeKds;

public class ConfigCooking {
 private long id;
 private String menuItemCode;
 private Long placeId;
 private Long singleCookingTime;
 private Long multiCookingTime;
 private Long maxMultiCookingDish;
 private Long fasting;
 private GroupTypeKds groupTypeKds;
 private List<Long> placeIds;
 private int delayTime;

 public List<Long> getPlaceIds() {
     return this.placeIds;
 }

 public void setPlaceIds(List<Long> placeIds) {
     this.placeIds = placeIds;
 }

 public long getId() {
     return this.id;
 }

 public void setId(long id) {
     this.id = id;
 }

 public String getMenuItemCode() {
     return this.menuItemCode;
 }

 public void setMenuItemCode(String menuItemCode) {
     this.menuItemCode = menuItemCode;
 }

 public Long getPlaceId() {
     return this.placeId;
 }

 public void setPlaceId(Long placeId) {
     this.placeId = placeId;
 }

 public Long getSingleCookingTime() {
     return this.singleCookingTime;
 }

 public void setSingleCookingTime(Long singleCookingTime) {
     this.singleCookingTime = singleCookingTime;
 }

 public Long getMultiCookingTime() {
     return this.multiCookingTime;
 }

 public void setMultiCookingTime(Long multiCookingTime) {
     this.multiCookingTime = multiCookingTime;
 }

 public Long getMaxMultiCookingDish() {
     return this.maxMultiCookingDish;
 }

 public void setMaxMultiCookingDish(Long maxMultiCookingDish) {
     this.maxMultiCookingDish = maxMultiCookingDish;
 }

 public GroupTypeKds getGroupTypeKds() {
     return this.groupTypeKds;
 }

 public void setGroupTypeKds(GroupTypeKds groupTypeKds) {
     this.groupTypeKds = groupTypeKds;
 }

 public Long getFasting() {
     return this.fasting;
 }

 public void setFasting(Long fasting) {
     this.fasting = fasting;
 }

 public int getDelayTime() {
     return this.delayTime;
 }

 public void setDelayTime(int delayTime) {
     this.delayTime = delayTime;
 }
}

