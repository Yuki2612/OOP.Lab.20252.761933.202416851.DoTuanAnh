package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.exception.PlayerException;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, 
                    "Sản phẩm \"" + media.getTitle() + "\" đã được thêm thành công vào giỏ hàng!", 
                    "Thêm vào giỏ hàng", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });
        container.add(btnAddToCart);
        
        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ((Playable) media).play();
                        JOptionPane.showMessageDialog(null, 
                            "Đang phát sản phẩm: " + media.getTitle() + "\nThời lượng: " + ((Disc) media).getLength() + " min", 
                            "Cửa sổ phát Media (AIMS)", 
                            JOptionPane.INFORMATION_MESSAGE);
                    } catch (PlayerException ex) {
                        JOptionPane.showMessageDialog(null, 
                            ex.getMessage(), 
                            "Illegal DVD Length", 
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            container.add(btnPlay);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}