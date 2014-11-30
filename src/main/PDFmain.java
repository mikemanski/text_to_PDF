package main;

import pdf_doc.PdfDoc;

public class PDFmain//This is a Demo of using the PdfDoc class
{
  public static void main(String[] args)
  {
    //ctr: PdfDoc(String fileNameIn, String titleIn, String authorIn, String contentIn) 
    String contents = "This week’s assignment is mostly related to the lab assignment. This part of the lab"
                      + " assignment should be handed in individually. The goal is to make sure everyone gets"
                      + " familiar with magnetic levitation system and its nonlinear SIMULINK model.";
    
    //Makes a PDF in the project's folder
    PdfDoc pdfDoc1 = new PdfDoc("summarized_old_man_and_the_sea", "Old Man and the Sea", "Ernest Hemingway", contents);
    
    //Using the public methods:
    pdfDoc1.updateAuthor("Ernest Hemingway Jr.");
    pdfDoc1.updateContent(contents + "\n\nMore Updated content");
    pdfDoc1.updateTitle("Old Man and the Sea v2");
  }
  
}
