import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonStorage {

    public static void saveStudent(Student s) {
        try {
            File file = new File("students.json");
            List<String> students = new ArrayList<>();

            // 1. Read existing data (clean JSON structure)
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;

                while ((line = reader.readLine()) != null) {
                    line = line.trim();

                    // ❌ skip JSON array brackets
                    if (line.equals("[") || line.equals("]") || line.isEmpty()) {
                        continue;
                    }

                    // ❌ remove trailing commas
                    if (line.endsWith(",")) {
                        line = line.substring(0, line.length() - 1);
                    }

                    students.add(line);
                }

                reader.close();
            }

            // 2. Add new student
            students.add(s.toJson());

            // 3. Rewrite file as proper JSON array
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write("[\n");

            for (int i = 0; i < students.size(); i++) {
                writer.write("  " + students.get(i));
                if (i < students.size() - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }

            writer.write("]");
            writer.close();

            System.out.println("✅ Student saved as JSON array!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}