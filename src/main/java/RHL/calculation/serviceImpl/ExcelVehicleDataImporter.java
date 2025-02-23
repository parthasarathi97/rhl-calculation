package RHL.calculation.serviceImpl;

import RHL.calculation.model.VehicleDetails;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

@Service
public class ExcelVehicleDataImporter {
    @Autowired
    private VehicleDetailsService vehicleDetailsService;

    public void importExcelData(String filePath) {
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            if (!rowIterator.hasNext()) {
                System.out.println("Excel file is empty.");
                return;
            }

            // Read Header Row and Map Column Names to Indexes
            Row headerRow = rowIterator.next();
            Map<String, Integer> columnIndexes = new HashMap<>();
            for (Cell cell : headerRow) {
                columnIndexes.put(cell.getStringCellValue().trim(), cell.getColumnIndex());
            }

            // Expected Headers in the Excel File (Modify If Needed)
            List<String> requiredHeaders = Arrays.asList(
                    "Vehicle Type", "Vehicle Segment", "Description", "Length of container (in feet)",
                    "Width of container (in feet)", "Max load capacity(ton)",
                    "Pallet adjustment in Length", "Pallet adjustment in Width", "Pallet space in vehicle",
                    "Free Space in Length", "Free Space in Width", "vehicleMillage", "palletPrice", "palletMaxLoad(kg)"
            );

            // Ensure All Required Headers Are Present
            for (String header : requiredHeaders) {
                if (!columnIndexes.containsKey(header)) {
                    System.out.println("Missing column in Excel: " + header);
                    return;
                }
            }

            // Read Data Rows
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                VehicleDetails vehicle = new VehicleDetails();

                vehicle.setVehicleType(getCellValue(row, columnIndexes.get("Vehicle Type")));
                vehicle.setVehicleSegment(getCellValue(row, columnIndexes.get("Vehicle Segment")));
                vehicle.setDescription(getCellValue(row, columnIndexes.get("Description")));
                vehicle.setLengthOfContainer(getCellValue(row, columnIndexes.get("Length of container (in feet)")));
                vehicle.setWidthOfContainer(getCellValue(row, columnIndexes.get("Width of container (in feet)")));
                vehicle.setMaxLoadCapacity(getCellValue(row, columnIndexes.get("Max load capacity(ton)")));
                vehicle.setPalletSizeWidth("4"); // Default value
                vehicle.setPalletSizeHeight("3"); // Default value
                vehicle.setPalletAdjustmentLength(getCellValue(row, columnIndexes.get("Pallet adjustment in Length")));
                vehicle.setPalletAdjusmentWidth(getCellValue(row, columnIndexes.get("Pallet adjustment in Width")));
                vehicle.setPalletSpaceInVehicle(getCellValue(row, columnIndexes.get("Pallet space in vehicle")));
                vehicle.setFreeSpaceInLength(getCellValue(row, columnIndexes.get("Free Space in Length")));
                vehicle.setFreeSpaceInWidth(getCellValue(row, columnIndexes.get("Free Space in Width")));
                vehicle.setVehicleMillage(getCellValue(row, columnIndexes.get("vehicleMillage")));
                vehicle.setPalletPrice(getCellValue(row, columnIndexes.get("palletPrice")));
                vehicle.setPalletMaxLoad(getCellValue(row, columnIndexes.get("palletMaxLoad(kg)")));

                vehicleDetailsService.saveOrUpdateVehicle(vehicle);
            }

            System.out.println("Excel data imported successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getCellValue(Row row, Integer columnIndex) {
        if (columnIndex == null) return ""; // Handle missing columns safely
        Cell cell = row.getCell(columnIndex);

        if (cell == null) {
            return "";
        }

        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue().trim();
            case NUMERIC -> formatNumericValue(cell.getNumericCellValue()); // Convert numeric values properly
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> evaluateFormulaCell(cell); // Handle formulas correctly
            default -> "";
        };
    }

    private String evaluateFormulaCell(Cell cell) {
        try {
            FormulaEvaluator evaluator = cell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
            CellValue cellValue = evaluator.evaluate(cell);
            return switch (cellValue.getCellType()) {
                case STRING -> cellValue.getStringValue().trim();
                case NUMERIC -> formatNumericValue(cellValue.getNumberValue()); // Convert properly
                case BOOLEAN -> String.valueOf(cellValue.getBooleanValue());
                default -> "";
            };
        } catch (Exception e) {
            e.printStackTrace();
            return cell.toString(); // Fallback to formula string if evaluation fails
        }
    }

    private String formatNumericValue(double number) {
        if (number == (long) number) {
            return String.valueOf((long) number); // Convert to long if there's no decimal part
        } else {
            return String.valueOf(number); // Keep decimal part if present
        }
    }
}
