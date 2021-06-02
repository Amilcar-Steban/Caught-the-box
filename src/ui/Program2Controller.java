package ui;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import model.LoadingBar;
import model.game;
import Threads.ProgressBarThread;

public class Program2Controller implements Initializable {

    private final double POSX1 = 130.0;
    private final double POSY1 = 132.0;

    private final double POSX2 = 268.0;
    private final double POSY2 = 132.0;

    private final double POSX3 = 409.0;
    private final double POSY3 = 132.0;

    private final double POSX4 = 130.0;
    private final double POSY4 = 240.0;

    private final double POSX5 = 268.0;
    private final double POSY5 = 240.0;

    private final double POSX6 = 409.0;
    private final double POSY6 = 240.0;

    private boolean activity;
    @FXML
    private Pane load;
    @FXML
    private Pane juego;
    @FXML
    private Label lbPuntaje;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button mole;
    @FXML
    private BorderPane mainPanel;
    @FXML
    private Label txtPercent;
    @FXML
    private Rectangle loadBarShape;

    game g = new game();
    private LoadingBar loadBar;

    public Program2Controller() {
        loadBar = new LoadingBar();
        activity = false;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comenzar();
    }

    @FXML
    private void btnReiniciar(ActionEvent event) {
        g.setPuntaje(0);
        lbPuntaje.setText("" + g.getPuntaje());
    }

    @FXML
    private void btnInicio(ActionEvent event) throws IOException {
        activity = true;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pane.fxml"));

        fxmlLoader.setController(this);
        Parent loginPane = fxmlLoader.load();

        mainPanel.getChildren().clear();
        mainPanel.setCenter(inicio);
        g.setPuntaje(0);
        lbPuntaje.setText("" + g.getPuntaje());

    }

    @FXML
    private void ActionMole(ActionEvent event) {
        g.sum(1);
        lbPuntaje.setText("" + g.getPuntaje());

    }

    public int positions(int random) {
        double posX1 = btn1.getLayoutX();
        double posy1 = btn1.getLayoutY();

        double posX2 = btn2.getLayoutX();
        double posy2 = btn2.getLayoutY();

        double posX3 = btn3.getLayoutX();
        double posy3 = btn3.getLayoutY();

        double posX4 = btn4.getLayoutX();
        double posy4 = btn4.getLayoutY();

        double posX5 = btn5.getLayoutX();
        double posy5 = btn5.getLayoutY();

        double posX6 = btn6.getLayoutX();
        double posy6 = btn6.getLayoutY();

        switch (random) {

            case 1:
                mole.setLayoutX(posX1);
                mole.setLayoutY(posy1);

                return 0;

            case 2:
                mole.setLayoutX(posX2);
                mole.setLayoutY(posy2);

                return 1;

            case 3:
                mole.setLayoutX(posX3);
                mole.setLayoutY(posy3);

                return 2;

            case 4:
                mole.setLayoutX(posX4);
                mole.setLayoutY(posy4);

                return 3;

            case 5:
                mole.setLayoutX(posX5);
                mole.setLayoutY(posy5);

                return 4;

            case 6:
                mole.setLayoutX(posX6);
                mole.setLayoutY(posy6);

                return 5;
        }
        return -1;

    }

    public int randomSelection() {
        Random aleatorio = new Random();
        int n = aleatorio.nextInt(6);
        return n;
    }

    public Timer comenzar() {

        Timer time = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                if (activity == true) {
                    time.cancel();
                    time.purge();
                } else {
                    int num = randomSelection();
                    int pos = positions(num);
                    moleToHole(num);
                }

            }

        };

        time.schedule(tarea, 0, 1000);

        return time;
    }

    public void moleToHole(int random) {
        double posX1 = POSX1;
        double posy1 = POSY1;

        double posX2 = POSX2;
        double posy2 = POSY2;

        double posX3 = POSX3;
        double posy3 = POSY3;

        double posX4 = POSX4;
        double posy4 = POSY4;

        double posX5 = POSX5;
        double posy5 = POSY5;

        double posX6 = POSX6;
        double posy6 = POSY6;

        switch (random) {

            case 1:
                btn1.setLayoutX(posX1);
                btn1.setLayoutY(posy1);

            case 2:
                btn2.setLayoutX(posX2);
                btn2.setLayoutY(posy2);

            case 3:
                btn3.setLayoutX(posX3);
                btn3.setLayoutY(posy3);

            case 4:
                btn4.setLayoutX(posX4);
                btn4.setLayoutY(posy4);

            case 5:
                btn5.setLayoutX(posX5);
                btn5.setLayoutY(posy5);

            case 6:
                btn6.setLayoutX(posX6);
                btn6.setLayoutY(posy6);
        }

    }
    @FXML
    private Pane inicio;

    public void firsh() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pane.fxml"));

        fxmlLoader.setController(this);
        Parent loginPane = fxmlLoader.load();

        mainPanel.getChildren().clear();
        mainPanel.setCenter(inicio);
    }

    @FXML
    public void btncomenzar(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loadingInterface.fxml"));

        fxmlLoader.setController(this);

        Parent loginPane = fxmlLoader.load();

        mainPanel.getChildren().clear();
        mainPanel.setCenter(load);

        loadBar.setActive(true);
        new ProgressBarThread(loadBar, this).start();
        activity = false;
    }

    public void go() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("program2.fxml"));

        fxmlLoader.setController(this);

        Parent loginPane = fxmlLoader.load();

        mainPanel.getChildren().clear();
        mainPanel.setCenter(juego);
        comenzar();

    }

    public void updateBar() {
        txtPercent.setText((int) (loadBar.getProgressLevel() / (2.12)) + "%");
        loadBarShape.setWidth((int) loadBar.getProgressLevel());
        if (loadBar.isActive() == false) {
            try {
                go();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
