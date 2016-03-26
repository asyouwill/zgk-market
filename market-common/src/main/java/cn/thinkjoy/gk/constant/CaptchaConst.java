package cn.thinkjoy.gk.constant;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by clei on 15/7/21.
 */
public class CaptchaConst {
    /**
     * 默认图片大小
     */
    public static final BufferedImage DEFAULT_IMAGE = new BufferedImage(CaptchaConst.PIC_WIDTH,CaptchaConst.PIC_HEIGHT,BufferedImage.TYPE_INT_BGR);
    /**
     * 图片宽
     */
    public static final int PIC_WIDTH = 120;
    /**
     * 图片高
     */
    public static final int PIC_HEIGHT = 46;
    /**
     * 随机产生字符数量
     */
    public static final int RANDOM_STRING_NUM = 4;
    /**
     * 图片字体颜色紫色
     */
    public static final Color PURPLE_COLOR = new Color(147,41,140);
    /**
     * 随机的字符串
     */
    public static final String RAND_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * 随机的字符串
     */
    public static final String RAND_NUM_STRING = "0123456789";
    /**
     * 字体
     */
    public static final Font BASE_FONT = new Font("宋体",Font.CENTER_BASELINE,34);
    /**
     * Bernard MT 字体
     */
    public static final Font FONT_BERNARD = new Font("Bernard MT",Font.CENTER_BASELINE,34);
    /**
     * 楷体
     */
    public static final Font FONT_KAITI = new Font("楷体",Font.CENTER_BASELINE,34);
    /**
     * 新罗马
     */
    public static final Font FONT_NEWROMAN = new Font("Times New Roman",Font.CENTER_BASELINE,34);

    public static final Font FIXEDSYS = new Font("Fixedsys", Font.BOLD, 34);
    /**
     * 字体数组
     */
    public static final Font [] BASE_FONTS = {BASE_FONT,FONT_BERNARD,FONT_KAITI,FIXEDSYS,FONT_NEWROMAN};

    /**
     * 输出图片类型
     */
    public static final String JPEG = "JPEG";
    /**
     * 字体间距
     */
    public static final int FONT_SPACING = 20;

    /**
     * 坐标变换的距离
     */
    public static final int TRANSLATE_START = 35;

    /**
     * 验证码时长
     */
    public static final int CAPTCHA_TIME = 60;
}
