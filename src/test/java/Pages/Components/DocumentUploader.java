package Pages.Components;
import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DocumentUploader {
    public void upload(String fileName){
        URL resource = getClass().getClassLoader().getResource("files/" + fileName);
        if(resource == null){
            throw new RuntimeException(("Файл не найден: "+ fileName));
        }
        File file;
        try {
            file = Paths.get(resource.toURI()).toFile();
        }catch (Exception e){
            throw new RuntimeException("Ошибка преобразования пути к файлу: " +e.getMessage());
        }

        SelenideElement fileInput = $(byXpath("//span[@class='ant-upload ant-upload-btn']/input"));
        fileInput.uploadFile(file);
    }
}
