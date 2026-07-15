package com.lingyifan.lab.domain;
import com.baomidou.mybatisplus.annotation.*;
@TableName("equipment") public class Equipment {
 @TableId(type=IdType.AUTO) private Long id; private String assetCode; private String name; private String category; private String labRoom; private String status;
 public Equipment(){} public Equipment(Long id,String assetCode,String name,String category,String labRoom,String status){this.id=id;this.assetCode=assetCode;this.name=name;this.category=category;this.labRoom=labRoom;this.status=status;}
 public Long getId(){return id;} public void setId(Long v){id=v;} public String getAssetCode(){return assetCode;} public void setAssetCode(String v){assetCode=v;} public String getName(){return name;} public void setName(String v){name=v;} public String getCategory(){return category;} public void setCategory(String v){category=v;} public String getLabRoom(){return labRoom;} public void setLabRoom(String v){labRoom=v;} public String getStatus(){return status;} public void setStatus(String v){status=v;}
}
