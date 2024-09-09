package com.faykris.ecommerce.Report;

import com.faykris.ecommerce.Product.Product;
import com.faykris.ecommerce.Product.ProductRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ReportService {

  @Autowired
  private ProductRepository productRepository;

  public ReportService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public ByteArrayInputStream exportAvailableProductsToExcel() throws IOException {
    List<Product> products = productRepository.findByStatus(1);

    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
      Sheet sheet = workbook.createSheet("Products");

      Row headerRow = sheet.createRow(0);
      headerRow.createCell(0).setCellValue("Id");
      headerRow.createCell(1).setCellValue("Nombre");
      headerRow.createCell(2).setCellValue("Precio");
      headerRow.createCell(3).setCellValue("Descripción");
      headerRow.createCell(4).setCellValue("Codigo Producto");

      int rowCount = 1;
      for (Product product : products) {
        Row row = sheet.createRow(rowCount++);
        row.createCell(0).setCellValue(product.getId());
        row.createCell(1).setCellValue(product.getName());
        row.createCell(2).setCellValue(product.getPrice());
        row.createCell(3).setCellValue(product.getDescription());
        row.createCell(4).setCellValue(product.getProductCode());
      }

      workbook.write(out);
      return new ByteArrayInputStream(out.toByteArray());
    }
  }

}
