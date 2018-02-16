package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.stream.Stream;

public class Donut extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Misanthrope's Donut");
        primaryStage.getIcons().add(new Image("/donutIcon.png"));

        GridPane gridPane = new GridPane();
        //gridPane.setGridLinesVisible(true);

        gridPane.setHgap(15);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 0, 20, 0));

        Text welcome = new Text("Пончик мизантропа на вахте");
        gridPane.add(welcome, 5, 1, 3, 1);
        welcome.setId("welcome-text");

        Text workBegins = new Text("Начало вахты");
        gridPane.add(workBegins, 1, 2);

        final DatePicker startDatePicker = new DatePicker();
        gridPane.add(startDatePicker, 2, 2, 1, 1);

        Text workFinish = new Text("Свобода");
        gridPane.add(workFinish, 1, 3);

        final DatePicker finishDatePicker = new DatePicker();
        gridPane.add(finishDatePicker, 2, 3, 1, 1);

        Text period = new Text("Срок");
        gridPane.add(period, 1, 4);

        Text daysNum = new Text("0 дней");
        gridPane.add(daysNum, 2, 4);

        Text commentsOut = new Text(); // Needs CSS Styling
        commentsOut.setId("commentsOut");
        gridPane.add(commentsOut, 5, 21);

        HashMap<Integer, String> comments = new HashMap<>();
        comments.put(1, "День 1: Ура!!!!! Как я соскучился!\nКак я рад вас всех видеть!");
        comments.put(2, "День 2: Э-э-э.... А меня что, не в 1.1.1. поселили?\nНадо поговорить с Ярославом.");
        comments.put(3, "День 3: На интересной работе и сны интересные видишь ;)");
        comments.put(4, "День 4: Так, надо начать ходить в спортзал!");
        comments.put(5, "День 5: Кофе, только кофе спасет отца русской демократии");
        comments.put(6, "День 6: А откуда столько новых людей?");
        comments.put(7, "День 7: А что, кофе-машину ещё не починили?");
        comments.put(8, "День 8: У нас что, коферум один что ли?");
        comments.put(9, "День 9: Пойду выложу в коферум все пончики,\nкоторые я набрал в столовке с начала вахты,\nможет людей поменьше туда ходить будет. ");
        comments.put(10, "День 10: Блин, ещё больше народу!\nИ пончики кончились (");
        comments.put(11, "День 11: Спортзал, ты меня всё ещё ждешь?");
        comments.put(12, "День 12: Ну когда там экватор-то?");
        comments.put(13, "День 13: Интересно, а есть жизнь после экватора? ");
        comments.put(14, "День 14: Ненавижу этих уродов, уезжающих на межвахту\n с их самодовольными улыбочками.");
        comments.put(15, "День 15: Экватор!");
        comments.put(16, "День 16: Ну, кажется, свет в конце тоннеля!");
        comments.put(17, "День 17: Только выдержка поможет\nвыжить в мире идиотов!  ");
        comments.put(18, "День 18: Окружающие всё больше и больше раздражают.");
        comments.put(19, "День 19: Интересно, если просто отвернуться\nот собеседника, он поймет, что я с ним не хочу общаться?");
        comments.put(20, "День 20: Почему-то во время совещаний начинаешь\nрисоватьв блокноте изощрённые орудия убийства.");
        comments.put(21, "День 21: А Брейвик-то, оказывается, неплохой парень,\nпросто его все достали.");
        comments.put(22, "День 22: Кашляющие и чихающие люди в офисе\nточно подлежат уничтожению.");
        comments.put(23, "День 23: Ну почему мне отказали на заявку\nстерилизовать офис, когда люди будут внутри :((");
        comments.put(24, "День 24: Я думаю начать только с самых\nнадоедливых и громких, я же не изверг\nи не собираюсь устраивать геноцид.");
        comments.put(25, "День 25: СРАНАЯ КОФЕМАШИНА!!!!!!!!\nКОГДА ТЫ БУДЕШЬ РАБОТАТЬ!!!!!");
        comments.put(26, "День 26: Ремонтник сказал, что если не бить по кнопкам\nмолотком, то машина проработает дольше.\nМне кажется, такие люди не имеют права жить :((");
        comments.put(27, "День 27: Оказывается, по политике нашей\nслужбы безопасности, на Сабетту нельзя\nпровозить автомат Калашникова.");
        comments.put(28, "День 28: Так, все приготовления сделаны, осталось\nтолько найти место где зарыть трупы\nи можно начинать УХА-ХА-ХА-ХА!!!!!");
        comments.put(29, "День 29: Домооооооой!\nКак говорится, \"Goodbye, Motherfuckers!!!\"");
        comments.put(30, "День 30: Домооооооой!\nКак говорится, \"Goodbye, Motherfuckers!!!\"");

        // BLOCK OF CALCULATION OUTPUT "ОТМУЧИЛСЯ"
        Text pastSuffer = new Text("Отмучился");
        pastSuffer.setId("pastSuffer");
        gridPane.add(pastSuffer, 1, 7, 2, 1);

        Text pastSufferWeeksText = new Text("Недель");
        gridPane.add(pastSufferWeeksText,2, 8);
        Text pastSufferWeeksNum = new Text("0,0");
        gridPane.add(pastSufferWeeksNum, 1, 8);

        Text pastSufferDaysText = new Text("Дней");
        gridPane.add(pastSufferDaysText,2, 9);
        Text pastSufferDaysNum = new Text("0,0");
        gridPane.add(pastSufferDaysNum, 1, 9);

        Text pastSufferHoursText = new Text("Часов");
        gridPane.add(pastSufferHoursText,2, 10);
        Text pastSufferHoursNum = new Text("0,0");
        gridPane.add(pastSufferHoursNum, 1, 10);

        Text pastSufferMinutesText = new Text("Минут");
        gridPane.add(pastSufferMinutesText,2, 11);
        Text pastSufferMinutesNum = new Text("0,0");
        gridPane.add(pastSufferMinutesNum, 1, 11);

        Text pastSufferSecondsText = new Text("Секунд");
        gridPane.add(pastSufferSecondsText,2, 12);
        Text pastSufferSecondsNum = new Text("0,0");
        gridPane.add(pastSufferSecondsNum, 1, 12);

        // BLOCK OF CALCULATION OUTPUT "ЕЩЕ СТРАДАТЬ"
        Text futureSuffer = new Text("Еще страдать");
        futureSuffer.setId("futureSuffer");
        gridPane.add(futureSuffer,1, 14, 2, 1);

        Text futureSufferWeeksText = new Text("Недель");
        gridPane.add(futureSufferWeeksText,2, 15);
        Text futureSufferWeeksNum = new Text("0,0");
        gridPane.add(futureSufferWeeksNum, 1, 15);

        Text futureSufferDaysText = new Text("Дней");
        gridPane.add(futureSufferDaysText,2, 16);
        Text futureSufferDaysNum = new Text("0,0");
        gridPane.add(futureSufferDaysNum, 1, 16);

        Text futureSufferHoursText = new Text("Часов");
        gridPane.add(futureSufferHoursText,2, 17);
        Text futureSufferHoursNum = new Text("0,0");
        gridPane.add(futureSufferHoursNum, 1, 17);

        Text futureSufferMinutesText = new Text("Минут");
        gridPane.add(futureSufferMinutesText,2, 18);
        Text futureSufferMinutesNum = new Text("0,0");
        gridPane.add(futureSufferMinutesNum, 1, 18);

        Text futureSufferSecondsText = new Text("Секунд");
        gridPane.add(futureSufferSecondsText,2, 19);
        Text futureSufferSecondsNum = new Text("0,0");
        gridPane.add(futureSufferSecondsNum, 1, 19);

        // PIE CHART ADDITION
        ObservableList<PieChart.Data> diagram = FXCollections.observableArrayList(
                new PieChart.Data("Отмучился", 1),
                new PieChart.Data("Еще страдать", 2));
        final PieChart chart = new PieChart(diagram);
        gridPane.add(chart, 5, 6, 1, 15);

        Label caption = new Label("");
        gridPane.add(caption, 0,0);

                Button calculate = new Button("Считаем");
        HBox hbCalcBtn = new HBox(10);
        gridPane.add(hbCalcBtn, 1, 5, 1, 1);
        hbCalcBtn.getChildren().add(calculate);
        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) throws NullPointerException{
                LocalDate dateOne = startDatePicker.getValue();
                LocalDate dateTwo = finishDatePicker.getValue();

                if (dateOne == null || dateTwo == null || /*totalPeriod == 0 ||*/
                        (dateOne == null & dateTwo == null)){
                    commentsOut.setText("Укажите дату начала и дату конца вахты!");
                    commentsOut.setFill(Color.RED);
                    commentsOut.setTextAlignment(TextAlignment.CENTER);
                    return;
                }

                long totalPeriod = ChronoUnit.DAYS.between(dateOne, dateTwo);
                double daysPassed = ChronoUnit.DAYS.between(dateOne, LocalDate.now());
                    String daysPassedRightFormat = String.format("%.2f", daysPassed);
                double weeksPassed = daysPassed / 7;
                    String weeksPassedRightFormat = String.format("%.4f", weeksPassed);
                double hoursPassed = daysPassed * 24;
                    String hoursPassedRightFormat = String.format("%.2f", hoursPassed);
                double minutesPassed = hoursPassed * 60;
                    String minutesPassedRightFormat = String.format("%.2f", minutesPassed);
                double secondsPassed = minutesPassed * 60;
                    String secondsPasedRightFormat = String.format("%.2f", secondsPassed);

                double daysTilltheEnd = ChronoUnit.DAYS.between(LocalDate.now(), dateTwo);
                    String daysTilltheEndRightFormat = String.format("%.2f", daysTilltheEnd);
                double weeksTilltheEnd = daysTilltheEnd / 7;
                    String weeksTIlltheEndRightFormat = String.format("%.4f", weeksTilltheEnd);
                double hoursTilltheEnd = daysTilltheEnd * 24;
                    String hoursTilltheEndRightFormat = String.format("%.2f", hoursTilltheEnd);
                double minutesTilltheEnd = hoursTilltheEnd * 60;
                    String minutesTilltheEndRightFormat = String.format("%.2f", minutesTilltheEnd);
                double secondsTilltheEnd = minutesTilltheEnd * 60;
                    String secondsTilltheEndRIghtFormat = String.format("%.2f", secondsTilltheEnd);

                // BLOCK OF CALCULATION OUTPUT "ОТМУЧИЛСЯ"
                pastSufferWeeksNum.setText(weeksPassedRightFormat);
                pastSufferDaysNum.setText(daysPassedRightFormat);
                pastSufferHoursNum.setText(hoursPassedRightFormat);
                pastSufferMinutesNum.setText(minutesPassedRightFormat);
                pastSufferSecondsNum.setText(secondsPasedRightFormat);

                // BLOCK OF CALCULATION OUTPUT "ЕЩЕ СТРАДАТЬ"
                futureSufferWeeksNum.setText(weeksTIlltheEndRightFormat);
                futureSufferDaysNum.setText(daysTilltheEndRightFormat);
                futureSufferHoursNum.setText(hoursTilltheEndRightFormat);
                futureSufferMinutesNum.setText(minutesTilltheEndRightFormat);
                futureSufferSecondsNum.setText(secondsTilltheEndRIghtFormat);

                int daysPassedFormatNeeded = (int)daysPassed;
                daysNum.setText(Long.toString(totalPeriod) + " дней");
                commentsOut.setText(comments.get(daysPassedFormatNeeded));
                commentsOut.setFill(Color.BLACK);
                commentsOut.setTextAlignment(TextAlignment.CENTER);

diagram.setAll(new PieChart.Data("Отмучился", daysPassed),
        new PieChart.Data("Еще страдать", daysTilltheEnd));

                if(dateTwo.isBefore(LocalDate.now())){
                    finishDatePicker.setValue(null);
                    daysNum.setText("0 дней");

                    // BLOCK OF CALCULATION OUTPUT "ОТМУЧИЛСЯ"
                    pastSufferWeeksNum.setText("0,0");
                    pastSufferDaysNum.setText("0,0");
                    pastSufferHoursNum.setText("0,0");
                    pastSufferMinutesNum.setText("0,0");
                    pastSufferSecondsNum.setText("0,0");

                    // BLOCK OF CALCULATION OUTPUT "ЕЩЕ СТРАДАТЬ"
                    futureSufferWeeksNum.setText("0,0");
                    futureSufferDaysNum.setText("0,0");
                    futureSufferHoursNum.setText("0,0");
                    futureSufferMinutesNum.setText("0,0");
                    futureSufferSecondsNum.setText("0,0");

                    diagram.setAll(new PieChart.Data("Отмучился", 1),
                            new PieChart.Data("Еще страдать", 2));

                    commentsOut.setText("Дата окончания вахты\nне может быть раньше текущей даты!");
                    commentsOut.setFill(Color.RED);
                    commentsOut.setTextAlignment(TextAlignment.CENTER);

                } else if (dateTwo.isBefore(dateOne)){
                    finishDatePicker.setValue(null);
                    daysNum.setText("0 дней");

                    // BLOCK OF CALCULATION OUTPUT "ОТМУЧИЛСЯ"
                    pastSufferWeeksNum.setText("0,0");
                    pastSufferDaysNum.setText("0,0");
                    pastSufferHoursNum.setText("0,0");
                    pastSufferMinutesNum.setText("0,0");
                    pastSufferSecondsNum.setText("0,0");

                    // BLOCK OF CALCULATION OUTPUT "ЕЩЕ СТРАДАТЬ"
                    futureSufferWeeksNum.setText("0,0");
                    futureSufferDaysNum.setText("0,0");
                    futureSufferHoursNum.setText("0,0");
                    futureSufferMinutesNum.setText("0,0");
                    futureSufferSecondsNum.setText("0,0");

                    diagram.setAll(new PieChart.Data("Отмучился", 1),
                            new PieChart.Data("Еще страдать", 2));

                    commentsOut.setText("Дата окончания вахты\nне может быть раньше даты начала!");
                    commentsOut.setFill(Color.RED);
                    commentsOut.setTextAlignment(TextAlignment.CENTER);

                } else if(dateOne.isAfter(LocalDate.now()) & dateTwo.isAfter(dateOne)){

                    double daysTillStart = ChronoUnit.DAYS.between(LocalDate.now(), dateOne);
                        String daysTillStartRightFormat = String.format("%.2f", daysTillStart);
                    double weeksTillStart = daysTillStart / 7;
                        String weeksTillStartRightFormat = String.format("%.4f", weeksTillStart);
                    double hoursTillStart = daysTillStart * 24;
                        String hoursTillStartRightFormat = String.format("%.2f", hoursTillStart);
                    double minutesTillStart = hoursTillStart * 60;
                        String minutesTillStartRightFormat = String.format("%.2f", minutesTillStart);
                    double secondsTillStart = minutesTillStart * 60;
                        String secondsTillStartRightFormat = String.format("%.2f", secondsTillStart);

                    double daysTilltheEndFuture = ChronoUnit.DAYS.between(dateOne, dateTwo);
                        String daysTilltheEndFutureRightFormat = String.format("%.2f", daysTilltheEndFuture);
                    double weeksTilltheEndFuture = daysTilltheEnd / 7;
                        String weeksTIlltheEndFutureRightFormat = String.format("%.4f", weeksTilltheEndFuture);
                    double hoursTilltheEndFuture = daysTilltheEnd * 24;
                        String hoursTilltheEndFutureRightFormat = String.format("%.2f", hoursTilltheEndFuture);
                    double minutesTilltheEndFuture = hoursTilltheEnd * 60;
                        String minutesTilltheEndFutureRightFormat = String.format("%.2f", minutesTilltheEndFuture);
                    double secondsTilltheEndFuture = minutesTilltheEnd * 60;
                     String secondsTilltheEndFutureRIghtFormat = String.format("%.2f", secondsTilltheEndFuture);

                    pastSuffer.setText("До начала мучений осталось");


                    // BLOCK OF CALCULATION OUTPUT "ДО НАЧАЛА МУЧЕНИЙ ОСТАЛОСЬ"
                    pastSufferWeeksNum.setText(weeksTillStartRightFormat);
                    pastSufferDaysNum.setText(daysTillStartRightFormat);
                    pastSufferHoursNum.setText(hoursTillStartRightFormat);
                    pastSufferMinutesNum.setText(minutesTillStartRightFormat);
                    pastSufferSecondsNum.setText(secondsTillStartRightFormat);

                    futureSuffer.setText("Ты будешь страдать");

                    // BLOCK OF CALCULATION OUTPUT "ТЫ БУДЕШЬ СТРАДАТЬ"
                    futureSufferWeeksNum.setText(weeksTIlltheEndFutureRightFormat);
                    futureSufferDaysNum.setText(daysTilltheEndFutureRightFormat);
                    futureSufferHoursNum.setText(hoursTilltheEndFutureRightFormat);
                    futureSufferMinutesNum.setText(minutesTilltheEndFutureRightFormat);
                    futureSufferSecondsNum.setText(secondsTilltheEndFutureRIghtFormat);

                    diagram.setAll(new PieChart.Data("Отмучился", 1),
                            new PieChart.Data("Еще страдать", 2));
                    commentsOut.setText("");
                }

                if (totalPeriod > 30){
                    commentsOut.setText("Как правило, срок вахты не превышает 30 дней");
                    commentsOut.setTextAlignment(TextAlignment.CENTER);
                }


            }});

        Button clear = new Button("Очистить");
        HBox hbClrBtn = new HBox(10);
        gridPane.add(hbClrBtn, 2, 5, 1, 1);
        hbClrBtn.getChildren().add(clear);
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startDatePicker.setValue(null);
                finishDatePicker.setValue(null);

                daysNum.setText("0 дней");
                pastSuffer.setText("Отмучился");

                // BLOCK OF CALCULATION OUTPUT "ОТМУЧИЛСЯ"
                pastSufferWeeksNum.setText("0,0");
                pastSufferDaysNum.setText("0,0");
                pastSufferHoursNum.setText("0,0");
                pastSufferMinutesNum.setText("0,0");
                pastSufferSecondsNum.setText("0,0");

                futureSuffer.setText("Еще страдать");
                // BLOCK OF CALCULATION OUTPUT "ЕЩЕ СТРАДАТЬ"
                futureSufferWeeksNum.setText("0,0");
                futureSufferDaysNum.setText("0,0");
                futureSufferHoursNum.setText("0,0");
                futureSufferMinutesNum.setText("0,0");
                futureSufferSecondsNum.setText("0,0");

                diagram.setAll(new PieChart.Data("Отмучился", 1),
                        new PieChart.Data("Еще страдать", 2));

                commentsOut.setText("");
            }});

        // SCENE & STAGE START
        Scene scene = new Scene(gridPane, 1000, 700);
        primaryStage.setScene(scene);
        scene.getStylesheets().add("Donut.css");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
