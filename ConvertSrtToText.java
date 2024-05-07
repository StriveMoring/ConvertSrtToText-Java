import java.io.*;


public class ConvertSrtToText {
    public static void main(String[] args) {
        String inputFile = "C:/Users/username/Desktop/example.srt";  // 输入文件路径
        String outputFile = "C:/Users/username/Desktop/example.txt";  // 输出文件路径

        try {
            File input = new File(inputFile);
            BufferedReader reader = new BufferedReader(new FileReader(input));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                // 如果是序号或时间码，就跳过
                if (line.matches("\\d+") || line.matches("\\d{2}:\\d{2}:\\d{2},\\d{3}\\s-->\\s\\d{2}:\\d{2}:\\d{2},\\d{3}") || "".equals(line)) {
                    continue;
                }
                writer.write(line + "\n");  // 写入文本信息
            }

            reader.close();
            writer.close();
            System.out.println("Done.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
