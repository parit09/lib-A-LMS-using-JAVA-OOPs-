package com.lms.Model;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class BorrowOnline {
	public void borrowOnline(String Path)
	{
		String filePath = Path;

        // Load the PDF document
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            if (!document.isEncrypted()) {
                PDFTextStripper pdfStripper = new PDFTextStripper();
                String text = pdfStripper.getText(document);
                System.out.println(text);
            } else {
                System.out.println("The document is encrypted and cannot be read.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
