package com.hospital.hospitalserver.controller;

import com.hospital.hospitalserver.util.Response;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@Slf4j
@CrossOrigin
public class FileController {

    //图片存放的相对于项目的相对位置
    final static String PIC_PATH = "static/img/";
    final static String DEL_PATH = "src/main/resources/static/";

//    @Autowired
//    UserService userService;

    /**
     * 头像上传接口
     */
    @PostMapping("/file/uploadAvatar")
    public Response uploadAvatar(@RequestParam("file") MultipartFile file,
                                 HttpServletRequest request) {
        return uploadFile(file, request, "avatar");
    }

    /**
     * 个人照片上传接口
     */
    @PostMapping("/file/uploadPhoto")
    public Response uploadPhoto(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        return uploadFile(file, request, "photo");
    }

    /**
     * 图书封面照片上传
     * */
    @PostMapping("/file/uploadBookCover")
    public Response uploadBookCover(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        return uploadFile(file, request, "book");
    }

    /**
     * 统一的文件上传处理方法
     */
    private Response uploadFile(MultipartFile file, HttpServletRequest request, String type) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePrefix = dateFormat.format(new Date());
        String savePath = "src/main/resources/" + PIC_PATH + type + "/";

        File folder = new File(savePath + datePrefix);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }

        try {
            // 检查文件是否为空
            if (file.isEmpty()) {
                return new Response(401, "上传文件不能为空", null);
            }

            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null || originalFilename.trim().isEmpty()) {
                return new Response(401, "文件名不能为空", null);
            }

            // 验证文件类型
            String fileExt = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
            if (!".jpg".equals(fileExt) && !".jpeg".equals(fileExt) && !".png".equals(fileExt)) {
                return new Response(401, "只支持JPG、JPEG和PNG格式的图片", null);
            }

            // 验证文件大小（限制为2MB）
            long fileSize = file.getSize();
            if (fileSize > 2 * 1024 * 1024) {
                return new Response(401, "文件大小不能超过2MB", null);
            }

            // 生成新的文件名
            String saveName = UUID.randomUUID().toString() + fileExt;
            String absolutePath = folder.getAbsolutePath();

            File fileToSave = new File(absolutePath + File.separator + saveName);
            file.transferTo(fileToSave);

            // 返回可访问的URL路径
            String returnPath = request.getScheme() + "://"
                    + request.getServerName() + ":" + request.getServerPort()
                    + "/img/" + type + "/" + datePrefix + "/" + saveName;

            log.info("文件上传成功: {}", returnPath);
            return new Response(200, "上传成功", returnPath);

        } catch (Exception e) {
            log.error("文件上传失败: ", e);
            return new Response(401, "上传失败: " + e.getMessage(), null);
        }
    }

    /**
     * 删除已上传的图片
     */
    @PostMapping("/deleteImage")
    public Response deleteImage(@RequestParam String imageUrl) {
        try {
            String[] urlParts = imageUrl.split("/");
            if (urlParts.length < 2) {
                return new Response(401, "无效的图片URL", null);
            }

            String urlImg = String.join("/", urlParts[urlParts.length - 3],
                    urlParts[urlParts.length - 2],
                    urlParts[urlParts.length - 1]);
            String url = DEL_PATH + "img/" + urlImg;

            File fileToDelete = new File(url);
            if (!fileToDelete.exists()) {
                return new Response(404, "图片不存在", imageUrl);
            }

            if (fileToDelete.delete()) {
                return new Response(200, "删除成功", imageUrl);
            } else {
                return new Response(401, "删除失败", imageUrl);
            }

        } catch (Exception e) {
            return new Response(401, "删除失败: " + e.getMessage(), null);
        }
    }
}
