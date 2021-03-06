import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 递归读取某个目录下的所有文件
 *
 * @author Lingakg
 * @Date 2018年08月22日,下午13:20:00
 * @motto 用代码行数来评估程序的开发进度，就好比是拿重量来评估一个飞机的建造进度。
 * @Version 1.0
 */
public class ReadFile {
    private String filterName;

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    private String targetName;
    private void test(String fileDir) {
        List<File> fileList = new ArrayList<File>();
        File file = new File(fileDir);
        File[] files = file.listFiles();// 获取目录下的所有文件或文件夹
        if (files == null) {// 如果目录为空，直接退出
            return;
        }
        // 遍历，目录下的所有文件
        for (File f : files) {
            if (f.isFile()) {
                String pattern = ".*."+this.targetName+".*";
                if(Pattern.matches(pattern,f.getAbsolutePath())){
                    fileList.add(f);
                }
            }
            if(f.isDirectory()){
                String pattern = ".*"+this.filterName+".*";
                if(!(Pattern.matches(pattern, f.getAbsolutePath()))){
                    test(f.getAbsolutePath());
                }
            }
        }
        for (File f1 : fileList) {
            System.out.println(f1);
        }
    }

    public static void main(String[] args) {
        ReadFile rf = new ReadFile();
        rf.setFilterName("node_modules");
        rf.setTargetName(".png");
        rf.test("F:/H5/xiangqiandai_and_download");
    }
}