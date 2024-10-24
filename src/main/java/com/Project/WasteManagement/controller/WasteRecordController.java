// package com.Project.WasteManagement.controller;

// import com.Project.WasteManagement.model.WasteRecord;
// import com.Project.WasteManagement.repository.WasteRecordRepository;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/waste-records")
// public class WasteRecordController {

//     private final Logger logger = LoggerFactory.getLogger(WasteRecordController.class);

//     @Autowired
//     private WasteRecordRepository wasteRecordRepository;

//     @GetMapping
//     public List<WasteRecord> getAllWasteRecords() {
//         logger.info("Fetching all waste records");
//         return wasteRecordRepository.findAll();
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<WasteRecord> getWasteRecordById(@PathVariable Long id) {
//         logger.info("Fetching waste record with ID: " + id);
//         return wasteRecordRepository.findById(id)
//                 .map(wasteRecord -> ResponseEntity.ok().body(wasteRecord))
//                 .orElse(ResponseEntity.notFound().build());
//     }

//     @PostMapping
//     public WasteRecord createWasteRecord(@RequestBody WasteRecord wasteRecord) {
//         logger.info("Creating new waste record: " + wasteRecord.getWasteType());
//         return wasteRecordRepository.save(wasteRecord);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<WasteRecord> updateWasteRecord(@PathVariable Long id, @RequestBody WasteRecord wasteRecordDetails) {
//         logger.info("Updating waste record with ID: " + id);
//         return wasteRecordRepository.findById(id).map(wasteRecord -> {
//             wasteRecord.setWasteType(wasteRecordDetails.getWasteType());
//             wasteRecord.setQuantity(wasteRecordDetails.getQuantity());
//             return ResponseEntity.ok(wasteRecordRepository.save(wasteRecord));
//         }).orElse(ResponseEntity.notFound().build());
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteWasteRecord(@PathVariable Long id) {
//         logger.info("Deleting waste record with ID: " + id);
//         if (wasteRecordRepository.existsById(id)) {
//             wasteRecordRepository.deleteById(id);
//             return ResponseEntity.noContent().build();
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }
// }
