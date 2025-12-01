package designpatterns.creational;

/* Design pattern - FactoryMethod
* Real-world usage:
* - Payment gateways (PaymentFactory → MercadoPago, Stripe, PayPal).
* - Database connectors (ConnectionFactory → MySQL, PostgreSQL).
* - UI components (ButtonFactory → WindowsButton, MacButton).
*
* Key points:
* - Product interface (Document) → defines the common behavior.
* - Concrete products (WordDocument, PdfDocument) → actual implementations.
* - Creator (DocumentFactory) → declares the factory method.
* - Concrete factories (WordDocumentFactory, PdfDocumentFactory) → decide which product to create.
* - Client → works with the factory, not with new directly.
* */

// Product interface
interface Document {
    void open();
}

// Concrete products
class WordDocument implements Document {
    public void open() {
        System.out.println("Opening Word document...");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF document...");
    }
}

// Creator abstract class
abstract class DocumentFactory {
    public abstract Document createDocument();
}

// Concrete factories
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

// Client
public class FactoryMethodEx {
    public static void main(String[] args) {
        // Choose factory dynamically
        DocumentFactory factory = new WordDocumentFactory();
        Document doc1 = factory.createDocument();
        doc1.open();

        factory = new PdfDocumentFactory();
        Document doc2 = factory.createDocument();
        doc2.open();
    }
}

