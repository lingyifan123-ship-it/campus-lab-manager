package com.lingyifan.lab.api;
import jakarta.validation.constraints.*; import java.time.LocalDateTime;
public final class LabDtos {private LabDtos(){}
 public record EquipmentInput(@NotBlank String assetCode,@NotBlank String name,@NotBlank String category,@NotBlank String labRoom){}
 public record ReservationInput(@NotNull Long equipmentId,@NotNull Long studentId,@NotNull @Future LocalDateTime startAt,@NotNull LocalDateTime endAt,@NotBlank @Size(max=300) String purpose){}
 public record ReviewInput(@NotBlank @Pattern(regexp="APPROVED|REJECTED") String decision,@Size(max=300) String note){}
 public record RepairInput(@NotNull Long equipmentId,@NotNull Long reporterId,@NotBlank @Size(max=500) String description){}
 public record ResolveInput(@NotBlank @Size(max=500) String resolution){}
}
