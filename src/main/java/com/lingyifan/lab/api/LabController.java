package com.lingyifan.lab.api;
import com.lingyifan.lab.api.LabDtos.*; import com.lingyifan.lab.domain.*; import com.lingyifan.lab.service.LabService; import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api") public class LabController {
 private final LabService lab; public LabController(LabService lab){this.lab=lab;}
 @PostMapping("/equipment") @ResponseStatus(HttpStatus.CREATED) Equipment add(@Valid @RequestBody EquipmentInput in){return lab.add(in);} @GetMapping("/equipment") List<Equipment> equipment(){return lab.equipment();}
 @PostMapping("/reservations") @ResponseStatus(HttpStatus.CREATED) Reservation reserve(@Valid @RequestBody ReservationInput in){return lab.reserve(in);} @GetMapping("/reservations") List<Reservation> reservations(){return lab.reservations();}
 @PatchMapping("/reservations/{id}/review") Reservation review(@PathVariable Long id,@Valid @RequestBody ReviewInput in){return lab.review(id,in);} @PostMapping("/reservations/{id}/checkout") Reservation checkout(@PathVariable Long id){return lab.checkOut(id);} @PostMapping("/reservations/{id}/return") Reservation back(@PathVariable Long id){return lab.returnBack(id);}
 @PostMapping("/repairs") @ResponseStatus(HttpStatus.CREATED) RepairOrder report(@Valid @RequestBody RepairInput in){return lab.report(in);} @GetMapping("/repairs") List<RepairOrder> repairs(){return lab.repairs();} @PatchMapping("/repairs/{id}/resolve") RepairOrder resolve(@PathVariable Long id,@Valid @RequestBody ResolveInput in){return lab.resolve(id,in);}
 @GetMapping("/dashboard") Map<String,Object> dashboard(){return lab.dashboard();}
}
