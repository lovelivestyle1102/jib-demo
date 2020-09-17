/**
 * Created with IntelliJ IDEA.
 * @author: yangchenglong
 * Date: 2020/9/2
 * Time: 12:20 下午
 * Description: 
*/
public class ThrowsExceptionTest {

    public static void main(String[] args) {
        int i = 0;
        try {
            if (i != 0) {
                throw new RuntimeException("test");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
