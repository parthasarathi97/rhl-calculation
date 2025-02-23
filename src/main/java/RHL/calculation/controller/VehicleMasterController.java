package RHL.calculation.controller;

import RHL.calculation.serviceImpl.ExcelVehicleDataImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/calculation")
public class VehicleMasterController {
    @Autowired
    private ExcelVehicleDataImporter excelVehicleDataImporter;

    @PostMapping("/upload")
    public String uploadExcel(@RequestParam("file") MultipartFile file) {
        try {
            // Save file temporarily
            File tempFile = new File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
            try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                fos.write(file.getBytes());
            }

            // Process file
            excelVehicleDataImporter.importExcelData(tempFile.getAbsolutePath());

            return "File uploaded and data imported successfully.";
        } catch (IOException e) {
            return "Failed to process file: " + e.getMessage();
        }
    }
}
