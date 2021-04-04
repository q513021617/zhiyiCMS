package cn.botian.cloud.Controller;

import cn.botian.cloud.Model.Photo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/api/file")
public class FileController {

    @PostMapping("/upload")
    public HashMap upload(@RequestParam("photo") MultipartFile file){
        if (file.isEmpty()) {
            HashMap<String,String> map=new HashMap<>();
            map.put("msg","上传失败，请选择文件");
            map.put("filepath","");
            return map;
        }


        String fileName = file.getOriginalFilename();
        String filePath = "D:/wwwroot/www.solution.com/images/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            HashMap<String,String> map=new HashMap<>();
            map.put("msg","上传成功");
            map.put("filepath","http://www.solution.com/images/" + fileName);
            return map;
        } catch (IOException e) {
                e.printStackTrace();
        }
        HashMap<String,String> map=new HashMap<>();
        map.put("msg","上传失败");
        return map;

    }
}
