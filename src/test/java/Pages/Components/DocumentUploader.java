package Pages.Components;
import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.net.URL;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DocumentUploader {
    public void upload(String fileName){
        URL resource = getClass().getClassLoader().getResource("files/" + fileName);
        if(resource == null){
            throw new RuntimeException(("Файл не найден: "+ fileName));
        }
        File file = new File(resource.getFile());

        SelenideElement fileInput = $(byXpath("//span[@class='ant-upload ant-upload-btn']/input"));
        fileInput.uploadFile(file);
    }
}
