package com.hzz.notecloudbackend.controller;

import com.hzz.notecloudbackend.common.api.ApiResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/note-cloud/note")
public class NoteController {
    public final static String UPLOAD_PATH_PREFIX = "static/notes/";

    @PostMapping(value = "/upload")
    private ApiResult<String> upload(@RequestParam Map<String, MultipartFile> map) throws IOException {
        MultipartFile file = map.get("raw");
        if (file != null) {
            String realPath ="src/main/resources/" + UPLOAD_PATH_PREFIX;
            File fileDir = new File(realPath);
            if (!fileDir.exists()) {
                //生成文件夹
                fileDir.mkdirs();
            }
            // 获取文件名，对文件名还没有优化，存在中文名等文件名问题
            String filename = file.getOriginalFilename().replace(" ", "");

            //构建真实的文件路径
            File newFile = new File(fileDir.getAbsolutePath() + File.separator + filename);
            //转存文件到指定路径，如果文件名重复的话，将会覆盖掉之前的文件,这里是把文件上传到 “绝对路径”
            file.transferTo(newFile);

            return ApiResult.success("success");
        }
        return ApiResult.failed("fail");
    }

    @RequestMapping("test")
    private ApiResult<String> test() {
        return ApiResult.success("test");
    }
}
