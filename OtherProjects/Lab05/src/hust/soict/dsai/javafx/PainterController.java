package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color color = Color.BLACK;
        int radius = 4;
        
        // Mục 4.4: Nếu nút Eraser được chọn, đổi màu mực trùng màu nền trắng và tăng size để dễ tẩy
        if (eraserRadioButton.isSelected()) {
            color = Color.WHITE;
            radius = 16;
        }

        Circle newCircle = new Circle(event.getX(), event.getY(), radius, color);
        drawingAreaPane.getChildren().add(newCircle);
    }
}