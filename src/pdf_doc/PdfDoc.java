package pdf_doc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfDoc
{
  private String fileName, title, author, content;
  private Document document1;
  
  public PdfDoc(String fileNameIn, String titleIn, String authorIn, String contentIn)
  {
    fileName = fileNameIn;
    title = titleIn;
    author = authorIn;
    content = contentIn;
    createPDF();
  }
  
  private void createPDF()
  {
    document1 = new Document();
    try
    {
      PdfWriter.getInstance(document1, new FileOutputStream(fileName + ".pdf"));
    } 
    catch (FileNotFoundException e)
    {
      System.out.println("FileNotFoundException");// TODO Auto-generated catch block
      e.printStackTrace();
    } 
    catch (DocumentException e)
    {
      System.out.println("DocumentException while creating document");// TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    document1.open();
    try
    {
      document1.add(new Phrase("Title: " + title + "\n",
          FontFactory.getFont(FontFactory.HELVETICA, (float) 18, 
              Font.BOLD, new BaseColor(0, 0, 0))));
      document1.add(new Phrase("Author: " + author + "\n\n",
          FontFactory.getFont(FontFactory.HELVETICA, (float) 14, 
              Font.BOLD, new BaseColor(0, 0, 0))));
      document1.add(new Paragraph(content));
    } 
    catch (DocumentException e)
    {
      System.out.println("DocumentException while adding text items");
      e.printStackTrace();
    }
    document1.close();
  }
  
  //PUBLIC METHODS
  public void updateContent(String contentIn)//recreates/overwrites PDF doc, with updated contents
  {
    content  = contentIn;
    createPDF();
  }
  public void updateTitle(String titleIn)//recreates/overwrites PDF doc, with updated title
  {
    title  = titleIn;
    createPDF();
  }
  public void updateAuthor(String authorIn)//recreates/overwrites PDF doc, with updated author
  {
    author  = authorIn;
    createPDF();
  }
}
