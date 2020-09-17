package 面试相关._finalize;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/11 17:49
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC save = null;

    @Override
    protected void finalize() {

    }
}
