package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码
 */
@WebServlet("/verifyCode")
public class VerifyCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 160;
        int height = 50;
        // 创建验证码图片对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 美化图片，创建画笔对象
        Graphics g = image.getGraphics();

        // 设置背景颜色
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);

        // 画边框
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width - 1, height - 1);

        String str = "123456789abcdefghijklmnpqrstuvwxyz";
        // 生成随机角标
        Random random = new Random();

        // 设置字体
        Font font = new Font("Arial", Font.BOLD, 28); // 字体调整为28
        g.setFont(font);

        // 生成6位验证码
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(str.length());
            // 获取随机字符
            char ch = str.charAt(index);
            captcha.append(ch);
            // 设置字体颜色
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            g.setColor(color);
            // 填写验证码
            g.drawString(String.valueOf(ch), (width / 6) * i + 10, height / 2 + 10);
        }

        // 生成干扰线
        for (int i = 0; i < 8; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256), 100)); // 半透明
            g.drawLine(x1, y1, x2, y2);
        }

        // 添加噪点
        for (int i = 0; i < 50; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256), 50)); // 半透明
            g.fillRect(x, y, 2, 2); // 噪点为小矩形
        }

        // 将验证码图片展示到页面上
        resp.setContentType("image/jpeg");
        ImageIO.write(image, "jpg", resp.getOutputStream());

        // 释放资源
        g.dispose();
        //获得session对象
        HttpSession session = req.getSession();
        //将验证码存入session
        session.setAttribute("verify-code",captcha);
        //打印存入的验证码
        System.out.println(captcha);
    }
}
