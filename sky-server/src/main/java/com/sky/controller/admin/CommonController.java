package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/*
* 通用接口
* */
@RestController
@RequestMapping("admin/common")
@Api(tags = "通用接口")
@Slf4j
public class CommonController {

    /*
     * 文件上传
     * */
    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file) throws IOException {
        log.info("文件上传:{}", file);

        // 获取上传文件的原始文件名
        String fileName = file.getOriginalFilename();
        //获取文件扩展名
        String substring = fileName.substring(fileName.lastIndexOf("."));
        String s = UUID.randomUUID().toString() + substring;

        // 设置文件的保存路径，需要替换为实际的目录路径
        String filePath = "C:\\D\\Code\\javaStuday\\project1\\sky-take-out\\sky-server\\src\\main\\java\\file";

        // 创建代表目标文件的File对象，结合文件路径和文件名
        File destFile = new File(filePath, s);

        try (InputStream in = file.getInputStream();  // 获取文件输入流
             FileOutputStream out = new FileOutputStream(destFile)) {  // 创建文件输出流

            // 创建一个字节缓冲区，用于临时存储从输入流中读取的数据
            byte[] buffer = new byte[4096];
            // 用于存储从输入流中读取的字节数
            int bytesRead;

            // 循环读取输入流，直到文件结束
            while ((bytesRead = in.read(buffer)) != -1) {
                // 将读取的数据写入到文件输出流中
                out.write(buffer, 0, bytesRead);
            }

            // 如果文件写入成功，记录日志并返回成功消息
            log.info("文件上传成功，文件路径: {}", destFile.getAbsolutePath());
            return Result.success(filePath+s);
        } catch (IOException e) {
            // 如果发生I/O异常，记录错误日志并返回失败消息
            log.error("文件写入失败", e);
            return Result.error(MessageConstant.UPLOAD_FAILED);
        }
    }
}
