package util;

import entity.Post;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import service.PostService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/10.
 */
public class MethodUtil {
    public static List<Post> getPosts() {
        String path = "config\\applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
        PostService postService = (PostService) applicationContext.getBean("postService");
        List<Post> posts = postService.showPosts();

        return posts;

    }

    public static void close(FileOutputStream fos, FileInputStream fis) {
        if (fos != null) {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("fos关闭失败");
            }
        }
        if (fis != null) {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("fis关闭失败");
            }
        }


    }


    public static void upload(String uploadPath, String saveName, File file) {
        if (!new File(uploadPath).exists()) {
            new File(uploadPath).mkdirs();
        }

        File saveFile = new File(uploadPath, saveName);
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(saveFile);
            byte buffer[] = new byte[1024];
            int length = 0;
            while ((length = fis.read(buffer)) > 0) {

                fos.write(buffer, 0, length);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("文件上传失败");
        } finally {
            close(fos, fis);
        }

    }


}
