package service.models;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class GenerateExcelReport {
    public static ByteArrayInputStream usersToExcel(List<Order> orders) throws IOException {
        String[] COLUMNs = { "Дата", "Время от", "Время до", "Заказ", "Заказчик",
                "Телефон заказчика", "Получатель", "Телефон получателя", "Адрес",
                "Способ оплаты", "Курьер", "Примечания", "Постер", "Статус оплаты"};
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Заказы");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            // Header Row
            Row headerRow = sheet.createRow(0);

            // Table Header
            for (int col = 0; col < COLUMNs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(COLUMNs[col]);
                cell.setCellStyle(headerCellStyle);
            }

            int rowIdx = 1;
            for (Order order : orders) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(order.getDate());
                row.createCell(1).setCellValue(order.getTimeFrom());
                row.createCell(2).setCellValue(order.getTimeTo());
                row.createCell(3).setCellValue(order.getOrderList());
                row.createCell(4).setCellValue(order.getCustomer());
                row.createCell(5).setCellValue(order.getCustomerNumberCode() + order.getCustomerNumber());
                row.createCell(6).setCellValue(order.getReceiver());
                row.createCell(7).setCellValue(order.getReceiverNumberCode() + order.getReceiverNumber());
                row.createCell(8).setCellValue(order.getStreet()
                        + " д." + order.getHouse()
                        + " пд." + order.getPorch()
                        + " эт." + order.getFloor()
                        + " кв." + order.getFlat());
                row.createCell(9).setCellValue(order.getPaymentMethod());
                row.createCell(10).setCellValue(order.getCourier());

                row.createCell(11).setCellValue(order.getNotes());

                if(order.getPoster())
                    row.createCell(12).setCellValue("Да");
                else
                    row.createCell(12).setCellValue("Нет");

                if(order.getPayStatus())
                    row.createCell(13).setCellValue("Оплачен");
                else
                    row.createCell(13).setCellValue("Не оплачен");

            }

            //Auto-size all the above columns
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            sheet.autoSizeColumn(7);
            sheet.autoSizeColumn(8);
            sheet.autoSizeColumn(9);
            sheet.autoSizeColumn(10);
            sheet.autoSizeColumn(11);
            sheet.autoSizeColumn(12);
            sheet.autoSizeColumn(13);

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}
