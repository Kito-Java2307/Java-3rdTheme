import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // ①String型ListまたはMapを利用
        // ②例外の発生

        // 名前リストと番号リスト生成・初期化（①）
        List<String> nameList = new ArrayList<>();
        List<String> numList = new ArrayList<>();
        // 名前テキストから名前リストに格納（①）
        try {
            nameList = Files.readAllLines(Paths.get
                    ("D:\\RaiseTech\\Java\\3\\HuntersNameList.txt"));
            nameList.add("ヒソカ");
        } catch (IOException e) {
            System.out.println("名前リストが見つかりません。");
            e.printStackTrace();
        }
        // 番号テキストから番号リストに格納（①）
        try {
            numList = Files.readAllLines(Paths.get
                    ("D:\\RaiseTech\\Java\\3\\HuntersNumberList.txt"));
            numList.add("44");
        } catch (IOException e) {
            System.out.println("番号リストが見つかりません。");
            e.printStackTrace();
        }
        // 名前リストと試験番号を紐づけたマップを生成（①）
        Map<String, String> huntersList = new HashMap<>();
        for (int i = 0; i < nameList.size(); i++) {
            huntersList.put(nameList.get(i), numList.get(i));
        }
        // マップをコンソール出力（①）
        for (int i = 0; i < huntersList.size(); i++) {
            int j = i + 1;
            System.out.println("【" + j + "人目】名前：" + nameList.get(i)
                    + " 番号：" + huntersList.get(nameList.get(i)));
        }
        // リストにないものを利用（②）
        int exNum = nameList.size() + 1;
        System.out.print("【" + exNum + "人目】");
        try {
            System.out.println("名前：" + nameList.get(nameList.size()));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("リストに" + exNum + "人目は存在しません");
            e.printStackTrace();
        }
    }
}