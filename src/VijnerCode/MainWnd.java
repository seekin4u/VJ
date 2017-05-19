/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VijnerCode;

import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text; //отказался в пользу Label - это дает вохможность записывать букву по коду символа, с Текстом такой штуки не получилось.
import javafx.stage.Stage;
import javafx.scene.control.Label;

/**
 *
 * @author IMM
 * Подробнее о шифре - https://ru.wikipedia.org/wiki/Шифр_Виженера
 * Многоалфавитный шифр замены, который работает за счет таблтцы Виженера
 * НЕ сложный проект, но это интереснее чем копировать чужой код
 * Или просто пытаться в нем замести следы того, что ргз не твое :^)
 */

/*
*Шифторекст - зашифрованный с помощью ключа текст
Ключ шифрования/ключ (code_key - в этом примере) - ключ, с пом. которого из шифротекста
получаем расшифрованное сообщение - текст/сообщение

пример шифрования -
сообщение - мне не нравится писать на джаве
ключ - требуют наши сердца

копируем ключ столько раз, сколько необходимо, что бы длина ключа была равной длине сообщения
обрезаем при надобности
прим :
мне не нравится писать на джаве
пер ем ентребую тнашис ер дцапе
i love write in java
w enee dchan ge swen
Находим букву М в строке, находим соответствующую ей букву п в столбце и смотрим на символ, который пересекают столбец и строка, и записываем его

получаем :

e pbzi *******
сопостовляем индекс буквы текста с индексом буквы в ключе, шифруем/дешифруем.
*/
public class MainWnd extends Application {
    public static final int wight = 600;
    public static final int heigth = 800;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MyApp");
        
        Label label = new Label("123");
        //primaryStage.add(label); //лэйбл нужно влепить слева сверху, или нед GridPane       
        
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        //Text scenetitle = new Text("Таблица Вижнера");
        //grid.add(scenetitle, 0, 0, 1, 1); // 0 строка и 0 столбец, промежуток мужду столбцами, промежуток между строками
        
        Label buffer_label = new Label("*");
        
        String buffer;
        
        int asci_char = 65;
        int asci_count = 0;
        
        String[][] vij_table = new String[27][27];
        
        for(int i = 0; i < 26; i ++){
            for(int j = 0; j< 26; j++)
            {
                buffer = Character.toString((char) (asci_char + ( asci_count % 26) ) );
                //генерация кода символа, учитывая его смещение от 65 символа
                //                
                buffer_label = new Label(buffer); //25 % 10 = 5
                grid.add(buffer_label, i, j, 1, 1);
                vij_table[i][j] = buffer;
                
                asci_count++;
            }
            asci_count++;
        }
        
        
        Scene scene = new Scene(grid, wight, heigth);
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
//возможно создание методов для генерации грида и генерации/заполнения массива, но считаю, что они не нужны при однократной генерации.
//и дальнейшем использовании лишь единожды
    
    private static void code(String[][] vjTable, String message, String code_key){
        //nothing yet;
        //используем таблицу Вижнера, сгенерированную где-то ранее, что бы
        //кодировать сообщение message c помощью ключа code_key
    }
    
    private static void decode(String[][] vjTable, String message, String code_key){
        //nothing yet
        //используем таблицу, что бы декодировать сообщение message
        //с помощью ключа code_key 
    }
    
    private static char findSymbol(String codeString, String code_key){
        //находим символ, соответствующий букве из шифрокода
        //примерно - поиск индекса символа в одномерном массиве и 26 букв пендосского алфавита
        //нужен поиск 2 индексов - два раза для i и j
        
        //запуск функции для подмены символа в шифротексте на символ[i,j] из таблицы вижнера
        return (char) 127; //127 - аски символ крышечки. Такой символ не будет поддерживаться (в теории даже удаляться из строки)
    }
    
    private static char changeSymbol(String codeString, int i,int j, char code_char){
        return (char) 127; //see below about 127
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
