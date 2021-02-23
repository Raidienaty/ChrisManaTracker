package develop;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DataRequest
{
    private String saveDataPath;
    private List<SaveData> saveDataList;

    public List<SaveData> loadSaveData() throws IOException
    {
        saveDataPath = (saveDataPath == null) ? "saveData.json": saveDataPath;

        InputStream inputStream = new FileInputStream("src/develop/resources/" + saveDataPath);

        String saveData = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

        this.saveDataList = new Gson().fromJson(saveData, new TypeToken<ArrayList<SaveData>>(){}.getType());

        return this.saveDataList;
    }

    public void saveSaveDataList(List<SaveData> saveDataList) throws IOException
    {
        Gson gson = new Gson();

        String path = String.format("%s/%s/%s", System.getProperty("user.dir"), "/src/", this.getClass().getPackage().getName().replace(".", "/"));

        FileWriter fileWriter = new FileWriter(path + "/resources/saveData.json");

        gson.toJson(saveDataList, fileWriter);

        fileWriter.close();
    }

    public void setSaveDataPath(String saveDataPath)
    {
        this.saveDataPath = saveDataPath;
    }
}
