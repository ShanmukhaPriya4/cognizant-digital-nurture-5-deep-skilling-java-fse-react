// Interface
interface Document {
    void open();
}

// Concrete Document Classes
class WordDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening Word Document...");
    }
}

class PdfDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening PDF Document...");
    }
}

class ExcelDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening Excel Document...");
    }
}

// Abstract Factory
abstract class DocumentFactory {
    public abstract Document createDocument();
}

// Concrete Factories
class WordDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

// Main Class
public class FactoryTest {

    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordDocumentFactory();
        Document word = wordFactory.createDocument();
        word.open();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdf = pdfFactory.createDocument();
        pdf.open();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excel = excelFactory.createDocument();
        excel.open();
    }
}