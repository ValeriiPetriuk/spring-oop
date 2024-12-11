package com.oop.practice.contoller;

import com.oop.practice.dto.InspectionDTO;
import com.oop.practice.entity.Inspection;
import com.oop.practice.exception.ErrorResponseInspection;
import com.oop.practice.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/inspection")
public class InspectionController {
    @Autowired
    private InspectionService inspectionService;
    @PostMapping
    public ResponseEntity<InspectionDTO> createInspection(@RequestBody InspectionDTO inspectionDTO) {
        Inspection inspection = inspectionService.convertToEntity(inspectionDTO);
        Inspection savedInspection = inspectionService.save(inspection);
        return ResponseEntity.status(HttpStatus.CREATED).body(inspectionService.convertToDto(savedInspection));
    }

    @GetMapping
    public List<Inspection> getAllInspection(){
        return inspectionService.getAllInspection();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InspectionDTO> getInspectionById(@PathVariable int id) {
        InspectionDTO product = inspectionService.getInspectionById(id);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InspectionDTO> updateInspection(@PathVariable int id, @RequestBody InspectionDTO inspectionDTO) {
        InspectionDTO updatedProduct = inspectionService.updateInspection(id, inspectionDTO);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInspection(@PathVariable int id) {
        inspectionService.deleteInspection(id);
        return ResponseEntity.ok().body(Map.of("status", "success", "message", "Lesson deleted successfully"));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponseInspection> handleRuntimeException(RuntimeException e) {
        ErrorResponseInspection errorResponse = new ErrorResponseInspection(e.getMessage(), HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }


}
