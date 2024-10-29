package practise;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;
@WebServlet("/verifycode")
public class verifycode  extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width=160;
        int height=45;
        //1 创建验证码图片对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //2 美化图片 创建画笔对象
        Graphics g = image.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0,0,width,height);
        String str = "123456789qwerasdf";
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            Color c = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            g.setColor(c);
            g.drawString(ch+"",width/5*i,height/3);
        }
        //生成干扰线
        g.setColor(Color.cyan);
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            Color c = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            g.setColor(c);
            g.drawLine(x1, y1, x2, y2);
        }
        ImageIO.write(image, "jpg", response.getOutputStream());
    }
}
