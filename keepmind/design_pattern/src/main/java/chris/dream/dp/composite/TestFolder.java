package chris.dream.dp.composite;

/**
 * @author Chris
 * @description: <p>组合模式</p>
 * @date 下午 1:54 2018-08-14
 */
public class TestFolder extends AbstractComponent {
    private AbstractComponent[] files;

    private String folderName;

    public void scan(){
        for ( AbstractComponent f : files){
            if ( f instanceof TestFile){
                System.out.println("File "+((TestFile) f).fileName);
            }else if(f instanceof TestFolder){
                TestFolder e = (TestFolder)f ;
                System.out.println("Folder " + e.folderName);
                e.scan();
            }
        }
    }
}
