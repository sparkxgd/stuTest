package demo;
import com.jfinal.core.Controller;
public class HelloController extends Controller {
    public void index() {
       renderText("Hello JFinal World.");
    }
    /**
     * �򿪵�¼ҳ��
     */
    public void openlogin() {
    	render("login.html");
    }
    /**
     * ��¼
     */
    public void login() {
    	String username=getPara("username");
    	String password=getPara("password");
    	
    	String user="201704";
    	String pw="123";
    	
    	if(username.equals(user)) {
    		if(password.equals(pw)) {
    			setAttr("result", 0);//������ȷ
    			renderJson();
    		}else {
    			setAttr("result", 1);//�������
    			renderJson();
    		}
    	}else {
    		setAttr("result", -1);//�û���������
			renderJson();
    	}
    }
    /**
     * ������ҳ��
     */
    public void openmain() {
    	render("index.html");
    }
}