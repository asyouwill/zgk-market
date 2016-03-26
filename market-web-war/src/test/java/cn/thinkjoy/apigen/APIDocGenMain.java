//package cn.thinkjoy.apigen;
//
//import cn.thinkjoy.common.restful.apigen.ApiDocCollector;
//import cn.thinkjoy.common.restful.apigen.domain.ApiDoc;
//import freemarker.template.Configuration;
//import freemarker.template.Template;
//import freemarker.template.TemplateException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.io.*;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * TODO 一句话描述该类用途
// * <p/>
// * 创建时间: 15/4/5 下午8:28<br/>
// *
// * @author qyang
// * @since v0.0.1
// */
//public class APIDocGenMain {
//    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-apigen.xml");
//        ApiDoc apiDoc = ((ApiDocCollector)applicationContext.getBean("apiDocCollector")).collectData();
//
//        genDoc(apiDoc);
//    }
//
//    public static void genDoc(ApiDoc apiDoc){
//        Configuration cfg = new Configuration();
//        //cfg.setClassForTemplateLoading(APIDocGenMain.class, "apidoc");
//        cfg.setDefaultEncoding("UTF-8");
//
//        String rootPath = "//Users/qyang/works/workspace/pc/pc-credit/credit-web-war/src/test/resources/apidoc/";
//        Writer out = null;
//        try {
//            Template template = cfg.getTemplate("credit-web-war/src/test/resources/apidoc/apidoc.ftl");
//            File file = new File(rootPath +"apidoc.html");
//            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
//            Map<String, Object> root = new HashMap<String, Object>();
//            root.put("apiDoc", apiDoc);
//            template.process(root, out);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }finally{
//            try {
//                out.flush();
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//}
