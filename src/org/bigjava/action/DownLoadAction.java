package org.bigjava.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;
public class DownLoadAction {
    public String ImgName;//图片名称
    public String ImgUrl;//下载图片的路径

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    public String getImgName() {
        return ImgName;
    }

    public void setImgName(String imgName) {
        this.ImgName = imgName;
    }

    private InputStream inputStream;
    private String fileName;//文件名随意
    public InputStream getInputStream() {
        return inputStream;
    }
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    /**
     *
     * @return
     * @throws Exception
     * 这里强调一下：首先，在你的当前工程下先得存在/images这么个文件夹
     * 其次里面得有一张叫fileName的图片  不然到哪里去下载（我们的代码是要放到服务器上去的）
     */
    public String execute() throws Exception{
        System.out.println("图片名"+ImgName+"图片路径+"+ImgUrl);
        fileName = ImgName;
        //inputStream = ServletActionContext.getServletContext().getResourceAsStream("E:\\userim\\image\\admin\\1.jpg");

        ImgUrl="E:"+ImgUrl;
        System.out.println("图片最新路径"+ImgUrl);
        File file=new File(ImgUrl);
        inputStream=new FileInputStream(file);
        //设置下载文件名  别整中文哈 我这用的是UUID生成随机名字
        fileName = UUID.randomUUID()+".jpg";
        /*
        //如果实在是需要中文怎么办呢
        fileName = "aads.jpg";
        //先用当前编码将其打散
        byte[] bytes = fileName.getBytes("utf-8");
        //然后用服务端的编码组装起来
        fileName = new String(bytes,"ISO-8859-1");
        */
        return "success";
    }
}

