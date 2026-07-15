package com.lingyifan.lab.domain;
import com.baomidou.mybatisplus.annotation.*; import java.time.*;
@TableName("reservation") public class Reservation {
 @TableId(type=IdType.AUTO) private Long id; private Long equipmentId; private Long studentId; private LocalDateTime startAt; private LocalDateTime endAt; private String purpose; private String status; private String reviewNote; private LocalDateTime createdAt;
 public Reservation(){}
 public Long getId(){return id;} public void setId(Long v){id=v;} public Long getEquipmentId(){return equipmentId;} public void setEquipmentId(Long v){equipmentId=v;} public Long getStudentId(){return studentId;} public void setStudentId(Long v){studentId=v;} public LocalDateTime getStartAt(){return startAt;} public void setStartAt(LocalDateTime v){startAt=v;} public LocalDateTime getEndAt(){return endAt;} public void setEndAt(LocalDateTime v){endAt=v;} public String getPurpose(){return purpose;} public void setPurpose(String v){purpose=v;} public String getStatus(){return status;} public void setStatus(String v){status=v;} public String getReviewNote(){return reviewNote;} public void setReviewNote(String v){reviewNote=v;} public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime v){createdAt=v;}
}
