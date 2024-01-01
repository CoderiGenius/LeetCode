package utils;

/**
 * @author CoderiGenius
 * @version 2023/12/31 01:35
 */
import java.util.Arrays;

public class StringTo2DArray {

    public static int[][] parseStringToArray(String input) {
        // 去除字符串中的 "[[" 和 "]]"，以及空格
        String trimmed = input.replaceAll("\\[\\[", "").replaceAll("]]", "").replaceAll(" ", "");

        // 根据逗号分隔符将字符串分割为子字符串数组
        String[] rows = trimmed.split("\\],\\[");

        // 创建二维数组来存储解析后的数据
        int[][] result = new int[rows.length][];

        // 遍历子字符串数组，解析并填充二维数组
        for (int i = 0; i < rows.length; i++) {
            String[] elements = rows[i].split(",");
            result[i] = new int[elements.length];
            for (int j = 0; j < elements.length; j++) {
                if ("".equals(elements[j])) {
                    continue;
                }
                result[i][j] = Integer.parseInt(elements[j]);
            }
        }
        return result;
    }
}

