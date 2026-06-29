// Document Interface
interface Document {
    void open();
}

// Word Document
class WordDocument implements Document {
    public void open() {
        System.out.println("Opening Word Document");
    }
}

// PDF Document
class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF Document");
    }
}

// Excel Document
class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening Excel Document");
    }
}

// Abstract Factory
abstract class DocumentFactory {
    public abstract Document createDocument();
}

// Word Factory
class WordFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

// PDF Factory
class PdfFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

// Excel Factory
class ExcelFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}

// Test Class
public class FactoryMethodPattern {

    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        DocumentFactory pdfFactory = new PdfFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        DocumentFactory excelFactory = new ExcelFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}
