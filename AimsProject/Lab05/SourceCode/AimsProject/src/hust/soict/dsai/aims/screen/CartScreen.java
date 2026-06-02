package hust.soict.dsai.aims.screen;

import java.io.IOException;
import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super();
        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        Cart cart = new Cart();

        cart.addMedia(new DigitalVideoDisc("The Matrix", "Sci-Fi", "Wachowskis", 136, 19.99f));
        cart.addMedia(new Book("Clean Code", "Technology", 45.50f));
        cart.addMedia(new DigitalVideoDisc("Đĩa Lỗi", "Action", "Test", -10, 19.99f));
        
        CompactDisc cd = new CompactDisc("Chillies Album", "Pop", 12.0f, 32, "Chillies", "Chillies");
        cd.addTrack(new Track("Vung Ky Uc", 4));
        cart.addMedia(cd);

        new CartScreen(cart);
    }
}