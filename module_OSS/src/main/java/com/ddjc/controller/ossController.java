package com.ddjc.controller;

import com.ddjc.common.RESTFUL.ResponseEnum;
import com.ddjc.common.RESTFUL.Result;
import com.ddjc.teststudy.common.ano.checkLogin;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class ossController {

    @Autowired
    private com.ddjc.service.implement.fileImplement fileImplement;



    // 文件上传 oss服务器
    @checkLogin
    @PostMapping("/upload")
    public Result upload_test001(@RequestParam("file") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();

        String module = "avatar";

        String url = fileImplement.upload(inputStream, originalFilename, module);
        return new Result(ResponseEnum.SUCCESS, url);
    }


    //传本地
    @PostMapping("admin/uploadLocal")
    public Result uploadLocal(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        log.info("Servlet的请求路径：" + request.getServletPath() + "某个目录的路径：" + request.getServletContext().getRealPath("/"));

        String fileName = file.getOriginalFilename();
        log.info("上传的文件名：" + fileName);
//        String filePath = request.getServletContext().getRealPath("/");
        String filePath = "D:"+ File.separator+"uplo";
        try {
            file.transferTo(new java.io.File(filePath+ File.separator+fileName));
        }
        catch (IOException ioException) {
            log.error("上传文件失败：" + ioException.getMessage());
            return new Result(ResponseEnum.LOCAL_UPLOAD_ERROR, ioException.getMessage());
        }

        return new Result(ResponseEnum.SUCCESS, null);
    }


}
