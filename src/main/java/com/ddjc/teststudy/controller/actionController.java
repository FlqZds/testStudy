package com.ddjc.teststudy.controller;

import com.ddjc.common.RESTFUL.R;
import com.ddjc.common.RESTFUL.ResponseEnum;
import com.ddjc.teststudy.common.ano.emPowerment;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/check")
@Data
@Slf4j
public class actionController {

    //    @emPowerment(value = "TEST_AUDIT")
    @GetMapping("admin/aduit")
    public R approval_test001(HttpServletRequest request) {
        log.info("审批测试001");
        return new R(ResponseEnum.SUCCESS, null);
    }


    @Autowired
    private com.ddjc.teststudy.service.implement.fileImplement fileImplement;

    //传本地
    @PostMapping("admin/uploadLocal")
    public R uploadLocal(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        log.info("Servlet的请求路径：" + request.getServletPath() + "某个目录的路径：" + request.getServletContext().getRealPath("/"));

        String fileName = file.getOriginalFilename();
        log.info("上传的文件名：" + fileName);
//        String filePath = request.getServletContext().getRealPath("/");
        String filePath = "D:"+File.separator+"uplo";
        try {
            file.transferTo(new java.io.File(filePath+ File.separator+fileName));
        }
        catch (IOException ioException) {
            log.error("上传文件失败：" + ioException.getMessage());
            return new R(ResponseEnum.LOCAL_UPLOAD_ERROR, ioException.getMessage());
        }

        return new R(ResponseEnum.SUCCESS, null);
    }

    //下载本地文件
    @GetMapping("admin/downloadLocal")
    public R downloadLocal(HttpServletResponse resp, @RequestParam("fileName") String fileName) {
        log.info("下载测试001");

        resp.setHeader("Content-Type", "application/octet-stream"); // 设置头信息，告诉浏览器这是个文件
        resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);//告诉下载的文件名称

        String filePath = "D:"+File.separator+"uplo"+File.separator+fileName; //本地文件路径
//        log.info("下载的文件路径：" + fileName);
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            IOUtils.copy(fileInputStream, resp.getOutputStream());
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            log.error("文件未找到：" + e.getMessage()); //日志记录
            return new R(ResponseEnum.LOCAL_DOWNLOAD_NOT_FOUND_ERROR, null); //给前端的错误信息
        } catch (IOException ioException) {
            log.error("下载文件失败：" + ioException.getMessage());
            return new R(ResponseEnum.LOCAL_DOWNLOAD_ERROR, null);
        }
        return new R(ResponseEnum.SUCCESS, null);
    }


    @emPowerment(value = "TEST_SEARCH")
    @GetMapping("/search")
    public R search_test001() {
        log.info("搜索测试001");
        return new R(ResponseEnum.SUCCESS, null);
    }
}